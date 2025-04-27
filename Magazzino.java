package com.example.gestionale_magazzino.model;

import jakarta.persistence.*;

@Entity
@Table(name = "magazzino")
public class Magazzino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codMagazzino;

    private int codAzienda;
    private int codIndirizzo;

    // Getters e Setters
}