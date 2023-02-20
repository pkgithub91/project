package com.send;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "preparing to send message..." );
        String message="Hello, Dear, this is sending mail";
        String subjec="CodersArea: Conformation";
        String to="pradeep.gnit91@gmail.com";
        String from="itcompany.java91@gmail.com";
        sendEmail(message,subjec,to,from);
        
    }
//this is responsible to send email
	private static void sendEmail(String message, String subjec, String to, String from) {
		
		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties=System.getProperties();
		System.out.println("PROPERTIES"+properties);
		//setting important information to properties object
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step1: to get the session object...
		
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("pradeep.official7454@gmail.com", "PradeeP91@");
			}
			
			
		});
		
		session.setDebug(true);
		// second step compose the messsage [text,multi medid]
		
		MimeMessage m = new MimeMessage(session);
		//from email
		try {
			m.setFrom();
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subjec);
			
			//adding text to message
			m.setText(message);
			
			//three step send the message using transport class
			Transport.send(m);
			
			System.out.println("send successfull.........");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
