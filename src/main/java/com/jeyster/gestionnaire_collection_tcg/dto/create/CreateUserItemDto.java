package com.jeyster.gestionnaire_collection_tcg.dto.create;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateUserItemDto(
        @NotNull Long userId,
        @NotNull Long itemId,
        @NotNull Double purchasePrice,
        @NotNull LocalDateTime purchaseDate,
        String purchaseComment
) {}
