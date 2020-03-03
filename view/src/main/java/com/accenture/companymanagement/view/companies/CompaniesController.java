package com.accenture.companymanagement.view.companies;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompaniesController {

//	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	@GetMapping("/companies")
	public String listCompanies(final Model model) {
		model.addAttribute("welcome", "new dynamic string");
		model.addAttribute("today", new Date());
		
		return "companiesList";
	}
	
	// URL -	 /companies/<ID> GET - Method
	//			 neue View z.B.: companieDetails
}
