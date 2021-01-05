package com.example.demo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEmployeeResponse {
  
  	private Integer page;
  	
  	private List<EmployeeResponse> dataList;
  		  		
}