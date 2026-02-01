package com.jeyster.gestionnaire_collection_tcg.repository;

import com.jeyster.gestionnaire_collection_tcg.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByName(String name);

    List<Game> findAllByOrderByName();

}
