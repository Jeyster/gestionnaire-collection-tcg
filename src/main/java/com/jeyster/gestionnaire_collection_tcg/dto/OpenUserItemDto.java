package com.jeyster.gestionnaire_collection_tcg.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OpenUserItemDto(
        @NotNull LocalDateTime openingDate,
        String openingComment
) {}
