-- Inserimento di aziende
INSERT INTO azienda (datiBancari, `P.IVA`, multiMagazzino, catAzienda, tel_aziendale, mail_aziendale)
VALUES
(1, '12345678901', 1, 1, '0123456789', 'azienda1@example.com'),
(2, '98765432109', 0, 2, '0987654321', 'azienda2@example.com');

-- Inserimento di dati bancari
INSERT INTO datibancari (datiBancari, cognome, nome, carta, data_scadenza, codice)
VALUES
(1, 'Rossi', 'Mario', 1234567890123456, '12/25', 123),
(2, 'Verdi', 'Luigi', 9876543210987654, '11/26', 456);

-- Inserimento di indirizzi
INSERT INTO indirizzo (codIndirizzo, paese, cap, via, civico)
VALUES
(1, 'Italia', '00100', 'Via Roma', '10'),
(2, 'Italia', '20100', 'Corso Milano', '20');

-- Inserimento di magazzini
INSERT INTO magazzino (codMagazzino, codAzienda, codIndirizzo)
VALUES
(1, 1, 1),
(2, 2, 2);

-- Inserimento di categorie di prodotti
INSERT INTO nomicategorie (codCategoria, nomeCategoria, tipo)
VALUES
(1, 'Alimenti freschi', 'prodotto'),
(2, 'Attrezzature', 'prodotto');

-- Inserimento di prodotti
INSERT INTO prodotto (prezzo_base, nome, marca, tempo_sped_gg, stockmin, QR, catProdotto, Immagine)
VALUES
(10.99, 'Mela', 'Fruttital', 3, 50, null, 1, null),
(299.99, 'Trapano', 'Bosch', 5, 10, null, 2, null);

-- Inserimento di contenuti nei magazzini
INSERT INTO contenuto (codMagazzino, codProdotto, quantita, prezzo_fissato, ultimoaggiornamento)
VALUES
(1, 1, 100, 10.50, '2025-04-01'),
(2, 2, 15, 280.00, '2025-04-01');

-- Inserimento di utenti
INSERT INTO utente (password, nome, cognome, CF, dataNascita, codAzienda, mail, tel)
VALUES
('password123', 'Giulia', 'Bianchi', 'BNCGLI90A01H501Z', '1990-01-01', 1, 'giulia.bianchi@example.com', '3331234567'),
('password456', 'Marco', 'Neri', 'NRIMRC85C01H501Y', '1985-03-01', 2, 'marco.neri@example.com', '3337654321');

-- Inserimento di acquisti
INSERT INTO acquisto (codProdotto)
VALUES
(1),
(2);

-- Inserimento di spedizioni
INSERT INTO spedizione (datiBancari, quantita, importo, data_acquisto, codAcquisto, dataArrivo, codMagazzino, stato, codUtente)
VALUES
(1, 10, 105.00, '2025-04-20', 1, '2025-04-25', 1, 'Spedito', 1),
(2, 5, 1400.00, '2025-04-21', 2, '2025-04-28', 2, 'In preparazione', 2);