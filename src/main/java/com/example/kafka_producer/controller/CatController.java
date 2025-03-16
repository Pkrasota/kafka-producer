package com.example.kafka_producer.controller;

import com.example.kafka_producer.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cat")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/generate")
    public ResponseEntity<?> generateCats() {
        catService.setupCats();
        return ResponseEntity.ok().build();
    }
}
