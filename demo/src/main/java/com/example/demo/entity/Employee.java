package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@lombok.Data
@Table(name="Employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
  
  	private String name;
	
  	@Id
  	private String employeeId;
  	
  	private String departmentId;
  	
  	private String sex;	
  	
  	private String phone;
  	
  	private String address;
  	
  	private Integer age;
  	
  	private Date createTime;
  	
  	private Date modificationTime;  	
	
}