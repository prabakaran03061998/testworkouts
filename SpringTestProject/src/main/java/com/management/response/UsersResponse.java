package com.management.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponse {
	private long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private int age;
	private String gender;
	private String mobileNumber;

}
