package com.example.demo.jwt.dto;

import org.jboss.logging.Logger;

public class LoginOutputDto {

	private static Logger log = Logger.getLogger(LoginOutputDto.class);
	
	private String jwt;
	
	public LoginOutputDto() {
		super();
		log.info("constructor LoginOutputDto() - START");
		log.info("constructor LoginOutputDto() - START");
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}	
}
