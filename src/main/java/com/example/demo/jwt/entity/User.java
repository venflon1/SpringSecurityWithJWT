package com.example.demo.jwt.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	
	private static Logger log = LoggerFactory.getLogger(User.class);
	
	private String username;
	
	private String password;
	
	public User(String username, String password) {
		super();
		log.info("constructor User(String username, String password) - START");
		this.username = username;
		this.password = password;
		log.info("constructor User(String username, String password) - END");
	}
	
	public User() {
		this(null, null);
		log.info("constructor User() - START");
		log.info("constructor User() - END");
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
