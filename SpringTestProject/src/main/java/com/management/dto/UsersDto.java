package com.management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto {
	private long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private int age;
	private String gender;
	private String mobileNumber;
}
