package com.example.stack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stack.model.Company;
import com.example.stack.repository.CompanyRepository;

@Service
public class CompanyServiceImpl  implements CompanyService{

	@Autowired
	CompanyRepository companyRepo;

	@Override
	public Company addCompany(Company company) 
	{

		companyRepo.saveAndFlush(company);
		return company;

	}

	@Override
	public boolean deleteCompany(int companyCode) {
		companyRepo.deleteById(companyCode);
		return true;
	}

	@Override
	public boolean updateCompany(Company company) {
		Company company1 = companyRepo.getById(company.getCompanyCode());
		if(company1!=null)
		{
			company1.setCompanyCEO(company.getCompanyCEO());
			companyRepo.saveAndFlush(company1);

		}
		return true;
	} 

	@Override
	public List<Company> getAllCompany() {

		List<Company> companyList = companyRepo.findAll();
		if(companyList!=null && companyList.size()>0)
		{
			return companyList;
		}
		return null;
	}



}
