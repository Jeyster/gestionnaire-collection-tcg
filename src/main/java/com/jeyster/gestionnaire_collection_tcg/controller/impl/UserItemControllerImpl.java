package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.UserItemController;
import com.jeyster.gestionnaire_collection_tcg.dto.CreateUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.OpenUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.SellUserItemDto;
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
    public ResponseEntity<List<UserItemDto>> getUserItems(Long userId, Long itemId) {
        return ResponseEntity.ok(userItemService.getUserItems(userId, itemId));
    }

    @Override
    public ResponseEntity<UserItemDto> createUserItem(@Valid CreateUserItemDto createUserItemDto) {
        return ResponseEntity.ok(userItemService.createUserItem(createUserItemDto));
    }

    @Override
    public ResponseEntity<UserItemDto> sellUserItem(Long id, @Valid SellUserItemDto sellUserItemDto) {
        return ResponseEntity.ok(userItemService.sellUserItem(id, sellUserItemDto));
    }

    @Override
    public ResponseEntity<UserItemDto> openUserItem(Long id, @Valid OpenUserItemDto openUserItemDto) {
        return ResponseEntity.ok(userItemService.openUserItem(id, openUserItemDto));
    }

    @Override
    public ResponseEntity<Void> deleteUserItem(Long id) {
        userItemService.deleteUserItem(id);
        return ResponseEntity.noContent().build();
    }

}


















