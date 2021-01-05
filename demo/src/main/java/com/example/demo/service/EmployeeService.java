package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.BaseEmployeeResponse;
import com.example.demo.response.EmployeeResponse;

@Service
public class EmployeeService  {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	private static final String success = "success";
	
	private static final String errorEmployeeId = "查無員工ID";
	
	private static final String errorDepartmentId = "查無部門ID";
	
	public String addEmployee(EmployeeRequest requestData){
		Optional<Department> oDepartment = departmentRepository.findById(requestData.getDepartmentId());
		if(oDepartment.isPresent()) {
			Employee employee = new Employee();
			org.springframework.beans.BeanUtils.copyProperties(requestData, employee);		
			employeeRepository.save(employee);
			return success;
		}else {
			return errorDepartmentId;
		}		
	}
	
	public String updateEmployee(EmployeeRequest requestData) {
		Optional<Employee> oEmployee = employeeRepository.findById(requestData.getEmployeeId());
		Optional<Department> oDepartment = departmentRepository.findById(requestData.getDepartmentId());
		if(oEmployee.isPresent()) {
			if(oDepartment.isPresent()) {
				Employee employee = new Employee();
				org.springframework.beans.BeanUtils.copyProperties(requestData, employee);		
				employeeRepository.save(employee);
				return success;
			}else {
				return errorDepartmentId;
			}		
		}else {
			return errorEmployeeId;
		}
	}
	
	public String deletEmployee(String employeeId) {
		Optional<Employee> oEmployee = employeeRepository.findById(employeeId);
		if(oEmployee.isPresent()) {
			employeeRepository.delete(oEmployee.get());
			return success;
		}else {
			return errorEmployeeId;
		}		
	}
	
	public List<BaseEmployeeResponse> getAllEmployee(EmployeeRequest requestData){
		List<EmployeeResponse> list = employeeDAO.findAll(requestData);
		List<BaseEmployeeResponse> reslt = null ;
		if(list!=null && !list.isEmpty()) {
			reslt = new ArrayList<>();
			int page = 0;
			int count = 1; 
			List<EmployeeResponse> tempList  = new ArrayList<>() ;
			BaseEmployeeResponse tempReslt = new BaseEmployeeResponse();
			for(int i = 0 ; i<list.size() ; i++) {
				tempList.add(list.get(i));
				if((tempList.size()-1) == i) {
					page++;
					tempReslt.setPage(page);
					tempReslt.setDataList(tempList);
					reslt.add(tempReslt);
					break;
				}
				if(count%10 == 0) {
					page++;
					tempReslt.setPage(page);
					tempReslt.setDataList(tempList);
					reslt.add(tempReslt);
					tempList = new ArrayList<>();	
					tempReslt = new BaseEmployeeResponse();				
				}
				count++;
			}
		}		
		return reslt;
	}
	
}