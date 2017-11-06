	package kr.ac.jbnu.se.advweb.product.utils;

	import java.io.IOException;
	import java.util.Properties;

	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.AddressException;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

public class MailUtils {

	/**
	 * Servlet implementation class Mailsender
	 */

	    public MailUtils() {
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
	    
	    public void mailSender(HttpServletRequest request) throws AddressException, MessagingException {
	    	// 네이버일 경우 smtp.naver.com 을 입력합니다. // Google일 경우 smtp.gmail.com 을 입력합니다.
	    	String host = "smtp.naver.com";
	    	final String username = "keybar";
	    	//네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.
	    	final String password = "@rather1";
	    	//네이버 이메일 비밀번호를 입력해주세요.
	    	int port=465; //포트번호 
	    	// 메일 내용
	    	String recipient = "throcandy@naver.com"; //받는 사람의 메일주소를 입력해주세요.
	    	String subject = "메일테스트"; //메일 제목 입력해주세요.
	    	String body = username+"님으로 부터 메일을 받았습니다."; //메일 내용 입력해주세요.
	    	Properties props = System.getProperties();
	    	// 정보를 담기 위한 객체 생성 
	    	// SMTP 서버 정보 설정
	    	props.put("mail.smtp.host", host);
	    	props.put("mail.smtp.port", port);
	    	props.put("mail.smtp.auth", "true");
	    	props.put("mail.smtp.ssl.enable", "true");
	    	props.put("mail.smtp.ssl.trust", host);
	    	//Session 생성 
	    	Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	    			String un=username;
	    			String pw=password;
	    			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	    				return new javax.mail.PasswordAuthentication(un, pw); } });
	    	session.setDebug(true);
	    	//for debug
	    	Message mimeMessage = new MimeMessage(session);
	    	//MimeMessage 생성 
	    	mimeMessage.setFrom(new InternetAddress("keybar@naver.com"));
	    	//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
	    	mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음 
	    	mimeMessage.setSubject(subject); //제목셋팅 
	    	mimeMessage.setText(body); //내용셋팅 
	    	Transport.send(mimeMessage); //javax.mail.Transport.send() 이용 
	    }


	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			try {
				mailSender(request);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}

	
	
	
//	public static void sendMail(String toID, String fromID,Product product) {
//
//		// Recipient's email ID needs to be mentioned.
//		String to =toID;
//
//		// Sender's email ID needs to be mentioned
//		String from = fromID;
//
//		// Assuming you are sending email from localhost
//		String host = "localhost";
//
//		// Get system properties
//		Properties properties = System.getProperties();
//
//		// Setup mail server
//		properties.setProperty("mail.smtp.host", host);
//
//		// Get the default Session object.
//		Session session = Session.getDefaultInstance(properties);
//
//		try {
//			// Create a default MimeMessage object.
//			MimeMessage message = new MimeMessage(session);
//
//			// Set From: header field of the header.
//			message.setFrom(new InternetAddress(from));
//
//			// Set To: header field of the header.
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//			// Set Subject: header field
//			message.setSubject("콩고물 쇼핑몰에서 주문하신 상품의 결제가 완료되었습니다.");
//
//			// Now set the actual message
//			String text = "주문하신 "+product.getName()+ "의 결제가 완료 되었습니다";
//			// 내용을 어떻게 할지는 고민해 보자
//			message.setText(text);
//
//			// Send message
//			Transport.send(message);
//		} catch (MessagingException mex) {
//			mex.printStackTrace();
//		}
//	}
//	public static void main(String[] args) {
//		Product product = new Product();
//		product.setName("앙 기모띠");
//		MailUtils.sendMail("rlwns012@gmail.com", "rlwns012@gmail.com", product);
//	}
//}
