package com.skit.rest.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SbRestWsApplication {

	public static void main(String[] args) {
		log.info("Application started");
		SpringApplication.run(SbRestWsApplication.class, args);
		
	}

}
