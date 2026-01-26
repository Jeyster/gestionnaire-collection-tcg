package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.LocaleDto;
import com.jeyster.gestionnaire_collection_tcg.dto.create.CreateLocaleDto;

import java.util.List;

public interface LocaleService {

    List<LocaleDto> getLocales();

    LocaleDto getLocale(Long id);

    LocaleDto createLocale(CreateLocaleDto createLocaleDto);
}
