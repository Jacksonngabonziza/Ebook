package com.Ebook.api.service;

//public class EmailSender {

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void SendSimpleEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("ngabojck@gmail.com");
        mailSender.send(message);
        // System.out.println("Sending email..");

    }
}