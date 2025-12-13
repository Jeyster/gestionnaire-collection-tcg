package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.UserItemDto;
import com.jeyster.gestionnaire_collection_tcg.model.UserItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserItemMapper {

    UserItemDto toDto(UserItem userItem);

    List<UserItemDto> toDtoList(List<UserItem> userItems);

}
