package com.example.gestionale_magazzino.controller;

import com.example.gestionale_magazzino.model.Acquisto;
import com.example.gestionale_magazzino.repository.AcquistoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acquisti")
public class AcquistoController {
    @Autowired
    private AcquistoRepository acquistoRepository;

    @GetMapping("/")
    public ResponseEntity<?> getTuttiGliAcquisti() {
        return ResponseEntity.ok(acquistoRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> creaAcquisto(@RequestBody Acquisto acquisto) {
        acquistoRepository.save(acquisto);
        return ResponseEntity.ok("Acquisto registrato con successo.");
    }
}