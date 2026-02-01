package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.*;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateItemDto;
import com.jeyster.gestionnaire_collection_tcg.exception.AlreadyExistingObjectException;
import com.jeyster.gestionnaire_collection_tcg.exception.NotExistingObjectException;
import com.jeyster.gestionnaire_collection_tcg.mapper.*;
import com.jeyster.gestionnaire_collection_tcg.model.*;
import com.jeyster.gestionnaire_collection_tcg.repository.*;
import com.jeyster.gestionnaire_collection_tcg.repository.specifications.ItemSpecifications;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<ItemDto> getItems(
        Long gameId,
        Long itemTypeId,
        Long localeId,
        Long expansionId,
        int pageIndex,
        int pageSize,
        String sort,
        String direction
    ) {
        Sort.Direction sortDirection =
            "desc".equalsIgnoreCase(direction)
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
            pageIndex,
            pageSize,
            Sort.by(sortDirection, sort)
        );

        return itemRepository
            .findAll(
                ItemSpecifications.withFilters(gameId, itemTypeId, localeId, expansionId),
                pageable
            )
            .map(itemMapper::toDto);
    }

    @Override
    public List<ItemDto> getItems(ToggleCmScrapingDto toggleCmScrapingDto) {
        return itemMapper.toDtoList(itemRepository.findAllByIsCmScrapingActiveOrderById(toggleCmScrapingDto.isCmScrapingActive()));
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
    public ItemPriceHistoryDto getLastItemPriceHistory(Long id) {
        return itemPriceHistoryMapper.toDto(itemPriceHistoryRepository.findFirstByItemIdOrderByCreatedAtDesc(id).orElse(null));
    }

    @Override
    public ItemDto createItem(CreateItemDto createItemDto) {
        Item existingItem = itemRepository.findByUrl(createItemDto.url());
        if (existingItem != null) {
            throw new AlreadyExistingObjectException(existingItem.getUrl(), false);
        }

        Game game = gameRepository.findById(createItemDto.gameId()).orElse(null);
        ItemType itemType = itemTypeRepository.findById(createItemDto.itemTypeId()).orElse(null);
        Locale locale = localeRepository.findById(createItemDto.localeId()).orElse(null);
        Expansion expansion = expansionRepository.findById(createItemDto.expansionId()).orElse(null);

        if (game == null || itemType == null || locale == null || expansion == null) {
            throw new NotExistingObjectException();
        }

        Item item = Item.builder()
                .url(createItemDto.url())
                .game(game)
                .itemType(itemType)
                .locale(locale)
                .expansion(expansion)
                .complement(createItemDto.complement())
                .isCmScrapingActive(createItemDto.isCmScrapingActive())
                .build();
        return itemMapper.toDto(itemRepository.save(item));
    }

    @Override
    public ItemDto toggleCmScraping(Long id, ToggleCmScrapingDto toggleCmScrapingDto) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item == null) {
            return null;
        }
        item.setIsCmScrapingActive(toggleCmScrapingDto.isCmScrapingActive());

        return itemMapper.toDto(itemRepository.save(item));
    }

    @Override
    public List<ItemDto> bulkToggleCmScraping(BulkToggleCmScrapingDto bulkToggleCmScrapingDto) {
        boolean isCmScrapingActive = bulkToggleCmScrapingDto.isCmScrapingActive();
        List<Long> itemIds = bulkToggleCmScrapingDto.itemIds();
        List<Item> items = itemRepository.findAllById(itemIds);

        items.forEach(item -> item.setIsCmScrapingActive(isCmScrapingActive));

        return itemMapper.toDtoList(itemRepository.saveAll(items));
    }
}
