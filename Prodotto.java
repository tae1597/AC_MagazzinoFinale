package com.example.gestionale_magazzino.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codProdotto;

    private float prezzoBase;
    private String nome;
    private String marca;
    private int tempoSpedGg;
    private int stockMin;
    @Lob
    private byte[] QR;
    private int catProdotto;
    @Lob
    private byte[] immagine;

    // Getters e Setters
}