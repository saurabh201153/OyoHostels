package com.oyohostels.oyohostels.service;

import com.oyohostels.oyohostels.domain.Booking;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Component
@Async
public class EmailService {
    public void  EmailService(Booking book){
        final String username = "saurabh2018.53@gmail.com" ;
        final String password = "oyo@1234" ;

        String newline = System.getProperty("line.separator");

        String content="Here is the booking details...";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(username,password);
                    }
                });

         try{
             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress("saurabh2018.53@gmail.com"));
             String email = book.getBookingEmail();
             message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
             message.setSubject("Your Booking has been confirmed!!!!!!!");
             content+=newline + newline + book.toString()+ newline + newline + " This is a system generated mail do not reply";
             message.setContent(content,"text/html");
             Transport.send(message);
             System.out.println("Done");
         }
         catch (MessagingException e){
             throw new RuntimeException(e);
         }
    }
}
