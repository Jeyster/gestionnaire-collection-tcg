package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.CreateUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.OpenUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.SellUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;

import java.util.List;

public interface UserItemService {

    UserItemDto getUserItem(Long id);

    List<UserItemDto> getUserItems(Long userId, Long itemId);

    UserItemDto createUserItem(CreateUserItemDto createUserItemDto);

    UserItemDto sellUserItem(Long id, SellUserItemDto sellUserItemDto);

    UserItemDto openUserItem(Long id, OpenUserItemDto openUserItemDto);

    void deleteUserItem(Long id);
}
