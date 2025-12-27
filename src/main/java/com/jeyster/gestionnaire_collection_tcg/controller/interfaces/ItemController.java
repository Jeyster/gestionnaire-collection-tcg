package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.CreateItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/items")
public interface ItemController {

    @GetMapping
    ResponseEntity<Page<ItemDto>> getItems(
            @RequestParam(required = false) Long gameId,
            @RequestParam(required = false) Long itemTypeId,
            @RequestParam(required = false) Long localeId,
            @RequestParam(required = false) Long expansionId,
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "12") int pageSize,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    );

    @GetMapping("/{id}")
    ResponseEntity<ItemDto> getItem(@PathVariable Long id);

    @GetMapping("/{id}/price-histories")
    ResponseEntity<List<ItemPriceHistoryDto>> getItemPriceHistories(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ItemDto> createItem(@RequestBody CreateItemDto createItemDto);

}
