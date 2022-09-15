package com.lab.employee.license;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.flexnet.licensing.client.ICapabilityRequestOptions;
import com.flexnet.licensing.client.ICapabilityResponseData;
import com.flexnet.licensing.client.IFeature;
import com.flexnet.licensing.client.ILicenseManager;
import com.flexnet.licensing.client.ILicensing;
import com.flexnet.licensing.client.LicensingFactory;
import com.flexnet.lm.FlxException;
import com.flexnet.lm.SharedConstants.RequestOperation;
import com.flexnet.lm.net.Comm;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class LicenseInfoRequest {
	
	@Value("${license.server.url:http://localhost:7070/fne/bin/capability}")
	private String serverUrl;
	
	@Value("${license.hostId:#{null}}")
	private String hostId;
	
	public LicenseInfo loadLicenseInfo() throws FlxException {
		
		LicenseInfo licenseInfo = new LicenseInfo();
		
		//load Identity data, can be generated under backoffice: Administer -> Identities -> Select Identity -> Download Client Identity/Java Class File
		if(IdentityClient.IDENTITY_DATA == null) {
			log.info("License-enabled code requires client identity data, " +
								"which you create with pubidutil and printbin -java. " +
								"See the User Guide for more information.");
			return null;
		}
		
		try (ILicensing licensing = LicensingFactory.getLicensing(IdentityClient.IDENTITY_DATA, null, hostId, "capabilityrequest")) {
			ILicenseManager licenseManager = licensing.getLicenseManager();
			licenseManager.setHostType("FLX_CLIENT"); //should exist in backoffice under Administer -> Device Series
			byte[]			requestData = null;
			byte[]			responseData = null;
			
			ICapabilityRequestOptions	options = licenseManager.createCapabilityRequestOptions();
			options.forceResponse();
			options.setRequestOperation(RequestOperation.PREVIEW);
			options.requestAllFeatures(true);
			requestData = licenseManager.generateCapabilityRequest(options);
			
			responseData = talkToServer(requestData, serverUrl);
			
			if((responseData != null) && (responseData.length > 0)) {
				
				ICapabilityResponseData responseDetails = licenseManager.getResponseDetails(responseData); 
				List<IFeature> features = responseDetails.getFeatures();
				licenseInfo.setEnabled(true);
				licenseInfo.setFeatures(features);
				licenseInfo.setId(responseDetails.getHostIds().toString());
				if(!CollectionUtils.isEmpty(features)) {
					licenseInfo.setExpireDate(features.get(0).getEntitlementExpiration());
				}
				
			}
		}
		
		return licenseInfo;
		
		
	}

	private static byte[] talkToServer(byte[] request, String uri) {
	    byte[] response = null;
	    try {
	        Comm conn = Comm.getHttpInstance(uri);
	        response = conn.sendBinaryMessage(request);
	    }
	    catch (FlxException e) {
	        e.printStackTrace();
	    }
	    return response;
	}


}