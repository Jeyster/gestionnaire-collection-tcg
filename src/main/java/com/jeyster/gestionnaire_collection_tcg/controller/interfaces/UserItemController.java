package com.jeyster.gestionnaire_collection_tcg.controller.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/v1/user-items")
public interface UserItemController {

    @GetMapping("/{id}")
    ResponseEntity<UserItemDto> getUserItem(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UserItemDto>> getUserItem(@RequestParam Long userId, @RequestParam Long itemId);

}
