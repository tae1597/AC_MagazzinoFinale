package com.example.gestionale_magazzino.model;

import jakarta.persistence.*;

@Entity
@Table(name = "azienda")
public class Azienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codAzienda;

    private int datiBancari;
    private String PIVA;
    private boolean multiMagazzino;
    private int catAzienda;
    private String telAziendale;
    private String mailAziendale;

    // Getters e Setters
}