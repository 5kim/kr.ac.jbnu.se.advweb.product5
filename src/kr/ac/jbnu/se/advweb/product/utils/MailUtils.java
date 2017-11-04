package kr.ac.jbnu.se.advweb.product.utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import kr.ac.jbnu.se.advweb.product.model.Product;

import javax.activation.*;

public class MailUtils {

	public static void sendMail(String toID, String fromID,Product product) {

		// Recipient's email ID needs to be mentioned.
		String to =toID;

		// Sender's email ID needs to be mentioned
		String from = fromID;

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("콩고물 쇼핑몰에서 주문하신 상품의 결제가 완료되었습니다.");

			// Now set the actual message
			String text = "주문하신 "+product.getName()+ "의 결제가 완료 되었습니다";
			// 내용을 어떻게 할지는 고민해 보자
			message.setText(text);

			// Send message
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Product product = new Product();
		product.setName("앙 기모띠");
		MailUtils.sendMail("rlwns012@gmail.com", "rlwns012@gmail.com", product);
	}
}
