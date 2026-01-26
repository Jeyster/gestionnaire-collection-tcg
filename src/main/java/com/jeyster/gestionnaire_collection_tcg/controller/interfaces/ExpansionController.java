package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateGameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/expansions")
public interface ExpansionController {

    @GetMapping
    ResponseEntity<List<ExpansionDto>> getExpansions();

    @GetMapping("/{id}")
    ResponseEntity<ExpansionDto> getExpansion(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ExpansionDto> createExpansion(@RequestBody CreateExpansionDto createExpansionDto);

}
