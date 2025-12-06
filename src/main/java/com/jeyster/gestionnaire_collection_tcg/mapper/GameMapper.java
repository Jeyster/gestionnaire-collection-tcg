package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.GameDto;
import com.jeyster.gestionnaire_collection_tcg.model.Game;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameDto toDto(Game item);

    List<GameDto> toDtoList(List<Game> item);

}
