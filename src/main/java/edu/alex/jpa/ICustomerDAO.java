package edu.alex.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alex.entities.CustomerEntity;

public interface ICustomerDAO extends JpaRepository<CustomerEntity, String> {

}
