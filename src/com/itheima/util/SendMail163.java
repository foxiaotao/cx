package com.itheima.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import com.itheima.domain.Book;

public class SendMail163 extends Thread {
	public static void send(Book book){
		//HttpServletRequest request,
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");
		
		  final String username = GenProperties.getValueByKey("mail_username");
		  final String password = GenProperties.getValueByKey("mail_pwd");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username.split("\\@")[0], password);
			}
		});
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, book.getUser().getEmail());
			message.setSubject("理学院创新中心图书管理");
			
			message.setText(book.getUser().getUsername()+"  你好,你在理学院科技创新中心借阅的图书: "+book.getName()+" 已到期，请及时归还。请勿回复。");
//			message.setText("  你好,你在理学院科技创新中心借阅的图书: ");
			
			Transport ts = session.getTransport();
			ts.connect(username,password);
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void sendmail(){
		//HttpServletRequest request,
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");
		
		  final String username = GenProperties.getValueByKey("mail_username");
		  final String password = GenProperties.getValueByKey("mail_pwd");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username.split("\\@")[0], password);
			}
		});
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, "164257204@qq.com");
			message.setSubject("理学院创新中心图书管理");
			
			message.setText("  你好,你在理学院科技创新中心借阅的图书:  已到期，请及时归还。请勿回复。", "UTF-8");
			
			Transport ts = session.getTransport();
			ts.connect(username,password);
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
