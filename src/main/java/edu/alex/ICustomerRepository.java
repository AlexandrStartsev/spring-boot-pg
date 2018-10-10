package edu.alex;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ICustomerRepository extends MongoRepository<CustomerEntityDocument, String> {

}
