package edu.alex;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "Customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CustomerId")
	@SequenceGenerator(name = "CustomerId", sequenceName = "CustomerId", allocationSize = 1, initialValue = 0)
	private int id;
	
	@Size(min = 1, max = 40)
	private String firstName;
	
	@Size(min = 1, max = 40)
	private String lastName;
	
	@Min(2)
	@Max(199)
	private int age;
}
