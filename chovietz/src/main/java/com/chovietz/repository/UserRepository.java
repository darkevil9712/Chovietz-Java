package com.chovietz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chovietz.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	@Query("{username:'?0'}")
	User findByUsername(String username);
	
//	Boolean existByUsername(String name);

}
