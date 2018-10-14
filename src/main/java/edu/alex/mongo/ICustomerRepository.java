package edu.alex.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import edu.alex.entities.CustomerEntityDocument;

@Component
public interface ICustomerRepository extends MongoRepository<CustomerEntityDocument, String> {

}
