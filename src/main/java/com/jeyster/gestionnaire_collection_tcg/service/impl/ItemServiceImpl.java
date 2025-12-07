package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.ItemMapper;
import com.jeyster.gestionnaire_collection_tcg.mapper.ItemPriceHistoryMapper;
import com.jeyster.gestionnaire_collection_tcg.repository.ItemPriceHistoryRepository;
import com.jeyster.gestionnaire_collection_tcg.repository.ItemRepository;
import com.jeyster.gestionnaire_collection_tcg.repository.specifications.ItemSpecifications;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemPriceHistoryRepository itemPriceHistoryRepository;
    private final ItemMapper itemMapper;
    private final ItemPriceHistoryMapper itemPriceHistoryMapper;

    @Override
    public List<ItemDto> getItems(Long gameId, Long itemTypeId, Long localeId, Long expansionId) {
        return itemMapper.toDtoList(itemRepository.findAll(ItemSpecifications.withFilters(gameId, itemTypeId, localeId, expansionId)));
    }

    @Override
    public ItemDto getItem(Long id) {
        return itemMapper.toDto(itemRepository.findById(id).orElse(null));
    }

    @Override
    public List<ItemPriceHistoryDto> getItemPriceHistories(Long id) {
        return itemPriceHistoryMapper.toDtoList(itemPriceHistoryRepository.findAllByItemId(id));
    }
}
