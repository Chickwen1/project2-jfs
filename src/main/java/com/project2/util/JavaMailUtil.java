package com.project2.util;

import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.istack.internal.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class JavaMailUtil {
public static void resendPassword(String recipient, String recoveredPassword) throws Exception {
	System.out.println("Preparing to send email");
	Properties properties = new Properties();
	
	properties.put("mail.smtp.auth", true);
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");
	
	String myAccountEmail = "saramm123454321@gmail.com";
	String password = "P@ssword123!";
	

	properties.setProperty("mail.smtp.user", myAccountEmail);
	properties.setProperty("mail.smtp.password", password);
	properties.setProperty("mail.smtp.auth", "true");      

	
	Session session = Session.getInstance(properties, new Authenticator(){
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(myAccountEmail, password);
		}
	});
	
	Message message = prepareMassage(session, myAccountEmail, recipient, recoveredPassword);
	Transport.send(message);
	System.out.println("Message sent successfully!");
}

private static Message prepareMassage(Session session, String myAccountEmail, String recipient, String recoveredPassword) {
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(myAccountEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		message.setSubject("Your password has arrived");
		String reimburseComplete = "<h2>Hello!</h2><br>"
				+ "You have requested your password to be resent, your current password is below.<br/><br/>"
				+ "<b>password:<b/> " + recoveredPassword + "<br/><br/>"
				+ "Thank you!<br/> Team JFS Planning"; 
		message.setContent(reimburseComplete, "text/html");
		//message.setText("Hey there, your ");
		return message;
	} catch(Exception e) {
		Logger.getLogger(JavaMailUtil.class.getName(), null).log(Level.SEVERE, null);
	}
	return null;
}}







