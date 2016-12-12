package com.corneliadavis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String whoareyou(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model, HttpServletResponse response) {
		
		if (name != null) {
			response.addCookie(new Cookie("userToken", "1234"));
		}
        
        return "login";
    }


}
