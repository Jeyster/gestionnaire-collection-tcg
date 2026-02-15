package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateItemTypeDto;
import com.jeyster.gestionnaire_collection_tcg.exception.AlreadyExistingObjectException;
import com.jeyster.gestionnaire_collection_tcg.exception.NotExistingObjectException;
import com.jeyster.gestionnaire_collection_tcg.mapper.ItemTypeMapper;
import com.jeyster.gestionnaire_collection_tcg.model.Item;
import com.jeyster.gestionnaire_collection_tcg.model.ItemType;
import com.jeyster.gestionnaire_collection_tcg.repository.ItemTypeRepository;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.ItemTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemTypeServiceImpl implements ItemTypeService {

    private final ItemTypeRepository itemTypeRepository;
    private final ItemTypeMapper itemTypeMapper;

    @Override
    public List<ItemTypeDto> getItemTypes() {
        return itemTypeMapper.toDtoList(itemTypeRepository.findAllByOrderByName());
    }

    @Override
    public ItemTypeDto getItemType(Long id) {
        return itemTypeMapper.toDto(itemTypeRepository.findById(id).orElse(null));
    }

    /**
     * Create an {@link ItemType} from a {@link CreateItemTypeDto}.
     * Throw {@link AlreadyExistingObjectException} if item type name already used.
     *
     * @param createItemTypeDto the {@link ItemType} to create
     * @return the created item type
     */
    @Override
    public ItemTypeDto createItemType(CreateItemTypeDto createItemTypeDto) {
        ItemType itemType = itemTypeRepository.findByName(createItemTypeDto.name());
        if (itemType != null) {
            throw new AlreadyExistingObjectException(itemType.getName(), true);
        }

        return itemTypeMapper.toDto(itemTypeRepository.save(itemTypeMapper.toEntity(createItemTypeDto)));
    }
}
