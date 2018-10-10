package edu.alex;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDAO extends JpaRepository<CustomerEntity, String> {

}
