package com.jeyster.gestionnaire_collection_tcg.dto;

public record ExpansionDto(
        Long id,
        String name,
        GameDto game
) {}
