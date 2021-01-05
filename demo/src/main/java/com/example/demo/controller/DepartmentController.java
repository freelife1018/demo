package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.DepartmentRequest;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController{
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping(value = "/add")
	public String addDepartment(@RequestBody DepartmentRequest requestData){
		return departmentService.addDepartment(requestData);
	}
	
	@PutMapping(value = "/update")
	public String updateDepartment(@RequestBody DepartmentRequest requestData){
		return departmentService.updateDepartment(requestData);
	}
	
	@DeleteMapping(value = "/delete")
	public String deletDepartment(@RequestParam String departmentId){
		return departmentService.deletDepartment(departmentId);
	}
		
}
