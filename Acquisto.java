package com.example.gestionale_magazzino.model;

import jakarta.persistence.*;

@Entity
@Table(name = "acquisto")
public class Acquisto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codAcquisto;

    private int codProdotto;

    // Getters e Setters
}