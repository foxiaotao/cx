package com.itheima.application;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {

	@Test
	public void test21(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
}
