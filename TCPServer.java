package com.example.gestionale_magazzino.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server TCP in ascolto sulla porta " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connessione accettata da " + clientSocket.getInetAddress());

                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Ricevuto: " + inputLine);

                // Logica per gestire i dati ricevuti
                String response = "Conferma ricezione: " + inputLine;
                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}