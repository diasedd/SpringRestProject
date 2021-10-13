package com.example.mockito.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mockito.api.dao.EmployeeRepository;
import com.example.mockito.api.model.Employee;

@Service
public class EmployeeService {
	@Autowired 
	EmployeeRepository repository;

	
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	public <S extends Employee> S save(S entity) {
		return repository.save(entity);
	}
	
	public Employee getEmployeebyId(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Employee getEmployeebyName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteEmployee(Integer id) {
		repository.deleteById(id);
		return "Employee "+id+" deleted";
	}
	
	public Employee updateEmployee(Employee e) {
		Employee existingEmp = repository.findById(e.getId()).orElse(null);
		existingEmp.setName(e.getName());
		existingEmp.setDesignation(e.getDesignation());
		return repository.save(existingEmp);
	}

	public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

}
