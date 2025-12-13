package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.UserItemMapper;
import com.jeyster.gestionnaire_collection_tcg.repository.UserItemRepository;
import com.jeyster.gestionnaire_collection_tcg.repository.specifications.ItemSpecifications;
import com.jeyster.gestionnaire_collection_tcg.repository.specifications.UserItemSpecifications;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.UserItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserItemServiceImpl implements UserItemService {

    private final UserItemRepository userItemRepository;
    private final UserItemMapper userItemMapper;

    @Override
    public UserItemDto getUserItem(Long id) {
        return userItemMapper.toDto(userItemRepository.findById(id).orElse(null));
    }

    @Override
    public List<UserItemDto> getUserItems(Long userId, Long itemId) {
        return userItemMapper.toDtoList(userItemRepository.findAll(UserItemSpecifications.withFilters(userId, itemId)));
    }
}
