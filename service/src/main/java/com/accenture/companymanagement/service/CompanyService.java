package com.accenture.companymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.companymanagement.data.Company;
import com.accenture.companymanagement.domain.CompanyEntity;
import com.accenture.companymanagement.persistance.CompaniesRepository;

@Service
public class CompanyService {

//	@Autowired
	private CompaniesRepository repository;

//	@Autowired
//	public CompanyService(CompaniesRepository repository) {
//		super();
//		this.repository = repository;
//	}

	@Autowired
	public void setRepository(CompaniesRepository repository) {
		this.repository = repository;
	}
		
	public List<Company> fetchAllCompanies() {
		return ObjectMapperUtils.mapAll(repository.findAll(), Company.class);
	}
	

	public boolean saveCompanyInDB(final Company company) {
		repository.save(ObjectMapperUtils.map(company, CompanyEntity.class));
		
		return true;
	}

	public boolean deleteCompanyFromDB(final Company company) {
		repository.delete(ObjectMapperUtils.map(company, CompanyEntity.class));
		
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

}
