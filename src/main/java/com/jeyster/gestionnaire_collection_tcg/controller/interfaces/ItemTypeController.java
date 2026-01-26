package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateGameDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateItemTypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/item-types")
public interface ItemTypeController {

    @GetMapping
    ResponseEntity<List<ItemTypeDto>> getItemTypes();

    @GetMapping("/{id}")
    ResponseEntity<ItemTypeDto> getItemType(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ItemTypeDto> createItemType(@RequestBody CreateItemTypeDto createItemTypeDto);

}
