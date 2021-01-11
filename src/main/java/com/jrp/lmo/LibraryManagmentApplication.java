package com.jrp.lmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.jrp.lmo","com.jrp.lmo.controllers","com.jrp.lmo.dao","com.jrp.lmo.details","com.jrp.lmo.entities"})
public class LibraryManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagmentApplication.class, args);
	}

}
