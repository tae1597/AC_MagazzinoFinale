-- Script di creazione del database per il gestionale magazzino

CREATE DATABASE IF NOT EXISTS gestionale_magazzino;

USE gestionale_magazzino;

-- Tabella per i prodotti
CREATE TABLE prodotto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descrizione TEXT,
    prezzo DECIMAL(10, 2),
    stockmin INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabella per il magazzino
CREATE TABLE magazzino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prodotto_id INT NOT NULL,
    quantita INT NOT NULL,
    FOREIGN KEY (prodotto_id) REFERENCES prodotto(id) ON DELETE CASCADE
);

-- Dati di esempio
INSERT INTO prodotto (nome, descrizione, prezzo, stockmin) VALUES
('Prodotto A', 'Descrizione A', 10.00, 5),
('Prodotto B', 'Descrizione B', 20.00, 10);

INSERT INTO magazzino (prodotto_id, quantita) VALUES
(1, 3), -- Prodotto A sotto soglia
(2, 15); -- Prodotto B sopra soglia