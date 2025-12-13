package com.jeyster.gestionnaire_collection_tcg.dto;

import java.time.LocalDateTime;

public record UserItemDto(
        Long id,
        UserDto user,
        ItemDto item,
        Double purchasePrice,
        LocalDateTime purchaseDate,
        Double sellingPrice,
        LocalDateTime sellingOrOpeningDate,
        String comment
) {}
