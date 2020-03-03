package com.accenture.companymanagement.persistance;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.companymanagement.domain.CompanyEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompaniesRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

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
}
