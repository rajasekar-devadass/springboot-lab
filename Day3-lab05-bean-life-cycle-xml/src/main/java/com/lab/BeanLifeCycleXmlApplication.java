package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:beans.xml")
@SpringBootApplication
public class BeanLifeCycleXmlApplication implements CommandLineRunner {

	@Autowired
	public AccountsController accountsController;

	public static void main(String[] args) {
		SpringApplication.run(BeanLifeCycleXmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world");
	}
}
