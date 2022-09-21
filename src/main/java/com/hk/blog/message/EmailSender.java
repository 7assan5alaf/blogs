package com.hk.blog.message;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	
	  public void sendEmail(String to,String subject,String body) throws MessagingException {
	    	Message message1=new Message();
	        MimeMessage message=javaMailSender.createMimeMessage();
	        MimeMessageHelper helper=new MimeMessageHelper(message,true);
	        helper.setSubject(subject);
	        helper.setText(body);
	        helper.setFrom(message1.getFrom());
	        helper.setTo(to);
	        javaMailSender.send(message);
	    }

}
