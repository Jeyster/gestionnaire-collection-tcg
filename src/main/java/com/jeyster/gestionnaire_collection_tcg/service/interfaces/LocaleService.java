package com.jeyster.gestionnaire_collection_tcg.service.interfaces;

import com.jeyster.gestionnaire_collection_tcg.dto.LocaleDto;

import java.util.List;

public interface LocaleService {

    List<LocaleDto> getLocales();

    LocaleDto getLocale(Long id);

}
