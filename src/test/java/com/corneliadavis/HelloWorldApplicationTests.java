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
	public void	helloControllerTestDefault() {
		HelloController helloController = new HelloController();
		String wheretogreet = System.getenv("WHERETOGREET");
		if (wheretogreet == null) wheretogreet = "World";
		assertEquals("Hello "+wheretogreet+"!", helloController.hello());
	}

}
