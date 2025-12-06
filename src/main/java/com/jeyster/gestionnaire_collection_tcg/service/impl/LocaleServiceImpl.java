package com.jeyster.gestionnaire_collection_tcg.service.impl;

import com.jeyster.gestionnaire_collection_tcg.dto.LocaleDto;
import com.jeyster.gestionnaire_collection_tcg.mapper.LocaleMapper;
import com.jeyster.gestionnaire_collection_tcg.repository.LocaleRepository;
import com.jeyster.gestionnaire_collection_tcg.service.interfaces.LocaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocaleServiceImpl implements LocaleService {

    private final LocaleRepository localeRepository;
    private final LocaleMapper localeMapper;

    @Override
    public List<LocaleDto> getLocales() {
        return localeMapper.toDtoList(localeRepository.findAll());
    }

    @Override
    public LocaleDto getLocale(Long id) {
        return localeMapper.toDto(localeRepository.findById(id).orElse(null));
    }
}
