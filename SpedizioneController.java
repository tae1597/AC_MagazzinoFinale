package com.example.gestionale_magazzino.controller;

import com.example.gestionale_magazzino.model.Spedizione;
import com.example.gestionale_magazzino.repository.SpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spedizioni")
public class SpedizioneController {
    @Autowired
    private SpedizioneRepository spedizioneRepository;

    @GetMapping("/")
    public ResponseEntity<List<Spedizione>> getTutteLeSpedizioni() {
        return ResponseEntity.ok(spedizioneRepository.findAll());
    }
}