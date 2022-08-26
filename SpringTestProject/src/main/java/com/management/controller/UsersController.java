package com.management.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.dto.UsersDto;
import com.management.model.Users;
import com.management.response.DefaultResponse;
import com.management.response.UsersResponse;
import com.management.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/save")
	public DefaultResponse saveUser(@RequestBody UsersDto usersDto) throws Exception {
		log.debug("saveUser");
		Users user= usersService.saveUsers(usersDto);
		if(user!=null) {
			return new DefaultResponse(new Date(),"Saved Successfully",String.valueOf(user.getId()),HttpStatus.OK);
		}
		return new DefaultResponse(new Date(),"Saved failed",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<UsersResponse>> getUsers(){
		log.debug("getUsers");
		return new ResponseEntity<>(usersService.getUsers(), HttpStatus.OK);		
	}
	
}
