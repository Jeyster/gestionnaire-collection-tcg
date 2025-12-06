package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.ItemTypeController;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemTypeControllerImpl implements ItemTypeController {

    private final ItemTypeService itemTypeService;

    @Override
    public ResponseEntity<List<ItemTypeDto>> getItemTypes() {
        return ResponseEntity.ok(itemTypeService.getItemTypes());
    }

    @Override
    public ResponseEntity<ItemTypeDto> getItemType(Long id) {
        return ResponseEntity.ok(itemTypeService.getItemType(id));
    }
}


















