package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Employee;
import com.java.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {

       Optional<Employee> optional = employeeRepository.findById(id);
	   Employee employee= null;
	   if(optional.isPresent()) {
		   employee=optional.get();
	   }else {
		   throw new RuntimeException("Employee not found by id:"+ id);
	   }
	   return employee;
	   
	}

	@Override
	public void deleteEmployeeById(long id) {
		
		this.employeeRepository.deleteById(id);
		
	}
	
	
	

	
}
