package com.management.service;

import java.util.List;

import com.management.dto.UsersDto;
import com.management.model.Users;
import com.management.response.UsersResponse;

public interface UsersService {
	Users saveUsers(UsersDto usersDto) throws Exception;
	List<UsersResponse> getUsers();
}
