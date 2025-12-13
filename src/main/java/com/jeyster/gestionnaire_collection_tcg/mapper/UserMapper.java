package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.UserDto;
import com.jeyster.gestionnaire_collection_tcg.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

}
