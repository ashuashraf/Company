package com.example.stack.service;

import java.util.List;

import com.example.stack.model.Company;


public interface CompanyService {
	
	public Company addCompany(Company company); 
	public boolean deleteCompany(int companycode);
	public boolean updateCompany(Company company);
	public List<Company> getAllCompany();

}
