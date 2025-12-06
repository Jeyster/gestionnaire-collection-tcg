package com.jeyster.gestionnaire_collection_tcg.repository;

import com.jeyster.gestionnaire_collection_tcg.model.Locale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocaleRepository extends JpaRepository<Locale, Long> {
}
