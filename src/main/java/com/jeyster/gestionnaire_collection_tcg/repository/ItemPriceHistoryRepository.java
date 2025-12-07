package com.jeyster.gestionnaire_collection_tcg.repository;

import com.jeyster.gestionnaire_collection_tcg.model.ItemPriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPriceHistoryRepository extends JpaRepository<ItemPriceHistory, Long> {
    List<ItemPriceHistory> findAllByItemId(Long itemId);
}
