package com.example.mockito.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mockito.api.dao.EmployeeRepository;
import com.example.mockito.api.model.Employee;
import com.example.mockito.api.model.Response;
import com.example.mockito.api.service.EmployeeService;

@RestController
public class EmployeeController {
//	https://www.youtube.com/watch?v=IucFDX3RO9U
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/getEmployeeById/{id}")
	private Employee getEmployeeById(@PathVariable int id) {
		return empService.getEmployeebyId(id);	
	}
	
	@PutMapping("/updateEmployee")
	private Employee updateEmployee(@RequestBody Employee e) {
		return empService.updateEmployee(e);		
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	private String updateEmployee(@PathVariable int id) {
		return empService.deleteEmployee(id);		
	}
	
	@PostMapping("/addEmployee")
	private Employee addEmployee(@RequestBody Employee e) {
		return empService.save(e);		
	}
	
	@PostMapping("/addEmployees")
	private List<Employee> addEmployees(@RequestBody List<Employee> e) {
		return empService.saveAll(e);		
	}
	
	@GetMapping("/getEmployees")
	private List<Employee> getEmployees() {
		return empService.findAll();	
	}

}
