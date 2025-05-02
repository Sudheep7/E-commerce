package com.jsp.ecommerce1.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.jsp.ecommerce1.dto.UserDto;

import jakarta.mail.internet.MimeMessage;
	
@Service
public class EmailSender {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	TemplateEngine engine;
	
	
	@Value("${spring.mail.username}")
	String from;

	public void sendEmail(UserDto userDto, int otp) { 
		
		Context context = new Context();
		context.setVariable("otp", otp);
		context.setVariable("name", userDto.getName());
		
		String text= engine.process("email-template.html", context);
		
		try {
			MimeMessage message= mailSender.createMimeMessage(); 
			MimeMessageHelper helper= new MimeMessageHelper(message);
			
			helper.setFrom(from, "Ecommerce Application");
			helper.setTo(userDto.getEmail());
			helper.setSubject("OTP Verification");
			helper.setText(text,true);
			
			
			mailSender.send(message);
		}
		
		catch (Exception e) {
			System.err.println("OPT sending to email Failed but the otp is "+otp);
		}
	}
}
