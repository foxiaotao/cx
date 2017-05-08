package com.itheima.test;

import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.util.WebUtils;

public class WebTest {
	@Test
	public void webTest() {
		System.out.println(ContextLoaderListener.getCurrentWebApplicationContext());
//		WebUtils.get
	}
}
