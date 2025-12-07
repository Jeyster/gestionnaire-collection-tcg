package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.ItemController;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    @Override
    public ResponseEntity<List<ItemDto>> getItems(Long gameId, Long itemTypeId, Long localeId, Long expansionId) {
        return ResponseEntity.ok(itemService.getItems(gameId, itemTypeId, localeId, expansionId));
    }

    @Override
    public ResponseEntity<ItemDto> getItem(Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

}


















