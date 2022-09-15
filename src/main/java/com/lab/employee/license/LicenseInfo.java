package com.lab.employee.license;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.flexnet.licensing.client.IFeature;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor 
@Builder
@Data
public class LicenseInfo {

	private boolean enabled;
	private String id;
	private Date expireDate;
	private List<IFeature> features;
	
	public boolean hasFeature(String featureName) {
		if(CollectionUtils.isNotEmpty(features)) {
			return features.stream().anyMatch(f->StringUtils.equals(featureName, f.getName()));
		}
		return false;
	}
	
	public long getFeatureCount(String featureName) {
		if(CollectionUtils.isNotEmpty(features)) {
			 Optional<IFeature> featureObj = features.stream().filter(f->StringUtils.equals(featureName, f.getName())).findFirst();
			 if(featureObj.isPresent()) {
				 return featureObj.get().getCount();
			 }
		}
		return 0;
	}
	
	public void explain() {
		if(CollectionUtils.isNotEmpty(features)) {
			features.forEach(feature->{
				log.info("  Feature: {}", feature.getName());
				log.info("    AvailableAcquisitionCount: {}", feature.getAvailableAcquisitionCount());
				log.info("    AcquisitionStatus: {}", feature.getAcquisitionStatus());
				log.info("    Count: {}", feature.getCount());
				log.info("    MaxCount: {}", feature.getMaxCount());
				log.info("    EntitlementExpiration: {}", feature.getEntitlementExpiration());
				log.info("    Expiration: {}", feature.getExpiration());
				log.info("    FinalExpiration: {}", feature.getFinalExpiration());
				log.info("    Issuer: {}", feature.getIssuer());
				log.info("    Version: {}", feature.getVersion());
			});
		}
	}
	
}
