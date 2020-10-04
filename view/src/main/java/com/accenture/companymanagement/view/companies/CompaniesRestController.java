package com.accenture.companymanagement.view.companies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompaniesRestController {

	@GetMapping
	public String response() {
		
		return "";
	}
}
