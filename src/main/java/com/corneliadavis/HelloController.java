package com.corneliadavis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {

    @Value("${specialization}")
    private String specialization;

    @RequestMapping("/")
    public Greeting hello(@CookieValue(value = "userToken", required=false) String token, HttpServletResponse response) {

        if (token == null)
			response.setStatus(401);
		else {
			String name = HelloWorldApplication.validTokens.get(token);
			if (name == null)
				response.setStatus(401);
			else {
			    Greeting greeting = new Greeting();
			    greeting.setGreeting("Hello " + name + "!");
			    greeting.setSpecialization(specialization);
			    return greeting;
            }
		}
		return null;
    }

}
