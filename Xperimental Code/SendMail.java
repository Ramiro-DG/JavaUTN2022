import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
    public static void main(String[] args) {
    	String to = "@gmail.com";//change accordingly  
        String from = "correofarmacia2022@gmail.com";//change accordingly  
        String host = "smtp.gmail.com";//or IP address 
        String password = "psw de Aplicacion correo";

      Properties properties = System.getProperties();
      properties.put("mail.smtp.host", host);
      properties.put("mail.smtp.port", "465");
      properties.put("mail.smtp.ssl.enable", "true");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      
      Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(from, password);
        }
      });

      try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Subject");
        message.setText("Body");

        Transport.send(message,from, password);
      } catch (MessagingException mex) {
        mex.printStackTrace();
      }
   }
}
