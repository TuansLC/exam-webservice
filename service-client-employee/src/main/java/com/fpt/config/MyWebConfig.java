package com.fpt.config;

import com.fpt.myservice.EmployeeService;
import com.fpt.myservice.EmployeeServiceServiceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.rpc.ServiceException;

@Configuration
public class MyWebConfig {
    @Bean
    EmployeeService employeeService() throws ServiceException{
        return new EmployeeServiceServiceLocator().getEmployeeServicePort();
    }
}
