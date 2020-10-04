package com.accenture.companymanagement.persistance;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.accenture.companymanagement.domain.CompanyEntity;

@SpringBootConfiguration
@EnableJpaRepositories
@EntityScan("com.accenture.companymanagement.domain")
public class RepositoryConfiguration {

	@Bean
	public CompanyEntity companyEntity() {
		return new CompanyEntity("", "", "");
	}
}
