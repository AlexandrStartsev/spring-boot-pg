package edu.alex.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "Customer")
public class CustomerEntity {
	// this is only relevant to JPA, not to mongo, however I keep uuid so I can have string id. 
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	/*
	  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CustomerId")
	  @SequenceGenerator(name = "CustomerId", sequenceName = "CustomerId", allocationSize = 1, initialValue = 0)
	 */
	private String id;
	
	@Size(min = 1, max = 40)
	private String firstName;
	
	@Size(min = 1, max = 40)
	private String lastName;
	
	@Min(2)
	@Max(199)
	private int age;
}
