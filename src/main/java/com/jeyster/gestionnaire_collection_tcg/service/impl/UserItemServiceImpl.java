package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.CreateUserItemDto;
import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.UserItemMapper;
import com.jeyster.gestionnaire_collection_tcg.model.Item;
import com.jeyster.gestionnaire_collection_tcg.model.User;
import com.jeyster.gestionnaire_collection_tcg.model.UserItem;
import com.jeyster.gestionnaire_collection_tcg.repository.ItemRepository;
import com.jeyster.gestionnaire_collection_tcg.repository.UserItemRepository;
import com.jeyster.gestionnaire_collection_tcg.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final UserItemMapper userItemMapper;

    @Override
    public UserItemDto getUserItem(Long id) {
        return userItemMapper.toDto(userItemRepository.findById(id).orElse(null));
    }

    @Override
    public List<UserItemDto> getUserItems(Long userId, Long itemId) {
        return userItemMapper.toDtoList(userItemRepository.findAll(UserItemSpecifications.withFilters(userId, itemId)));
    }

    @Override
    public UserItemDto createUserItem(CreateUserItemDto createUserItemDto) {
        User user = userRepository.findById(createUserItemDto.userId()).orElse(null);
        Item item = itemRepository.findById(createUserItemDto.itemId()).orElse(null);

        UserItem userItem = new UserItem(
                user,
                item,
                createUserItemDto.purchasePrice(),
                createUserItemDto.purchaseDate(),
                createUserItemDto.comment()
        );
        return userItemMapper.toDto(userItemRepository.save(userItem));
    }
}
