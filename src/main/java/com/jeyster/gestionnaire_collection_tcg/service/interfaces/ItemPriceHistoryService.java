package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;

import java.util.List;

public interface ItemPriceHistoryService {

    List<ItemPriceHistoryDto> getItemPriceHistories(Long itemId);

    ItemPriceHistoryDto getItemPriceHistory(Long id);
}
