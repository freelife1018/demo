package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentRequest {
	
	private String id;
	
  	private String name;
   		
}