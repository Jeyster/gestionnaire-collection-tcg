package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface GameService {

    List<GameDto> getGames();

    GameDto getGame(Long id);

    List<ExpansionDto> getGameExpansions(Long id);

    List<ItemTypeDto> getGameItemTypes(Long id);
}
