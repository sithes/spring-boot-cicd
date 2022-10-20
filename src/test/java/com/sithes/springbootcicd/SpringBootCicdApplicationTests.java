package com.sithes.springbootcicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SpringBootCicdApplicationTests {

	@Autowired
	HelloController helloController;
	@Test
	void indexTest() {
		Assert.hasText(helloController.index(),"You are currently in Index Home Page");
	}
	@Test
	void helloTest() {
		Assert.hasText(helloController.hello("Sithes"),"You are currently in Hello Page with [Sithes]");
	}

}
