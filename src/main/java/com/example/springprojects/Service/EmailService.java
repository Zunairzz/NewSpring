package com.example.springprojects.Service;

import com.example.springprojects.Entities.Model.UserEmails;
import com.example.springprojects.Repository.UserEmailRepository;
import com.example.springprojects.Utils.Constants;
import com.example.springprojects.Utils.Response;
import com.example.springprojects.Utils.ResponseCode;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;
import java.util.Properties;

@Service
public class EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailService.class);
    @Autowired
    UserEmailRepository userEmailRepository;

    public Response<UserEmails> sendEmail() {

        logger.info("Get system properties");
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //host set
        logger.info("Set google credentials");
        properties.put("mail.smtp.host", Constants.HOST);
        properties.put("mail.smtp.port", Constants.PORT);
        properties.put("mail.smtp.ssl.enable", Constants.SSL_ENABLE);
        properties.put("mail.smtp.auth", Constants.AUTH);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Constants.USERNAME, Constants.PASSWORD);
            }
        });
        session.setDebug(true);

        // Emails
        logger.info("Emails recevied");
        List<UserEmails> userEmailsList = userEmailRepository.findAllBy();
        for (int i = 0; i < userEmailsList.size(); i++) {

            byte[] bytesEncoded = Base64.encodeBase64(userEmailsList.get(i).getSecret_code().getBytes());

            //Step 2 : compose the message [text,multi media]
            MimeMessage message = new MimeMessage(session);
            String createLink = "http://localhost:7075/email/" + new String(bytesEncoded);;
            String resLink = link(createLink);
            try {
                message.setFrom(Constants.EMAIL_FROM);
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmailsList.get(i).getEmail()));
                message.setSubject(Constants.SUBJECT);

                //attachement..
//                String filePath = email.getFile();
                MimeMultipart mimeMultipart = new MimeMultipart();
                // body
                MimeBodyPart textMime = new MimeBodyPart();
                //link
                MimeBodyPart linkMime = new MimeBodyPart();
                //file
//                MimeBodyPart fileMime = new MimeBodyPart();
//                if (filePath != null && !filePath.equals("")) {
//                    File file = new File(filePath);
//                    fileMime.attachFile(file);
//                    mimeMultipart.addBodyPart(fileMime);
//                }

                textMime.setText(Constants.EMAIL_BODY);
                linkMime.setContent(resLink, "text/html");

                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(linkMime);

                message.setContent(mimeMultipart);
                Transport.send(message);
                logger.info("Email sent successfully...");

            } catch (MessagingException e) {
                logger.warn("Request for sending mail to this " + userEmailsList.get(i).getEmail() + "is faild!");
                return new Response<>(ResponseCode.BAD_REQUEST, "Bad Request");
            }

            System.out.println("Sent success...................");

        }
        return new Response<>(ResponseCode.SUCCESS, "Emails send successfully!");
    }

    public String link(String redirectLink) {
        return "In order to unsubscribe email please click on the following link:\n" +
                "<a href='" + redirectLink + "'>Click here!</a>";
    }

    public Response<UserEmails> unsubscribe(String userCode) {
        // Decode data on other side, by processing encoded data
        byte[] userCodeDecoded = Base64.decodeBase64(userCode);
        UserEmails existing = userEmailRepository.findAllByUserCode(new String(userCodeDecoded));
        if (existing != null) {
            existing.setSubscription(false);
            userEmailRepository.save(existing);
        } else {
            return new Response<>(ResponseCode.RECORD_NOT_FOUND, "No Entry Found!");
        }
        return new Response<>(ResponseCode.SUCCESS, "Record Update Successfully!");
    }
}
