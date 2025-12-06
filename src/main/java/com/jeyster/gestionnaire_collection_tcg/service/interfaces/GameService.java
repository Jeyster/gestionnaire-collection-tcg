package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;

import java.util.List;

public interface GameService {

    List<GameDto> getGames();

    GameDto getGame(Long id);

}
