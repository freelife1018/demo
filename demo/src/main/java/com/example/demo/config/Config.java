package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class Config {

	@Value("${h2.datasource.url}")
	private String h2_datasource_url;
	@Value("${h2.datasource.username}")
	private String h2_datasource_username;
	@Value("${h2.datasource.password}")
	private String h2_datasource_password;


	@Bean(name = "h2Datasource")
	@ConfigurationProperties("spring.datasource.hikari")
	@Primary
	public DataSource oracleDatasource() {
		HikariConfig config = new HikariConfig();
		config.setUsername(h2_datasource_username); // 使用者名稱
		config.setPassword(h2_datasource_password); // 密碼
		
		config.setJdbcUrl(h2_datasource_url); // 資料來源
		config.setDriverClassName("org.h2.Driver");
	
		config.setAutoCommit(true);
		config.setPoolName("h2");
		config.setRegisterMbeans(true);
		return new HikariDataSource(config);
	}

	@Bean(name = "jdbcTemplate_h2")
	public NamedParameterJdbcTemplate oracleJdbcTemplate(@Qualifier("h2Datasource") DataSource dataSource){
		NamedParameterJdbcTemplate namedParameterJDBCTemplate = new NamedParameterJdbcTemplate(dataSource);
		namedParameterJDBCTemplate.setCacheLimit(1000);
		return namedParameterJDBCTemplate;
	}
	

}
