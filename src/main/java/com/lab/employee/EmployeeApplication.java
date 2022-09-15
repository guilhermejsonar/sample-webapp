package com.lab.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

import com.flexnet.lm.FlxException;
import com.lab.employee.license.LicenseInfo;
import com.lab.employee.license.LicenseInfoRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class EmployeeApplication {

	@Autowired
	BuildProperties buildProperties;

	@Autowired
	LicenseInfoRequest licenseInfoRequest;

	@Value("${license.check.enabled}")
	private boolean licenseCheck;

	public static void main(String args[]) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner() {
		return args -> {
			log.info("  Build: {}", buildProperties.getName());
			log.info("  Version: {}", buildProperties.getVersion());
		};
	}
	

	@Bean
	LicenseInfo licenseInfoEnabled() {
		if(!licenseCheck) {
			return LicenseInfo.builder().enabled(false).build();
		}else {
			LicenseInfo licenseInfo = null;
			
			try {
				licenseInfo = licenseInfoRequest.loadLicenseInfo();
			} catch (FlxException e) {
				log.error("Error loading license information.", e);
			}
			
			log.info("# ================================");
			log.info("# LICENSE INFORMATION");
			log.info("# ================================");
			log.info("  Licensed {}", licenseInfo);
			licenseInfo.explain();
			
			return licenseInfo;
		}
	}
}
