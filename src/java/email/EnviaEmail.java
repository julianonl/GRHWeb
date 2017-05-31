package email;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaEmail {

     
    public void enviarEmail(String destinatario, String assunto, String conteudo) {

        Properties props = new Properties();  
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.auth", "true");  
        props.put("mail.debug", "true");  
        props.put("mail.smtp.port", 25);  
        props.put("mail.smtp.socketFactory.port", 25);  
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtp");
        Session mailSession = null;

        mailSession = Session.getInstance(props,  
                new javax.mail.Authenticator() {  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication("julianozagati2016@gmail.com", "sw8rdoi5");  
            }  
        });  


        try {

            Transport transport = mailSession.getTransport();

            MimeMessage menssagem = new MimeMessage(mailSession);

            menssagem.setSubject(assunto);
            menssagem.setFrom(new InternetAddress("julianozagati2016@gmail.com"));
            String []to = new String[]{destinatario};
            menssagem.addRecipient(Message.RecipientType.TO, new InternetAddress(to[0]));
            menssagem.setContent(conteudo,"text/html");
            transport.connect();

            transport.sendMessage(menssagem,menssagem.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
   
