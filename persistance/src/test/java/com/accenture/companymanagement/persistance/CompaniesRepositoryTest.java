package com.accenture.companymanagement.persistance;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.companymanagement.domain.CompanyEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompaniesRepositoryTest {

	@Autowired
	private CompaniesRepository repository;

	@Test
	public void saveCompanyToDB() {
		CompanyEntity companyEntity = new CompanyEntity("Accenture", "Kronberg", "0265 - 65 98 65");
		repository.save(companyEntity);

		List<CompanyEntity> companies = (List<CompanyEntity>) repository.findAll();
		Assert.assertNotNull(companies);
		Assert.assertEquals(1, companies.size());
	}
	
	@Test
	public void findByNameAndLocation() {
		CompanyEntity companyEntity = new CompanyEntity("Accenture", "Kronberg", "0265 - 65 98 65");
		repository.save(companyEntity);
		companyEntity = new CompanyEntity("Accenture", "Kronberg", "0265 - 65 98 65");
		repository.save(companyEntity);
		
		List<CompanyEntity> companies = (List<CompanyEntity>) repository.findByNameAndLocation("Accenture", "Kronberg");
		Assert.assertNotNull(companies);
		Assert.assertEquals(2, companies.size());
	}
	
	@Test
	public void deleteCompanyFromDB() {
		CompanyEntity companyEntity = new CompanyEntity("Accenture", "Kronberg", "0265 - 65 98 65");
		companyEntity = repository.save(companyEntity);
		companyEntity = new CompanyEntity("Umbrella", "Kronberg", "0265 - 65 98 65");
		companyEntity = repository.save(companyEntity);
		companyEntity = new CompanyEntity("Acme Inc.", "Kronberg", "0265 - 65 98 65");
		companyEntity = repository.save(companyEntity);
		
		List<CompanyEntity> companies = (List<CompanyEntity>) repository.findAll();
		Assert.assertNotNull(companies);
		Assert.assertEquals(3, companies.size());
		
		repository.deleteById(companyEntity.getId());
		
		Assert.assertEquals(2, ((List<CompanyEntity>) repository.findAll()).size());
	}
}
