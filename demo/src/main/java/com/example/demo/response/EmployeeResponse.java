package com.example.demo.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
  
  	private String employeeName;
  	
  	private BigDecimal employeeId;
  	
  	private BigDecimal departmentId;
  	
  	private BigDecimal sex;	
  	
  	private String phone;
  	
  	private String address;
  	
  	private String age;
  	
  	private String departmentName;
  		
}