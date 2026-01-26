package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.*;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateGameDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/games")
public interface GameController {

    @GetMapping
    ResponseEntity<List<GameDto>> getGames();

    @GetMapping("/{id}")
    ResponseEntity<GameDto> getGame(@PathVariable Long id);

    @GetMapping("/{id}/expansions")
    ResponseEntity<List<ExpansionDto>> getGameExpansions(@PathVariable Long id);

    @GetMapping("/{id}/item-types")
    ResponseEntity<List<ItemTypeDto>> getGameItemTypes(@PathVariable Long id);

    @PostMapping
    ResponseEntity<GameDto> createGame(@RequestBody CreateGameDto createGameDto);

}
