package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.LocaleController;
import com.jeyster.gestionnaire_collection_tcg.dto.LocaleDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.LocaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocaleControllerImpl implements LocaleController {

    private final LocaleService localeService;

    @Override
    public ResponseEntity<List<LocaleDto>> getLocales() {
        return ResponseEntity.ok(localeService.getLocales());
    }

    @Override
    public ResponseEntity<LocaleDto> getLocale(Long id) {
        return ResponseEntity.ok(localeService.getLocale(id));
    }
}


















