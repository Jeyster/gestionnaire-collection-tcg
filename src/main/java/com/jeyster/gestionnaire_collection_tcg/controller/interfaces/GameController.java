package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/v1/games")
public interface GameController {

    @GetMapping
    ResponseEntity<List<GameDto>> getGames();

    @GetMapping("/{id}")
    ResponseEntity<GameDto> getGame(@PathVariable Long id);

}
