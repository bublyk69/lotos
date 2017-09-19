
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class mail_managment {




   public static void mail_birthday(String to, String name ) {    
      // Recipient's email ID needs to be mentioned.
	  String from = "19bublyk99@gmail.com";
	  String fromPass = "andriy69";
      String text = "Шановний" + name + ", стоматологічна клініка 'Лотос' вітає Вас з днем народження.";
      
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
        return new PasswordAuthentication(from, fromPass);
        //change according to your information
     }
      });
      
      try {
       MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(from));
       //change accordingly
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          message.setSubject("Вітання з Днем Народження");
          message.setText(text);
          
          //send message
          Transport.send(message);
          System.out.println("message sent successfully");
      }
      catch (MessagingException e) {throw new RuntimeException(e);}
   }
}
