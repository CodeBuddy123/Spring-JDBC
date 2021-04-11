package com.ashsoft.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.ashsoft.dao")
public class PersistenceConfig {
	
	@Bean(name = "hkDs")
	public DataSource createDataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setIdleTimeout(100);
		ds.setMaximumPoolSize(200);
		return ds;
		
	}
	
	@Bean(name = "jt")
	public JdbcTemplate createJt()
	{
		return new JdbcTemplate(createDataSource());
	}
}
