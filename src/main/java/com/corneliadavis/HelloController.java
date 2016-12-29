package com.corneliadavis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(@CookieValue(value = "userToken", required=false) String token, HttpServletResponse response) {
		if (token == null)
			response.setStatus(401);
		else {
			String name = HelloWorldApplication.validTokens.get(token);
			if (name == null)
				response.setStatus(401);
			else
				return "Hello " + name +"!";
		}
		return null;
    }

}
