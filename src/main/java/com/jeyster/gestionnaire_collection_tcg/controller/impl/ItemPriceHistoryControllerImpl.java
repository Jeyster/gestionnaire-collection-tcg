package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.ItemPriceHistoryController;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemPriceHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemPriceHistoryControllerImpl implements ItemPriceHistoryController {

    private final ItemPriceHistoryService itemPriceHistoryService;

    @Override
    public ResponseEntity<ItemPriceHistoryDto> getItemPriceHistory(Long id) {
        return ResponseEntity.ok(itemPriceHistoryService.getItemPriceHistory(id));
    }

}


















