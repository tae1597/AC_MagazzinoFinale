package com.example.gestionale_magazzino.controller;

import com.example.gestionale_magazzino.repository.ContenutoRepository;
import com.example.gestionale_magazzino.model.Contenuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ContenutoRepository contenutoRepository;

    @GetMapping("/scorte")
    public ResponseEntity<List<Contenuto>> getScorte() {
        return ResponseEntity.ok(contenutoRepository.findAll());
    }
}