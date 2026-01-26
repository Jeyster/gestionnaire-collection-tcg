package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateItemTypeDto;

import java.util.List;

public interface ItemTypeService {

    List<ItemTypeDto> getItemTypes();

    ItemTypeDto getItemType(Long id);

    ItemTypeDto createItemType(CreateItemTypeDto createItemTypeDto);
}
