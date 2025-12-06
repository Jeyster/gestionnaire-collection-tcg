package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import com.jeyster.gestionnaire_collection_tcg.model.ItemType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemTypeMapper {

    ItemTypeDto toDto(ItemType itemType);

    List<ItemTypeDto> toDtoList(List<ItemType> itemTypes);

}
