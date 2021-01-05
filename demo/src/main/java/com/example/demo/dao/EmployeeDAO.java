package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.EmployeeResponse;

@Repository
public class EmployeeDAO {
	
	@Autowired
	@Qualifier("jdbcTemplate_h2")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<EmployeeResponse> findAll(EmployeeRequest requestData) {		
		StringBuilder sql = new StringBuilder();
	    sql.append("select  ");
	    sql.append("e.name as employeeName, ");
	    sql.append("e.employee_id, ");
	    sql.append("e.department_id, ");
	    sql.append("e.sex, ");
	    sql.append("e.phone, ");
	    sql.append("e.address, ");
	    sql.append("e.age, ");
	    sql.append("e.create_Time, ");
	    sql.append("e.modification_Time, ");
	    sql.append("d.name as department_Name ");
	    sql.append("from  Employee e ");
	    sql.append("left join Department d on e.department_Id = d.id ");	
	    sql.append("where 1 = 1 ");
	    MapSqlParameterSource param = new MapSqlParameterSource();
	    if(null != requestData.getAge()) {
	    	sql.append("and e.age = :age ");
	    	param.addValue("age", requestData.getAge());
	    }
	    if(null != requestData.getEmployeeId()) {
	    	sql.append("and e.employee_Id = :employeeId ");
	    	param.addValue("employeeId", requestData.getEmployeeId());
	    }
	    if(null != requestData.getName()) {
	    	sql.append("and e.name = :name ");
	    	param.addValue("name", requestData.getName());
	    }
	    if(null != requestData.getDepartmentName()) {
	    	sql.append("and d.name = :departmentName ");
	    	param.addValue("departmentName", requestData.getDepartmentName());
	    }
	    return jdbcTemplate.query(sql.toString(), param, new BeanPropertyRowMapper<EmployeeResponse>(EmployeeResponse.class));	    
	}
}
