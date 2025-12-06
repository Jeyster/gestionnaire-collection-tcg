package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.GameController;
import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameControllerImpl implements GameController {

    private final GameService gameService;

    @Override
    public ResponseEntity<List<GameDto>> getGames() {
        return ResponseEntity.ok(gameService.getGames());
    }

    @Override
    public ResponseEntity<GameDto> getGame(Long id) {
        return ResponseEntity.ok(gameService.getGame(id));
    }

    @Override
    public ResponseEntity<List<ExpansionDto>> getGameExpansions(Long id) {
        return ResponseEntity.ok(gameService.getGameExpansions(id));
    }
}


















