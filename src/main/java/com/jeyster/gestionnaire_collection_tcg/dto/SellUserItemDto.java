package com.jeyster.gestionnaire_collection_tcg.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SellUserItemDto(
        @NotNull Double sellingPrice,
        @NotNull LocalDateTime sellingDate,
        String sellingComment
) {}
