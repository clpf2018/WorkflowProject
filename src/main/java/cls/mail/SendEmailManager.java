package cls.mail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailManager {
	public static void sendMailWithoutAttachement() 
	{	 
		//<dependency>
	//	<groupId>com.sun.mail</groupId>
	//	<artifactId>javax.mail</artifactId>
//		<version>1.5.5</version>
//	</dependency>
	    
		/*
	      String emailFrom = emailConfig.emailFrom;
	       String username = emailConfig.userName;
	       String password =emailConfig.password;

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host =emailConfig.host;

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", emailConfig.port);
	      //props.put("mail.smtp.port", "587");
	   // Recipient's email ID needs to be mentioned.
	      for (EmailWrapper emailTo : emailsTo) {
			
		
	      String to =emailTo.EmailTo;
	   // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);
	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(emailConfig.emailFrom));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(emailTo.EmailSubject);

	         // Now set the actual message
	         message.setText(emailTo.EmailBody);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");
	      
	      
	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	      }
		  */
	}

}
