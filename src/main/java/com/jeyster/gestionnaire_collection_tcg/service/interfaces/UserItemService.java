package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.*;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateUserItemDto;

import java.util.List;

public interface UserItemService {

    UserItemDto getUserItem(Long id);

    List<UserItemDto> getUserItems(Long userId, Long itemId);

    Long getUserItemsCount(Long userId, Long itemId);

    Long getUserItemsInStockCount(Long userId, Long itemId);

    Long getSoldUserItemsCount(Long userId, Long itemId);

    Long getOpenedUserItemsCount(Long userId, Long itemId);

    UserItemDto createUserItem(CreateUserItemDto createUserItemDto);

    UserItemDto editUserItem(Long id, EditUserItemDto editUserItemDto);

    UserItemDto sellUserItem(Long id, SellUserItemDto sellUserItemDto);

    UserItemDto openUserItem(Long id, OpenUserItemDto openUserItemDto);

    void deleteUserItem(Long id);
}
