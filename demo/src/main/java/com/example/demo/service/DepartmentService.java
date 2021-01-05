package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.entity.Department;
import com.example.demo.request.DepartmentRequest;

@Service
public class DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	private static final String success = "success";
	
	private static final String errorDepartmentId = "查無部門ID";
	
	public String addDepartment(DepartmentRequest requestData){	
		Department department = new Department();
		org.springframework.beans.BeanUtils.copyProperties(requestData, department);
		departmentRepository.save(department);
		return success;
	}
	
	public String updateDepartment(DepartmentRequest requestData) {
		Optional<Department> oDepartment = departmentRepository.findById(requestData.getId());
		if(oDepartment.isPresent()) {
			Department department = new Department();
			org.springframework.beans.BeanUtils.copyProperties(requestData, department);		
			departmentRepository.save(department);
			return success;
		}else {
			return errorDepartmentId;
		}
	}
	
	public String deletDepartment(String departmentId) {
		Optional<Department> oDepartment = departmentRepository.findById(departmentId);
		if(oDepartment.isPresent()) {
			departmentRepository.delete(oDepartment.get());
			return success;
		}else {
			return errorDepartmentId;
		}		
	}
}