package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateExpansionDto;

import java.util.List;

public interface ExpansionService {

    List<ExpansionDto> getExpansions();

    ExpansionDto getExpansion(Long id);

    ExpansionDto createExpansion(CreateExpansionDto createExpansionDto);
}
