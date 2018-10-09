package edu.alex;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class CustomerEntity {
	@Id
	private int id;
	
	@Size(min = 1, max = 40)
	private String firstName;
	
	@Size(min = 1, max = 40)
	private String lastName;
	
	@Min(2)
	@Max(199)
	private int age;
}
