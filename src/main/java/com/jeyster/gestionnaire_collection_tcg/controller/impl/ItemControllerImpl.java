package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.ItemController;
import com.jeyster.gestionnaire_collection_tcg.dto.CreateItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    @Override
    public ResponseEntity<Page<ItemDto>> getItems(
            Long gameId,
            Long itemTypeId,
            Long localeId,
            Long expansionId,
            int pageIndex,
            int pageSize,
            String sort,
            String direction
    ) {
        return ResponseEntity.ok(
                itemService.getItems(
                        gameId,
                        itemTypeId,
                        localeId,
                        expansionId,
                        pageIndex,
                        pageSize,
                        sort,
                        direction
                )
        );
    }


    @Override
    public ResponseEntity<ItemDto> getItem(Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    @Override
    public ResponseEntity<List<ItemPriceHistoryDto>> getItemPriceHistories(Long id) {
        return ResponseEntity.ok(itemService.getItemPriceHistories(id));
    }

    @Override
    public ResponseEntity<ItemPriceHistoryDto> getLastItemPriceHistory(Long id) {
        return ResponseEntity.ok(itemService.getLastItemPriceHistory(id));
    }

    @Override
    public ResponseEntity<ItemDto> createItem(@Valid CreateItemDto createItemDto) {
        return ResponseEntity.ok(itemService.createItem(createItemDto));
    }

}


















