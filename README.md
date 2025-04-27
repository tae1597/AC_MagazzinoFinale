# AC_MagazzinoFinale

**AC_MagazzinoFinale** è un progetto gestionale per la gestione di un magazzino. Include funzionalità avanzate come reminder per scorte minime, un'interfaccia utente basata su dashboard per monitorare lo stato del magazzino e un sistema di sicurezza robusto.

## Funzionalità principali

1. **Comunicazione TCP**:
   - Utilizza socket TCP per trasmettere dati come aggiornamenti di stock e notifiche.
   - Protocollo personalizzato basato su JSON.

2. **Reminder per Scorte Minime**:
   - Notifiche automatiche via email quando le scorte scendono sotto una soglia minima.
   - Visualizzazione dei reminder direttamente nella dashboard.

3. **Dashboard**:
   - Interfaccia utente moderna con `Chart.js`.
   - Visualizzazione delle scorte in tempo reale e avvisi critici.

4. **Sicurezza Avanzata**:
   - Crittografia AES per protezione dei dati sensibili.
   - Autenticazione sicura con token JWT e supporto TLS.

5. **Database**:
   - Struttura del database SQL inclusa per la gestione dei dati del magazzino.

## Requisiti

- **Java 17+**
- **Spring Boot**
- **MySQL** per il database.
- **Node.js** (per il front-end della dashboard).
- **Maven** per la gestione delle dipendenze.

## Installazione

1. **Clona la repository**:
   ```bash
   git clone https://github.com/tae1597/AC_MagazzinoFinale.git
   ```
2. **Configura il database**:
   - Importa il file `gestionale_magazzino.sql` in MySQL.
   - Aggiorna il file `application.properties` con le tue credenziali del database.

3. **Avvia il server Spring Boot**:
   ```bash
   mvn spring-boot:run
   ```

4. **Avvia il front-end**:
   - Vai nella cartella `dashboard`.
   - Installa le dipendenze:
     ```bash
     npm install
     ```
   - Avvia il server:
     ```bash
     npm start
     ```

## Contribuire

Le richieste di pull sono benvenute. Per modifiche significative, apri prima una issue per discutere cosa vorresti cambiare.

## Licenza

Questo progetto è rilasciato sotto la licenza MIT. Consulta il file `LICENSE` per maggiori dettagli.