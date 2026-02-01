package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.LocaleDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateLocaleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/locales")
public interface LocaleController {

    @GetMapping
    ResponseEntity<List<LocaleDto>> getLocales();

    @GetMapping("/{id}")
    ResponseEntity<LocaleDto> getLocale(@PathVariable Long id);

    @PostMapping
    ResponseEntity<LocaleDto> createLocale(@RequestBody CreateLocaleDto createLocaleDto);

}
