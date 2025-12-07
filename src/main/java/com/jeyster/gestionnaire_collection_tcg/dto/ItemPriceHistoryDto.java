package com.jeyster.gestionnaire_collection_tcg.dto;

import java.time.LocalDateTime;

public record ItemPriceHistoryDto(
        Long id,
        ItemDto item,
        Double averagePrice,
        LocalDateTime createdAt
) {}
