package com.jeyster.gestionnaire_collection_tcg.repository;

import com.jeyster.gestionnaire_collection_tcg.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
