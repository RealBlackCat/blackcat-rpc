package com.blackcat.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {
	@Autowired
	Bean bean;

	@Test
	void contextLoads() {
		bean.test1();
	}

}
