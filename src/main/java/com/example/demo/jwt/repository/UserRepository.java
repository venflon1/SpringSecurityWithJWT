package com.example.demo.jwt.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.jwt.entity.User;

@Repository
public class UserRepository {
	
	private static Logger log = LoggerFactory.getLogger(User.class);

	public User getUserByUsernameAndPassword(String username, String password) {
		log.info("method getUserByUsernameAndPassword() - START");
		User userRetrieved = new User(username, password);
		log.info("method getUserByUsernameAndPassword() - RETURNED: user = " + userRetrieved);
		log.info("method getUserByUsernameAndPassword() - END");
		return userRetrieved;
	}
	
}
