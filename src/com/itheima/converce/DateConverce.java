package com.itheima.converce;

import java.lang.reflect.Member;
import java.util.Map;

import ognl.DefaultTypeConverter;
public class DateConverce extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		// TODO Auto-generated method stub
		return super.convertValue(context, value, toType);
	}

	@Override
	public Object convertValue(Map context, Object target, Member member,
			String propertyName, Object value, Class toType) {
		// TODO Auto-generated method stub
		return super.convertValue(context, target, member, propertyName, value, toType);
	}
	

}
