package com.jeyster.gestionnaire_collection_tcg.dto;

import jakarta.validation.constraints.NotNull;

public record ToggleCmScrapingDto(
        @NotNull Boolean isCmScrapingActive
) {}
