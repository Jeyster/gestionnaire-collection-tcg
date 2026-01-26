package com.jeyster.gestionnaire_collection_tcg.dto.create;

import jakarta.validation.constraints.NotNull;

public record CreateGameDto(
        @NotNull String name
) {}
