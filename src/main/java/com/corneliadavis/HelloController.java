package com.corneliadavis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(@CookieValue(value = "userToken", required=false) String token, Model model) {
		String name = "World";
		if (token == "1234") {
			name = "Cornelia";
		}
		model.addAttribute("name", name);
        return "greeting";
    }

}
