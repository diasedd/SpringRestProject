package com.example.mockiti.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.mockito.api.model.Employee;
import com.example.mockito.api.service.EmployeeService;

@Configuration
public class MyRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		HttpMethod[] theUnsupportedActions = {};
		
		//disable Http methods
		config.getExposureConfiguration()
				.forDomainType(Employee.class)
				.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));	
		
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
	}
	
	@Bean
    public EmployeeService empService() {
        return new EmployeeService();
    }

}
