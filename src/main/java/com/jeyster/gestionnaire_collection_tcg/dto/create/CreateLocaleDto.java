package com.jeyster.gestionnaire_collection_tcg.dto.create;

import jakarta.validation.constraints.NotNull;

public record CreateLocaleDto(
        @NotNull String name
) {}
