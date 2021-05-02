package com.bl.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:8083/swagger-ui.html#/address-book-controller
@EnableSwagger2
@SpringBootApplication
@Slf4j
public class AddressookSpringApplication {

	public static void main(String[] args) {
		;
		ConfigurableApplicationContext context = 
				SpringApplication.run(AddressookSpringApplication.class, args);
		log.info("Address Book started in {} Environment", 
				context.getEnvironment().getProperty("environment"));
	}

}
