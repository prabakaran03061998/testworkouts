package com.management.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.management.model.Users;

@Repository
public interface UsersRepositoryService extends MongoRepository<Users, Long> {
	Users findTopByOrderByIdDesc();
	List<Users> findAllByOrderByIdDesc();
}
