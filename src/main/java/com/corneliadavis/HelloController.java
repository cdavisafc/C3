package com.corneliadavis;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }


}
