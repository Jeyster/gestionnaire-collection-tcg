package com.jeyster.gestionnaire_collection_tcg.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EditUserItemDto(
        @NotNull Double purchasePrice,
        @NotNull LocalDateTime purchaseDate,
        String purchaseComment
) {}
