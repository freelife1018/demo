package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.BaseEmployeeResponse;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody EmployeeRequest requestData){
		return employeeService.addEmployee(requestData);
	}
	
	@PutMapping(value = "/update")
	public String updateEmployee(@RequestBody EmployeeRequest requestData){
		return employeeService.updateEmployee(requestData);
	}
	
	@DeleteMapping(value = "/delete")
	public String deletEmployeee(@RequestParam String employeeId){
		return employeeService.deletEmployee(employeeId);
	}

	@GetMapping(value = "/getAll")
	public List<BaseEmployeeResponse> getAllEmployee(@RequestBody(required = false) EmployeeRequest requestData){
		return employeeService.getAllEmployee(requestData);
	}
		
}
