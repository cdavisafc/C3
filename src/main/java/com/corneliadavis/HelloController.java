package com.corneliadavis;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        String wheretogreet = System.getenv("WHERETOGREET");
        if (wheretogreet == null) wheretogreet = "World";
        return "Hello " + wheretogreet + "!";
    }


}
