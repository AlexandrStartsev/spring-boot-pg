package edu.alex.config;

import java.util.Arrays;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.alex.entities.CustomerEntity;
import edu.alex.entities.CustomerEntityDocument;
import edu.alex.jpa.ICustomerDAO;
import edu.alex.mongo.ICustomerRepository;

@Configuration
public class TestConfiguration {
	
	@Bean
	ICustomerDAO mockCustomerDAO() {
		ICustomerDAO mock = Mockito.mock(ICustomerDAO.class);
		Mockito.when(mock.findAll()).thenReturn(Arrays.asList(new CustomerEntity("1", "Test first", "Test last", 30)));
		
		return mock;
	}
	
	@Bean
	ICustomerRepository mockCustomerRepository() {
		ICustomerRepository mock = Mockito.mock(ICustomerRepository.class);
		Mockito.when(mock.findAll()).thenReturn(Arrays.asList(new CustomerEntityDocument("1", "Test first", "Test last", 30)));
		
		return mock;
	}
}
