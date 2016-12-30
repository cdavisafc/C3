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
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
	public void	helloNoToken() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	public void	helloInvalidToken() throws Exception {
		mockMvc.perform(get("/").cookie(new Cookie("userToken", "1234")))
				.andExpect(status().isUnauthorized());
	}

	@Test
	public void	loginNoName() throws Exception {
		mockMvc.perform(post("/login"))
			.andExpect(status().is4xxClientError());
	}

	@Test
	public void	loginNamed() throws Exception {
		mockMvc.perform(post("/login").param("name", "Cornelia"))
			.andExpect(cookie().exists("userToken"));
	}
	
	@Test
	public void	helloValidToken() throws Exception {
		assertFalse(HelloWorldApplication.validTokens.isEmpty());

		String validToken = HelloWorldApplication.validTokens.keySet().iterator().next();
		String validName = HelloWorldApplication.validTokens.get(validToken);

		String specialization = System.getenv("SPECIALIZATION");
		if (specialization == null) specialization = "Education";

		mockMvc.perform(get("/").cookie(new Cookie("userToken", validToken)))
				.andExpect(content().string(containsString("Hello "+validName+"!")))
				.andExpect(content().string(containsString(specialization)));
	}

}
