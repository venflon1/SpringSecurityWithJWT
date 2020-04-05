package com.example.demo.jwt.dto;

import org.jboss.logging.Logger;

public class LoginInputDto {

	private static Logger log = Logger.getLogger(LoginInputDto.class);
	
	private String username;
	
	private String password;
	
	public LoginInputDto() {
		super();
		log.info("constructor LoginInputDto() - START");
		log.info("constructor LoginInputDto() - START");
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
