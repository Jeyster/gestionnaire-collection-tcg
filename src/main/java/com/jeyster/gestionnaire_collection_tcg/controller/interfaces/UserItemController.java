package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/user-items")
public interface UserItemController {

    @GetMapping("/{id}")
    ResponseEntity<UserItemDto> getUserItem(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UserItemDto>> getUserItems(@RequestParam Long userId, @RequestParam Long itemId);

    @GetMapping("/count")
    ResponseEntity<Long> getUserItemsCount(@RequestParam Long userId, @RequestParam Long itemId);

    @PostMapping
    ResponseEntity<UserItemDto> createUserItem(@RequestBody CreateUserItemDto createUserItemDto);

    @PutMapping("{id}")
    ResponseEntity<UserItemDto> editUserItem(@PathVariable Long id, @RequestBody EditUserItemDto editUserItemDto);

    @PutMapping("/{id}/sell")
    ResponseEntity<UserItemDto> sellUserItem(@PathVariable Long id, @RequestBody SellUserItemDto sellUserItemDto);

    @PutMapping("/{id}/open")
    ResponseEntity<UserItemDto> openUserItem(@PathVariable Long id, @RequestBody OpenUserItemDto openUserItemDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUserItem(@PathVariable Long id);

}
