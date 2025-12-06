package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/v1/expansions")
public interface ExpansionController {

    @GetMapping
    ResponseEntity<List<ExpansionDto>> getExpansions();

    @GetMapping("/{id}")
    ResponseEntity<ExpansionDto> getExpansion(@PathVariable Long id);

}
