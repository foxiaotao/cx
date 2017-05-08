package com.itheima.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.itheima.service.impl.FilesServiceImpl;

public class GenProperties {
	public static String getValueByKey(String key) {
		InputStream inputStream = GenProperties.class.getClassLoader().getResourceAsStream("constant.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 配置文件中的路径
		String basePath = properties.getProperty(key);
		return basePath;
	}
}
