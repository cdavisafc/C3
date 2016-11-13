package com.corneliadavis;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void	helloControllerTest() {
		HelloController helloController = new HelloController();
		assertEquals("Hello World!", helloController.hello());
	}

}
