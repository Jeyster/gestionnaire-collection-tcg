package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.ScrapingController;
import com.jeyster.gestionnaire_collection_tcg.service.impl.ScrapingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScrapingControllerImpl implements ScrapingController {

    private final ScrapingService scrapingService;

    @Override
    public ResponseEntity<Void> start() {
        scrapingService.startScraping();
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Void> stop() {
        scrapingService.stopScraping();
        return ResponseEntity.accepted().build();
    }

    @Override
    public boolean status() {
        return scrapingService.isRunning();
    }

    @Override
    public List<String> logs() {
        return scrapingService.getLogs();
    }
}
