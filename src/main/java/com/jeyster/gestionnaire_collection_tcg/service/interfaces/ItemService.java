package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.CreateItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ItemService {

    List<ItemDto> getItems(Long gameId, Long itemTypeId, Long localeId, Long expansionId);

    ItemDto getItem(Long id);

    List<ItemPriceHistoryDto> getItemPriceHistories(Long id);

    ItemDto createItem(CreateItemDto createItemDto);
}
