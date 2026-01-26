package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.ExpansionMapper;
import com.jeyster.gestionnaire_collection_tcg.mapper.GameMapper;
import com.jeyster.gestionnaire_collection_tcg.model.Expansion;
import com.jeyster.gestionnaire_collection_tcg.model.Game;
import com.jeyster.gestionnaire_collection_tcg.repository.ExpansionRepository;
import com.jeyster.gestionnaire_collection_tcg.repository.GameRepository;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ExpansionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpansionServiceImpl implements ExpansionService {

    private final ExpansionRepository expansionRepository;
    private final ExpansionMapper expansionMapper;
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Override
    public List<ExpansionDto> getExpansions() {
        return expansionMapper.toDtoList(expansionRepository.findAllByOrderByName());
    }

    @Override
    public ExpansionDto getExpansion(Long id) {
        return expansionMapper.toDto(expansionRepository.findById(id).orElse(null));
    }

    @Override
    public ExpansionDto createExpansion(CreateExpansionDto createExpansionDto) {
        Game game = gameRepository.findById(createExpansionDto.gameId()).orElse(null);
        Expansion expansion = Expansion.builder()
                .name(createExpansionDto.name())
                .game(game)
                .build();

        return expansionMapper.toDto(expansionRepository.save(expansion));
    }
}
