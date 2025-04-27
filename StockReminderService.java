package com.example.gestionale_magazzino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.gestionale_magazzino.repository.ContenutoRepository;
import com.example.gestionale_magazzino.model.Contenuto;

@Service
public class StockReminderService {

    @Autowired
    private ContenutoRepository contenutoRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(cron = "0 0 8 * * ?") // Ogni giorno alle 8:00 AM
    public void checkStockLevels() {
        contenutoRepository.findAll().forEach(contenuto -> {
            if (contenuto.getQuantita() < contenuto.getProdotto().getStockmin()) {
                sendEmailAlert(contenuto);
            }
        });
    }

    private void sendEmailAlert(Contenuto contenuto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("admin@example.com");
        message.setSubject("Scorte Critiche: " + contenuto.getProdotto().getNome());
        message.setText("Il prodotto " + contenuto.getProdotto().getNome() +
                " ha raggiunto un livello critico di scorte. Quantità attuale: " + contenuto.getQuantita());
        mailSender.send(message);
    }
}