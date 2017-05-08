package com.itheima.Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.struts2.ServletActionContext;

public class MySessionListener implements HttpSessionListener{
	int onlineNum = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		synchronized (MySessionListener.class) {
			onlineNum++;
		}
		se.getSession().getServletContext().setAttribute("onlineNum", onlineNum);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		synchronized (MySessionListener.class) {
			onlineNum--;
		}
		se.getSession().getServletContext().setAttribute("onlineNum", onlineNum);
	}
}
