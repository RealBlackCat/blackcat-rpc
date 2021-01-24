package com.blackcat.demo;

import com.blackcat.core.initialization.Provider;
import com.blackcat.demo.bean.SpringBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private Provider provider;

	@Autowired
	SpringBean springBean;

	@Test
	void contextLoads() {
		System.out.println(provider);
	}
	@Test
	void test2() throws Exception {
		springBean.get("123","!3");
	}

}
