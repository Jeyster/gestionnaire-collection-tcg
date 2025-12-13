package com.jeyster.gestionnaire_collection_tcg.controller.impl;

import com.jeyster.gestionnaire_collection_tcg.controller.interfaces.UserController;
import com.jeyster.gestionnaire_collection_tcg.dto.UserDto;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> getUser(Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}


















