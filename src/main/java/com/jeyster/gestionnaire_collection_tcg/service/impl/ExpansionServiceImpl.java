package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.exception.AlreadyExistingObjectException;
import com.jeyster.gestionnaire_collection_tcg.exception.NotExistingObjectException;
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

    /**
     * Create an {@link Expansion} from a {@link CreateExpansionDto}.
     * Throw exception if :
     *  - expansion name already used -> {@link AlreadyExistingObjectException}
     *  - expansion game name not in database -> {@link NotExistingObjectException}
     *
     * @param createExpansionDto the expansion to create
     * @return the created expansion
     */
    @Override
    public ExpansionDto createExpansion(CreateExpansionDto createExpansionDto) {
        Expansion existingExpansion = expansionRepository.findByName(createExpansionDto.expansionName());
        if (existingExpansion != null) {
            throw new AlreadyExistingObjectException(existingExpansion.getName(), true);
        }

        Game game = gameRepository.findById(createExpansionDto.gameId()).orElse(null);
        if (game == null) {
            throw new NotExistingObjectException(Game.class.getSimpleName(), createExpansionDto.gameId());
        }

        Expansion expansion = Expansion.builder()
                .name(createExpansionDto.expansionName())
                .game(game)
                .build();
        return expansionMapper.toDto(expansionRepository.save(expansion));
    }
}
