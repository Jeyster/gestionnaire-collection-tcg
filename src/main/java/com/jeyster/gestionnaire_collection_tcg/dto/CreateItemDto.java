package com.jeyster.gestionnaire_collection_tcg.dto;

import jakarta.validation.constraints.NotNull;

public record CreateItemDto(
        @NotNull String url,
        @NotNull Long gameId,
        @NotNull Long itemTypeId,
        @NotNull Long localeId,
        @NotNull Long expansionId,
        String complement
) {}
