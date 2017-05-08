package com.itheima.util;

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import com.itheima.domain.Book;
 
/**
 * 使用Gmail发送邮件
 * @author Winter Lau
 */
public class SendGmail {
 
 public static void send(Book book) throws AddressException, MessagingException {
		  Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		  Properties props = System.getProperties();
		  props.setProperty("mail.smtp.host", "smtp.gmail.com");
		  props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		  props.setProperty("mail.smtp.socketFactory.fallback", "false");
		  props.setProperty("mail.smtp.port", "465");
		  props.setProperty("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.auth", "true");
		  final String username = GenProperties.getValueByKey("mail_username");
		  final String password = GenProperties.getValueByKey("mail_pwd");
		  Session session = Session.getDefaultInstance(props, new Authenticator(){
		      protected PasswordAuthentication getPasswordAuthentication() {
		          return new PasswordAuthentication(username, password);
		      }});
		 
		       // -- Create a new message --
		  Message msg = new MimeMessage(session);
		 
		  // -- Set the FROM and TO fields --
		  msg.setFrom(new InternetAddress(username));
		  msg.setRecipients(Message.RecipientType.TO,
		    InternetAddress.parse(book.getUser().getEmail(),false));
		  msg.setSubject("理学院创新中心图书管理");
		  msg.setText(book.getUser().getUsername()+"  你好,你在理学院科技创新中心借阅的图书: "+book.getName()+" 已到期，请及时归还。请勿回复。");
		  msg.setSentDate(new Date());
		  Transport.send(msg);
	   
	//  System.out.println("Message sent.");
	 }
 		@Test
 		public void send() throws AddressException, MessagingException{
 			  Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
 			  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
 			  // Get a Properties object
 			  Properties props = System.getProperties();
 			  props.setProperty("mail.smtp.host", "smtp.gmail.com");
 			  props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
 			  props.setProperty("mail.smtp.socketFactory.fallback", "false");
 			  props.setProperty("mail.smtp.port", "465");
 			  props.setProperty("mail.smtp.socketFactory.port", "465");
 			  props.put("mail.smtp.auth", "true");
 			  final String username = GenProperties.getValueByKey("mail_username");
 			  final String password = GenProperties.getValueByKey("mail_pwd");
 			  Session session = Session.getDefaultInstance(props, new Authenticator(){
 			      protected PasswordAuthentication getPasswordAuthentication() {
 			          return new PasswordAuthentication(username, password);
 			      }});
 			 
 			       // -- Create a new message --
 			  Message msg = new MimeMessage(session);
 			 
 			  // -- Set the FROM and TO fields --
 			  msg.setFrom(new InternetAddress(username));
 			  msg.setRecipients(Message.RecipientType.TO,
 			    InternetAddress.parse("260689116@qq.com",false));
 			  msg.setSubject("理学院创新中心图书管理");
 			  msg.setText("尊敬的用户    你好,你在理学院科技创新中心借阅的图书:  已到期，请及时归还，并在系统中做好归还登记。   "+new Date()+"。请勿回复。");
 			  msg.setSentDate(new Date());
 			  Transport.send(msg);
 		}
}
