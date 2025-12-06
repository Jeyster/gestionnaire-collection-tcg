package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.ItemTypeDto;

import java.util.List;

public interface ItemTypeService {

    List<ItemTypeDto> getItemTypes();

    ItemTypeDto getItemType(Long id);

}
