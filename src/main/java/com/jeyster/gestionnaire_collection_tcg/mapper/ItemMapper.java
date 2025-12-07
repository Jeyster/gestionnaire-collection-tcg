package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDto toDto(Item item);

    List<ItemDto> toDtoList(List<Item> items);

}
