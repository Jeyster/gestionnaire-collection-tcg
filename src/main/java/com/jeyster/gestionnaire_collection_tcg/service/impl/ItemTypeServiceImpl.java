package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.ItemTypeMapper;
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
}
