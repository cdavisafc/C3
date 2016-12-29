package com.corneliadavis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.util.UUID;


@RestController
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public void whoareyou(@RequestParam(value="name", required=false) String name, HttpServletResponse response) {
		
		if (name == null)
		    response.setStatus(400);
		else {
            UUID uuid = UUID.randomUUID();
            String userToken = uuid.toString();

            HelloWorldApplication.validTokens.put(userToken, name);
            response.addCookie(new Cookie("userToken", userToken));
        }


    }


}
