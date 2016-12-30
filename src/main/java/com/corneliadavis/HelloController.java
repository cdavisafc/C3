package com.corneliadavis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public Greeting hello(@CookieValue(value = "userToken", required=false) String token, HttpServletResponse response) {

        String specialization;
        specialization = System.getenv("SPECIALIZATION");
        if (specialization == null)
            specialization = "Education"; // default specialization

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
