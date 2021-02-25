package org.java.test.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class Email {

	public static void sendEmail(String toEmail, String subject, String body){
		try
	    {
			final String fromEmail = "aqeelhaider47@gmail.com"; //requires valid email address
			final String password = "_@M151214aqeel"; // password for email account
			Authenticator auth = new Authenticator() {
				
				//override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				
				}
		  };
		  
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		  props.put("mail.smtp.port", "25"); //TLS Port
	      props.put("mail.smtp.auth", "true"); //enable authentication
		  props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
		  Session session = Session.getInstance(props, auth); 
		  MimeMessage msg = new MimeMessage(session);
		  
		//set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("aqeelhaider47@gmail.com", "NoReply-JD"));
	      msg.setReplyTo(InternetAddress.parse("aqeelhaider57@gmail.com", false));
	      msg.setSubject(subject, "UTF-8");
	      msg.setText(body, "UTF-8");
	      msg.setSentDate(new Date());
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
    	  
	      Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
			 
	    }catch (Exception e) {
		      e.printStackTrace();
		    }
	}
}
