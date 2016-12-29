package com.corneliadavis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HelloWorldApplication {

	public static Map<String, String> validTokens = new HashMap<String, String>();

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
