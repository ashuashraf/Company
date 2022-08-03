package com.example.stack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stack.model.Company;
import com.example.stack.service.CompanyService;

@RestController
@RequestMapping("api/v1.0/market/company")
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/register")
	public ResponseEntity<?> getAllCompanys(){
		List<Company> companylist =companyService.getAllCompany();
		
		if(companylist!=null)
		{
			return new ResponseEntity<List<Company>>(companylist, HttpStatus.OK);
		}
		return new ResponseEntity<String>("The companylist is empty", HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteCompany/{companyCode}")
	public ResponseEntity<?> removeCompany(@PathVariable ("companyCode") int companyCode)
	{
		if(companyService.deleteCompany(companyCode))
		{
			return new ResponseEntity<String>("Company is deleted", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Company cannot be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	@PutMapping("/updateCompany")
	public ResponseEntity<?> upddateCompany(@RequestBody Company company)
	{
		if(companyService.updateCompany(company))
	{
		return new ResponseEntity<String>("Company updated successfully", HttpStatus.CREATED);
	}
	return new ResponseEntity<String>("The Company update was unsuccessful", HttpStatus.INTERNAL_SERVER_ERROR);

		
	}
	
	@PostMapping("/addCompany")
	public ResponseEntity<?> addCompany(@RequestBody Company company)
	{
		if(companyService.addCompany(company)!=null)
		{
			return new ResponseEntity<Company>(company, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("The company entry unsuccessful", HttpStatus.CONFLICT);
	}
	
	
	
	

}
