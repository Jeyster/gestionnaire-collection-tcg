package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.ExpansionMapper;
import com.jeyster.gestionnaire_collection_tcg.repository.ExpansionRepository;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ExpansionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpansionServiceImpl implements ExpansionService {

    private final ExpansionRepository expansionRepository;
    private final ExpansionMapper expansionMapper;

    @Override
    public List<ExpansionDto> getExpansions() {
        return expansionMapper.toDtoList(expansionRepository.findAllByOrderByName());
    }

    @Override
    public ExpansionDto getExpansion(Long id) {
        return expansionMapper.toDto(expansionRepository.findById(id).orElse(null));
    }
}
