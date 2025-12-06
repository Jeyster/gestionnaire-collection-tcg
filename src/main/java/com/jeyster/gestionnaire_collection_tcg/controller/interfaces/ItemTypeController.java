package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/v1/item-types")
public interface ItemTypeController {

    @GetMapping
    ResponseEntity<List<ItemTypeDto>> getItemTypes();

    @GetMapping("/{id}")
    ResponseEntity<ItemTypeDto> getItemType(@PathVariable Long id);

}
