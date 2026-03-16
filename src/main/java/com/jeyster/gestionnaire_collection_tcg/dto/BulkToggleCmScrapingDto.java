package com.jeyster.gestionnaire_collection_tcg.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BulkToggleCmScrapingDto(
        @NotNull boolean isCmScrapingActive,
        List<Long> itemIds
) {}
