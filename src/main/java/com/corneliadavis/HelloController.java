package com.corneliadavis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class HelloController {

    @RequestMapping("/")
    public Greeting hello(HttpServletResponse response) {

    	String specialization = "Science";
		response.setStatus(200);
		Greeting greeting = new Greeting();
		greeting.setGreeting("Hello World!");
		greeting.setSpecialization(specialization);

		return greeting;
    }
}
