package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.ExpansionMapper;
import com.jeyster.gestionnaire_collection_tcg.mapper.GameMapper;
import com.jeyster.gestionnaire_collection_tcg.repository.ExpansionRepository;
import com.jeyster.gestionnaire_collection_tcg.repository.GameRepository;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ExpansionRepository expansionRepository;
    private final GameMapper gameMapper;
    private final ExpansionMapper expansionMapper;

    @Override
    public List<GameDto> getGames() {
        return gameMapper.toDtoList(gameRepository.findAll());
    }

    @Override
    public GameDto getGame(Long id) {
        return gameMapper.toDto(gameRepository.findById(id).orElse(null));
    }

    @Override
    public List<ExpansionDto> getGameExpansions(Long id) {
        return expansionMapper.toDtoList(expansionRepository.findByGameId(id));
    }
}
