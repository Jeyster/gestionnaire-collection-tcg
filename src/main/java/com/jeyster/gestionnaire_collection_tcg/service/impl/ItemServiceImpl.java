package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.CreateItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.ItemPriceHistoryDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.*;
import com.jeyster.gestionnaire_collection_tcg.model.*;
import com.jeyster.gestionnaire_collection_tcg.repository.*;
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
    private final GameRepository gameRepository;
    private final ItemTypeRepository itemTypeRepository;
    private final LocaleRepository localeRepository;
    private final ExpansionRepository expansionRepository;
    private final ItemMapper itemMapper;
    private final ItemPriceHistoryMapper itemPriceHistoryMapper;
    private final GameMapper gameMapper;
    private final ItemTypeMapper itemTypeMapper;
    private final LocaleMapper localeMapper;
    private final ExpansionMapper expansionMapper;

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

    @Override
    public ItemDto createItem(CreateItemDto createItemDto) {
        Game game = gameRepository.findById(createItemDto.gameId()).orElse(null);
        ItemType itemType = itemTypeRepository.findById(createItemDto.itemTypeId()).orElse(null);
        Locale locale = localeRepository.findById(createItemDto.localeId()).orElse(null);
        Expansion expansion = expansionRepository.findById(createItemDto.expansionId()).orElse(null);

        Item item = Item.builder()
                .url(createItemDto.url())
                .game(game)
                .itemType(itemType)
                .locale(locale)
                .expansion(expansion)
                .complement(createItemDto.complement())
                .build();
        return itemMapper.toDto(itemRepository.save(item));
    }
}
