package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.ItemMapper;
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
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> getItems(Long gameId, Long itemTypeId, Long localeId, Long expansionId) {
        return itemMapper.toDtoList(itemRepository.findAll(ItemSpecifications.withFilters(gameId, itemTypeId, localeId, expansionId)));
    }

    @Override
    public ItemDto getItem(Long id) {
        return itemMapper.toDto(itemRepository.findById(id).orElse(null));
    }
}
