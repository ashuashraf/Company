package com.example.stack.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stack.model.Company;
@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	

}
