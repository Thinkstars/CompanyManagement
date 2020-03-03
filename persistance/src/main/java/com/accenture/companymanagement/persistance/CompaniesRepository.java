package com.accenture.companymanagement.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.companymanagement.domain.CompanyEntity;

@Repository
public interface CompaniesRepository extends JpaRepository<CompanyEntity, Long> {

	@Query("SELECT cE FROM CompanyEntity cE WHERE cE.name=:name")
	List<CompanyEntity> findCompanyByName(@Param("name") String name);

	List<CompanyEntity> findByNameAndLocation(@Param("name") String name, @Param("location") String location);
}
