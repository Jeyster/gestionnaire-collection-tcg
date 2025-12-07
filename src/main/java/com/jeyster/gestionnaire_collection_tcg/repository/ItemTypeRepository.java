package com.jeyster.gestionnaire_collection_tcg.repository;

import com.jeyster.gestionnaire_collection_tcg.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    List<ItemType> findDistinctByItems_Game_Id(Long id);
}
