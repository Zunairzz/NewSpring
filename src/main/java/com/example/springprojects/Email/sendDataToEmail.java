package com.example.springprojects.Email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.sql.Connection;
import java.util.Properties;

public class sendDataToEmail {

    public static void main(String[] args) {

        System.out.println("preparing to send message ...");
        String message = "Hello , Dear, this is message for security check . ";
        String subject = "CodersArea : Confirmation";
        String to = "zamantariq09900@gmail.com";
        String from = "dawateislami635@gmail.com";

//		sendEmail(message,subject,to,from);
        sendAttach(message, subject, to, from);
    }

    //this is responsible to send the message with attachment
    private static void sendAttach(String message, String subject, String to, String from) {

        //Variable for gmail
        String host = "smtp.gmail.com";
        String password = "Zunairme1112@";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Step 1: to get the session object..
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("oarecare.careoare1@gmail.com", "lfmjerdtfnfedcwh");
            }


        });

        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);

        try {

            //from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);


            //attachement..

            //file path
            String path = "D:\\Downloads_new\\7794852.jpg";

            String link = "<a href='www.google.com'>'Click me!</a>";

            MimeMultipart mimeMultipart = new MimeMultipart();
            //text
            //file

            MimeBodyPart textMime = new MimeBodyPart();

            MimeBodyPart fileMime = new MimeBodyPart();

            try {

                textMime.setText(message);

                File file = new File(path);
                fileMime.attachFile(file);


                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(fileMime);


            } catch (Exception e) {

                e.printStackTrace();
            }


            m.setContent(link,"text/html");


            //send

            //Step 3 : send the message using Transport class
            Transport.send(m);


        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Sent success...................");


    }

    //this is responsible to send email..
    private static void sendEmail(String message, String subject, String to, String from) {

        //Variable for gmail
        String host = "smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Step 1: to get the session object..
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("techsoftindia2018@gmail.com", "Durgesh@123");
            }


        });

        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);

        try {

            //from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);


            //adding text to message
            m.setText(message);

            //send

            //Step 3 : send the message using Transport class
            Transport.send(m);

            System.out.println("Sent success...................");


        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
