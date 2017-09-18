
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class mail_managment {




   public static void mail() {    
      // Recipient's email ID needs to be mentioned.
	  String from = "19bublyk99@gmail.com";
      String to = "lemvlad99@gmail.com";
      
      //Get the session object
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.socketFactory.port", "465");
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "465");
      
      Session session = Session.getDefaultInstance(props, 
        new javax.mail.Authenticator() {
     protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("19bublyk99@gmail.com", "andriy69");
        //change according to your information
     }
      });
      
      try {
       MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(from));
       //change accordingly
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          message.setSubject("Ти хуїла");
          message.setText("кєкосбля");
          
          //send message
          Transport.send(message);
          System.out.println("message sent successfully");
      }
      catch (MessagingException e) {throw new RuntimeException(e);}
   }
}
