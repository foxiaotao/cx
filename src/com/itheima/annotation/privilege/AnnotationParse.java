package com.itheima.annotation.privilege;

import java.lang.reflect.Method;

public class AnnotationParse {
	
	public static String parse(Class clazz,String methodName) throws NoSuchMethodException, SecurityException{
		//得到制定的方法
		String annotationName = "";
		Method method = clazz.getMethod(methodName);
		if(method.isAnnotationPresent(PrivilegeAnnotation.class)){
			PrivilegeAnnotation annotation = method.getAnnotation(PrivilegeAnnotation.class);
			annotationName = annotation.name();
		}
		return annotationName; 
	}
}
