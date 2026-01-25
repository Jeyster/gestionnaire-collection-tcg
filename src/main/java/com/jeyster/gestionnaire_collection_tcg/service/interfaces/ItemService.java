package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {

    Page<ItemDto> getItems(
            Long gameId,
            Long itemTypeId,
            Long localeId,
            Long expansionId,
            int pageIndex,
            int pageSize,
            String sort,
            String direction
    );

    ItemDto getItem(Long id);

    List<ItemPriceHistoryDto> getItemPriceHistories(Long id);

    ItemPriceHistoryDto getLastItemPriceHistory(Long id);

    ItemDto createItem(CreateItemDto createItemDto);

    ItemDto toggleCmScraping(Long id, ToggleCmScrapingDto toggleCmScrapingDto);

    List<ItemDto> bulkToggleCmScraping(BulkToggleCmScrapingDto bulkToggleCmScrapingDto);
}
