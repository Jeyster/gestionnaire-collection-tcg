package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/v1/items")
public interface ItemController {

    @GetMapping
    ResponseEntity<List<ItemDto>> getItems(
            @RequestParam(name = "game-id", required = false) Long gameId,
            @RequestParam(name = "item-type-id", required = false) Long itemTypeId,
            @RequestParam(name = "locale-id", required = false) Long localeId,
            @RequestParam(name = "expansion-id", required = false) Long expansionId
    );

    @GetMapping("/{id}")
    ResponseEntity<ItemDto> getItem(@PathVariable Long id);

    @GetMapping("/{id}/price-histories")
    ResponseEntity<List<ItemPriceHistoryDto>> getItemPriceHistories(@PathVariable Long id);

}
