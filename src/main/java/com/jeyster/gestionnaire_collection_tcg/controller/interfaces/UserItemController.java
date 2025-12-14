package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.CreateUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.OpenUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.SellUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/user-items")
public interface UserItemController {

    @GetMapping("/{id}")
    ResponseEntity<UserItemDto> getUserItem(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UserItemDto>> getUserItem(@RequestParam Long userId, @RequestParam Long itemId);

    @PostMapping
    ResponseEntity<UserItemDto> createUserItem(@RequestBody CreateUserItemDto createUserItemDto);

    @PutMapping("/{id}/sell")
    ResponseEntity<UserItemDto> sellUserItem(@PathVariable Long id, @RequestBody SellUserItemDto sellUserItemDto);

    @PutMapping("/{id}/open")
    ResponseEntity<UserItemDto> openUserItem(@PathVariable Long id, @RequestBody OpenUserItemDto openUserItemDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUserItem(@PathVariable Long id);

}
