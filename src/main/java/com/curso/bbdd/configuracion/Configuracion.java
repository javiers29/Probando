package com.curso.bbdd.configuracion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.curso.bbdd.data")
@EnableTransactionManagement
@ComponentScan("com.curso.bbdd")
public class Configuracion {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/empresa3?serverTimezone=GMT");
		dataSource.setUsername("root");
		dataSource.setPassword("curso");
		
			return dataSource;
	}
	
    
    
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
    	
	    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
	    LocalContainerEntityManagerFactoryBean();
	    entityManagerFactoryBean.setDataSource(dataSource);
	    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    entityManagerFactoryBean.setPackagesToScan("com.curso.bbdd.beans");
	    Properties jpaProperties = new Properties();
	    jpaProperties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	    entityManagerFactoryBean.setJpaProperties(jpaProperties);
	    
	    	return entityManagerFactoryBean;
    }
    
    
    @Bean
	    public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager txManager= new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory(dataSource()).getObject());
	    
	    	return txManager;
    }
    
    


}
