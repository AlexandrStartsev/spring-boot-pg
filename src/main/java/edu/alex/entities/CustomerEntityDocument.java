package edu.alex.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class CustomerEntityDocument extends CustomerEntity {

	public CustomerEntityDocument() {
		super();
	}

	public CustomerEntityDocument(String id, String firstName, String lastName, int age) {
		super(id, firstName, lastName, age);
	}

}
