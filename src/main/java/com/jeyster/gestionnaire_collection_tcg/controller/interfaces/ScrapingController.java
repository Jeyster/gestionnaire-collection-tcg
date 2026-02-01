package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/scraping")
public interface ScrapingController {

    @PostMapping("/start")
    ResponseEntity<Void> start();

    @GetMapping("/status")
    boolean status();

    @GetMapping("/logs")
    List<String> logs();
}
