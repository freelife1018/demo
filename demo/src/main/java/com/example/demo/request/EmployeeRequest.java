package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeRequest {
  
  	private String name;
  	
  	private String employeeId;
  	
  	private String departmentId;
  	
  	private String sex;	
  	
  	private String phone;
  	
  	private String address;
  	
  	private Integer age;
  	
  	private String departmentName;
  		
}