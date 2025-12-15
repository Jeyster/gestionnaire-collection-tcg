package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.ExpansionController;
import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ExpansionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpansionControllerImpl implements ExpansionController {

    private final ExpansionService expansionService;

    public ExpansionControllerImpl(ExpansionService expansionService) {
        this.expansionService = expansionService;
    }

    @Override
    public ResponseEntity<List<ExpansionDto>> getExpansions() {
        return ResponseEntity.ok(expansionService.getExpansions());
    }

    @Override
    public ResponseEntity<ExpansionDto> getExpansion(Long id) {
        return ResponseEntity.ok(expansionService.getExpansion(id));
    }
}


















