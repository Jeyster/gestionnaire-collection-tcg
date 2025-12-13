package com.jeyster.gestionnaire_collection_tcg.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateUserItemDto(
        @NotNull Long userId,
        @NotNull Long itemId,
        Double purchasePrice,
        LocalDateTime purchaseDate,
        String comment
) {}
