package com.accenture.companymanagement.view.companies;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.accenture.companymanagement.data.Company;
import com.accenture.companymanagement.service.CompanyService;

@Controller
public class CompaniesController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/companies")
	public String listCompanies(final Model model) {
		model.addAttribute("welcome", "new dynamic string");
		model.addAttribute("today", new Date());
		model.addAttribute("companies", companyService.fetchAllFromDatabase());

		return "companiesList";
	}

	@GetMapping("/companies/{id}")
	public String companyDetails(@PathVariable("id") Long id, Model model) {

		model.addAttribute("company", companyService.fetchCompanyById(id));

		return "companyDetails";
	}

	@GetMapping("/companies/new")
	public String newCompany(final Model model) {
		Company company = new Company();
		model.addAttribute(company);

		return "companyDetails";
	}

	@PostMapping("/companies")
	public String modifyCompany(@ModelAttribute Company company) {
		companyService.saveCompanyInDB(company);

		return "redirect:/companies";
	}
}
