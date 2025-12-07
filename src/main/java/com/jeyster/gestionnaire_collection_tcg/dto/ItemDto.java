package com.jeyster.gestionnaire_collection_tcg.dto;

public record ItemDto(
        Long id,
        String url,
        GameDto game,
        ItemTypeDto itemType,
        LocaleDto locale,
        ExpansionDto expansion,
        String complement
) {}
