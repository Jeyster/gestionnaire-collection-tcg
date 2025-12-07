package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> getItems(Long gameId, Long itemTypeId, Long localeId, Long expansionId);

    ItemDto getItem(Long id);
}
