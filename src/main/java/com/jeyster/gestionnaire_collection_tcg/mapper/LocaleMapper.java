package com.jeyster.gestionnaire_collection_tcg.mapper;

import com.jeyster.gestionnaire_collection_tcg.dto.LocaleDto;
import com.jeyster.gestionnaire_collection_tcg.model.Locale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocaleMapper {

    LocaleDto toDto(Locale locale);

    List<LocaleDto> toDtoList(List<Locale> locales);

}
