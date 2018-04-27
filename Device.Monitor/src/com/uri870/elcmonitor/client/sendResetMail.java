package com.uri870.elcmonitor.client;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendResetMail {
	public static void main(String id) throws IOException {
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		FileInputStream in = new FileInputStream("em.properties");
		Properties prop = new Properties();
		prop.load(in);
		String facilityName = prop.getProperty("facilityName");
		String destinationEmail = prop.getProperty("destinationEmail");
		in.close();
		
		
		final String username = "elcmonitor@gmail.com";
		final String password = "5GS-sQT-weB-PpF";

		// setting gmail smtp properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// check the authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("elcmonitor@gmail.com"));

			// recipients email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationEmail));


			// add the Subject of email
			message.setSubject(facilityName+" - Device: " +id+" connection is restored!");

			// message body
			Date date = new Date();
			message.setText("Connection restored notification from: "+facilityName+"\n Device id: "+id+"\n Sent on: "+sdf.format(date));// message

			Transport.send(message);

			gui.setT2Text("\n Email Sent Successfully ");

		} catch (MessagingException e) {
			throw new RuntimeException(e);

		}
	}
}