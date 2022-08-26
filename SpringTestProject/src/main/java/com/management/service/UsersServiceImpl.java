package com.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.UsersRepositoryImpl;
import com.management.dto.UsersDto;
import com.management.model.Users;
import com.management.mongodb.SequenceGeneratorService;
import com.management.response.UsersResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepositoryImpl usersRepositoryImpl;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public Users saveUsers(UsersDto usersDto) throws Exception {
		log.debug("saveUsers");
		Users users = new Users();
		if (usersDto.getId() == 0) {
			users.setId(sequenceGeneratorService.getNextSequenceOfUser("Users"));
		} else {
			users.setId(usersDto.getId());
		}
		users.setFirstName(usersDto.getFirstName());
		users.setLastName(usersDto.getLastName());
		users.setAge(usersDto.getAge());
		users.setMobileNumber(usersDto.getMobileNumber());
		users.setDateOfBirth(usersDto.getDateOfBirth());
		users.setGender(usersDto.getGender());
		try {
			users = usersRepositoryImpl.save(users);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Users save failed");
		}
		return users;
	}

	@Override
	public List<UsersResponse> getUsers() {
		log.debug("getUsers");
		List<Users> listUsers = new ArrayList<>();
		try {
			listUsers = usersRepositoryImpl.findAllByOrderByIdDesc();
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}
		return generateUserResponse(listUsers);
	}

	private List<UsersResponse> generateUserResponse(List<Users> listUsers) {
		log.debug("generateUserResponse");
		try {
			return listUsers.stream().map(user -> {
				UsersResponse usersResponse = new UsersResponse();
				usersResponse.setId(user.getId());
				usersResponse.setFirstName(user.getFirstName());
				usersResponse.setLastName(user.getLastName());
				usersResponse.setDateOfBirth(user.getDateOfBirth());
				usersResponse.setAge(user.getAge());
				usersResponse.setMobileNumber(user.getMobileNumber());
				usersResponse.setGender(user.getGender());
				return usersResponse;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}
	}

}
