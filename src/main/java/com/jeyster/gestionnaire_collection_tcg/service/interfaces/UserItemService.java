package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.CreateUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface UserItemService {

    UserItemDto getUserItem(Long id);

    List<UserItemDto> getUserItems(Long userId, Long itemId);

    UserItemDto createUserItem(CreateUserItemDto createUserItemDto);
}
