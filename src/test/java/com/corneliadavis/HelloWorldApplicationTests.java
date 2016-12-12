package com.corneliadavis;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import javax.servlet.http.Cookie;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void	helloDefault() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(content().string(containsString("Hello World!")));
	}
	
	@Test
	public void	loginNoName() throws Exception {
		mockMvc.perform(get("/login"))
			.andExpect(content().string(containsString("please tell us who you are")));
	}

	@Test
	public void	loginNamed() throws Exception {
		mockMvc.perform(get("/login").param("name", "Cornelia"))
			.andExpect(cookie().exists("userToken"));
	}
	
	@Test
	public void	helloNamed() throws Exception {
		mockMvc.perform(get("/").cookie(new Cookie("userToken", "1234")))
			.andExpect(content().string(containsString("Hello Cornelia!")));
	}
	
	
}
