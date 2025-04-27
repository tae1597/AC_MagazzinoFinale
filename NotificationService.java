package com.example.gestionale_magazzino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    private static final String TWILIO_ACCOUNT_SID = "YOUR_TWILIO_ACCOUNT_SID";
    private static final String TWILIO_AUTH_TOKEN = "YOUR_TWILIO_AUTH_TOKEN";
    private static final String TWILIO_PHONE_NUMBER = "YOUR_TWILIO_PHONE_NUMBER";

    static {
        Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
    }

    // Inviare email
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    // Inviare SMS
    public void sendSms(String to, String text) {
        Message.creator(new com.twilio.type.PhoneNumber(to),
                        new com.twilio.type.PhoneNumber(TWILIO_PHONE_NUMBER),
                        text).create();
    }
}