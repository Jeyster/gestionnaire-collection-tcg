package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/item-price-histories")
public interface ItemPriceHistoryController {

    @GetMapping("/{id}")
    ResponseEntity<ItemPriceHistoryDto> getItemPriceHistory(@PathVariable Long id);

}
