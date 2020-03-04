package com.accenture.companymanagement.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.accenture.companymanagement.data.Company;
import com.accenture.companymanagement.domain.CompanyEntity;
import com.accenture.companymanagement.persistance.CompaniesRepository;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

	@Mock
	private CompaniesRepository repository;

	@InjectMocks
	private CompanyService service;

	@Before
	public void init() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());
	}

	@Test
	public void testFetchAllCompaniesNoDataFount() {
		List<Company> companyList = service.fetchAllCompanies();

		Assert.assertNotNull(companyList);
		Assert.assertEquals(0, companyList.size());
	}

	@Test
	public void testFetchAllCompanies() {
		List<CompanyEntity> companyList = new ArrayList<>();
		CompanyEntity compnaEntity = new CompanyEntity("Accenture", "Kronberg", "555666");
		companyList.add(compnaEntity);
		compnaEntity = new CompanyEntity("Accenture", "Kronberg", "555666");
		companyList.add(compnaEntity);

		Mockito.when(repository.findAll()).thenReturn(companyList);
		List<Company> returnedCompanyList = service.fetchAllCompanies();

		Assert.assertNotNull(returnedCompanyList);
		Assert.assertEquals(2, returnedCompanyList.size());
	}

	@Test
	public void testSaveCompanyInDB() {
		service.saveCompanyInDB(new Company(1l, "Acme Inc.", "New York", "555-666"));
		
		Mockito.verify(repository, Mockito.times(1)).save(any(CompanyEntity.class));
	}
}
