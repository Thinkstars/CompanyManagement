package com.accenture.companymanagement.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.accenture.companymanagement")
public class CompaniesApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CompaniesApplication.class, args);
	}

}
