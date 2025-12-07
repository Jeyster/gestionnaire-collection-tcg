package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.ItemPriceHistoryMapper;
import com.jeyster.gestionnaire_collection_tcg.repository.ItemPriceHistoryRepository;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemPriceHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPriceHistoryServiceImpl implements ItemPriceHistoryService {

    private final ItemPriceHistoryRepository itemPriceHistoryRepository;
    private final ItemPriceHistoryMapper itemPriceHistoryMapper;

    @Override
    public List<ItemPriceHistoryDto> getItemPriceHistories(Long itemId) {
        return itemPriceHistoryMapper.toDtoList(itemPriceHistoryRepository.findAllByItemId(itemId));
    }

    @Override
    public ItemPriceHistoryDto getItemPriceHistory(Long id) {
        return itemPriceHistoryMapper.toDto(itemPriceHistoryRepository.findById(id).orElse(null));
    }
}
