package com.accenture.companymanagement.persistance;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableJpaRepositories
@EntityScan("com.accenture.companymanagement.domain")
public class RepositoryConfiguration {

}
