package com.example.demo.jwt.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/")
public class HelloWorldController {
	
	private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	/**
	 * API  ---> '/helloWorld' 
	 * 
	 * */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		log.info("method hello() - START");
		
		String string = "Hello World";
		
		log.info("method hello() - END");
		return string;
	}

}
