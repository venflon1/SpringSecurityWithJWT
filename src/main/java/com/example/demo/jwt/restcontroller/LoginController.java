package com.example.demo.jwt.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jwt.JwtProvider;
import com.example.demo.jwt.dto.LoginInputDto;
import com.example.demo.jwt.dto.LoginOutputDto;
import com.example.demo.jwt.entity.User;
import com.example.demo.jwt.service.UserService;

@RestController
@RequestMapping(value = "/public/authentication")
public class LoginController {
	
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private UserService userService;
	
	/**
	 * API  ---> '/login' 
	 * 
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginInputDto body) {
		log.info("method login(@RequestBody LoginInputDto body) - START");
		log.info("method login(@RequestBody LoginInputDto body) - PARAM: body = { " + body.getUsername() + ", " + body.getPassword() + " }");
		
		ResponseEntity<?> responseEntity = null;
		User user = this.userService.getUserByUsernameAndPassword(body.getUsername(), body.getPassword());
		if(user == null) {
			responseEntity = ResponseEntity.badRequest().build();
			log.info("method login(@RequestBody LoginInputDto body) - DEBUG: responseEntity = " + responseEntity.getStatusCode()); 

		}
		else {
			String jwt = this.jwtProvider.generateJwt();
			log.info("method login(@RequestBody LoginInputDto body) - DEBUG: jwtGenerated = " + jwt); 

			LoginOutputDto loginOutputDto = new LoginOutputDto();
			loginOutputDto.setJwt(jwt);
			log.info("method login(@RequestBody LoginInputDto body) - DEBUG: loginOutputDto.getJwt() = " + loginOutputDto.getJwt()); 

			responseEntity = ResponseEntity.ok(loginOutputDto);
			log.info("method login(@RequestBody LoginInputDto body) - DEBUG: responseEntity = " + responseEntity.getStatusCode()); 

		}
		
		log.info("method login(@RequestBody LoginInputDto body) - RETURNED: ");
		log.info("method login(@RequestBody LoginInputDto body) - END");
		return responseEntity;
	}

}
