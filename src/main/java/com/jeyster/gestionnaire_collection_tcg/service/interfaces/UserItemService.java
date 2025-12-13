package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;

import java.util.List;

public interface UserItemService {

    UserItemDto getUserItem(Long id);

    List<UserItemDto> getUserItems(Long userId, Long itemId);

}
