package edu.alex.config;

import java.util.Arrays;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.alex.CustomerEntity;
import edu.alex.ICustomerDAO;

@Configuration
public class TestConfiguration {
	
	@Bean
	ICustomerDAO mockCustomerDAO() {
		ICustomerDAO mock = Mockito.mock(ICustomerDAO.class);
		Mockito.when(mock.findAll()).thenReturn(Arrays.asList(new CustomerEntity("1", "Test first", "Test last", 30)));
		
		return mock;
	}
}
