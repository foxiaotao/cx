package com.itheima.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private Class clazz;
	private T t;
	public BaseAction(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
		
		try {
			this.t = (T) this.clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public T getModel(){
		return this.t;
	}
}
