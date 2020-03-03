package com.accenture.companymanagement.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.companymanagement.domain.CompanyEntity;

@Repository
public interface CompaniesRepository extends JpaRepository<CompanyEntity, Long> {

}
