package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

	public static void main(String[] args) {
		logger.trace("this is a trace message");
		logger.debug("this is a debug message");
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		SpringApplication.run(SpringBootApplication.class, args);
	}

}
