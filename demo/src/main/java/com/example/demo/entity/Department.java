package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@lombok.Data
@Table(name="Department")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
   	
  	@Id
  	private Long id;

  	private String name;

}