package com.example.gestionale_magazzino.controller;

import com.example.gestionale_magazzino.model.Contenuto;
import com.example.gestionale_magazzino.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magazzino")
public class MagazzinoController {
    @Autowired
    private ContenutoRepository contenutoRepository;

    @GetMapping("/{codMagazzino}/scorte")
    public ResponseEntity<List<Contenuto>> getScorte(@PathVariable int codMagazzino) {
        List<Contenuto> scorte = contenutoRepository.findByCodMagazzino(codMagazzino);
        return ResponseEntity.ok(scorte);
    }

    @PostMapping("/{codMagazzino}/aggiungi")
    public ResponseEntity<?> aggiungiProdotto(@PathVariable int codMagazzino, @RequestBody Contenuto contenuto) {
        contenuto.setCodMagazzino(codMagazzino);
        contenutoRepository.save(contenuto);
        return ResponseEntity.ok("Prodotto aggiunto al magazzino.");
    }
}