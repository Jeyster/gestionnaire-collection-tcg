package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.UserDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.UserMapper;
import com.jeyster.gestionnaire_collection_tcg.repository.UserRepository;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getUser(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }
}
