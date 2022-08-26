package com.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("Users")
public class Users {

	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private int age;
	private String gender;
	private String mobileNumber;

}
