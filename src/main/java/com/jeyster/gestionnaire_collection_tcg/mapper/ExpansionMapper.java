package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.ExpansionDto;
import com.jeyster.gestionnaire_collection_tcg.model.Expansion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpansionMapper {

    ExpansionDto toDto(Expansion expansion);

    List<ExpansionDto> toDtoList(List<Expansion> expansions);

}
