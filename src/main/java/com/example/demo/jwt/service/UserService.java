package com.example.demo.jwt.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jwt.entity.User;
import com.example.demo.jwt.repository.UserRepository;


@Service
public class UserService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserByUsernameAndPassword(String username, String password) {
		log.info("method getUserByUsernameAndPassword(String username, String password) - START");
		User user = this.userRepository.getUserByUsernameAndPassword(username, password);
		log.info("method getUserByUsernameAndPassword(String username, String password) - RETURNED: user = " + user);
		log.info("method getUserByUsernameAndPassword(String username, String password) - END");
		return user;
	}
}
