package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import com.jeyster.gestionnaire_collection_tcg.model.ItemPriceHistory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemPriceHistoryMapper {

    ItemPriceHistoryDto toDto(ItemPriceHistory itemPriceHistory);

    List<ItemPriceHistoryDto> toDtoList(List<ItemPriceHistory> itemPriceHistories);

}
