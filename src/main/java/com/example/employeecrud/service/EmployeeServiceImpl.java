package com.example.employeecrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository repository;
	
	

	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployee(Long id) {
		 repository.deleteById(id); 	
	}
	

}
