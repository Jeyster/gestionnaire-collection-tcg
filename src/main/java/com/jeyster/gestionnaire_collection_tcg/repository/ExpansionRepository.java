package com.jeyster.gestionnaire_collection_tcg.repository;

import com.jeyster.gestionnaire_collection_tcg.model.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpansionRepository extends JpaRepository<Expansion, Long> {

    List<Expansion> findAllByOrderByName();

    List<Expansion> findAllByGameIdOrderByName(Long id);

}
