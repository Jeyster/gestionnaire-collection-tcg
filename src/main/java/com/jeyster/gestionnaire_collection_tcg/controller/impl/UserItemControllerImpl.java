package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.UserItemController;
import com.jeyster.gestionnaire_collection_tcg.dto.CreateUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.UserItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserItemControllerImpl implements UserItemController {

    private final UserItemService userItemService;

    @Override
    public ResponseEntity<UserItemDto> getUserItem(Long id) {
        return ResponseEntity.ok(userItemService.getUserItem(id));
    }

    @Override
    public ResponseEntity<List<UserItemDto>> getUserItem(Long userId, Long itemId) {
        return ResponseEntity.ok(userItemService.getUserItems(userId, itemId));
    }

    @Override
    public ResponseEntity<UserItemDto> createUserItem(@Valid CreateUserItemDto createUserItemDto) {
        return ResponseEntity.ok(userItemService.createUserItem(createUserItemDto));
    }
}


















