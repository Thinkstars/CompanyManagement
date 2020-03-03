package com.accenture.companymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.companymanagement.data.Company;
import com.accenture.companymanagement.domain.CompanyEntity;
import com.accenture.companymanagement.persistance.CompaniesRepository;

@Service
public class CompanyService {

	static List<Company> companiesList = new ArrayList<>();
	static {
		companiesList.add(new Company(1l, "Acme Inc.", "New York", "+1 345 679898"));
		companiesList.add(new Company(2l, "Umbrella Inc.", "Frankfurt", "+49 456 34791"));
		companiesList.add(new Company(3l, "Accenture", "Kronberg", "+49 689 98346"));		
	}

	@Autowired
	private CompaniesRepository repository;
	
	public List<Company> fetchAllCompanies() {
		return companiesList;
	}
	
	public List<Company> fetchAllFromDatabase() {
		return ObjectMapperUtils.mapAll(repository.findAll(), Company.class);
	}
	
	public boolean saveCompanyInDB(final Company company) {
		repository.save(ObjectMapperUtils.map(company, CompanyEntity.class));
		
		return true;
	}
	
	public Company fetchCompanyById(final Long id) {
		Optional<CompanyEntity> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			CompanyEntity companyEntity = optional.get();
			return ObjectMapperUtils.map(companyEntity, Company.class);
		}
		return new Company();
	}
	
	public boolean saveCompany(final Company company) {
		Company companyFound = null;
		for (Company cmp : companiesList) {
			if (cmp.getId().equals(company.getId())) {
				companyFound = cmp;
			}
		}
		companiesList.remove(companyFound);
		
		companiesList.add(company);				
		
		return Boolean.TRUE;
	}
}
