package com.example.gestionale_magazzino.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void testSendEmail() {
        JavaMailSender mailSender = mock(JavaMailSender.class);
        NotificationService notificationService = new NotificationService();
        notificationService.setMailSender(mailSender);

        String to = "test@example.com";
        String subject = "Test Subject";
        String text = "Test Message";

        notificationService.sendEmail(to, subject, text);

        verify(mailSender, times(1)).send(Mockito.any(SimpleMailMessage.class));
    }
}