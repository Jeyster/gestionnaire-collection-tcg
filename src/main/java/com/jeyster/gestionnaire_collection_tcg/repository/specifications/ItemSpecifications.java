package com.jeyster.gestionnaire_collection_tcg.repository.specifications;

import com.jeyster.gestionnaire_collection_tcg.model.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecifications {

    public static Specification<Item> withFilters(
            Long gameId,
            Long itemTypeId,
            Long localeId,
            Long expansionId
    ) {
        return Specification.where(gameIdEquals(gameId))
                .and(itemTypeIdEquals(itemTypeId))
                .and(localeIdEquals(localeId))
                .and(expansionIdEquals(expansionId));
    }

    private static Specification<Item> gameIdEquals(Long gameId) {
        return (root, q, cb) ->
                gameId == null ? null : cb.equal(root.get("game").get("id"), gameId);
    }

    private static Specification<Item> itemTypeIdEquals(Long itemTypeId) {
        return (root, q, cb) ->
                itemTypeId == null ? null : cb.equal(root.get("itemType").get("id"), itemTypeId);
    }

    private static Specification<Item> localeIdEquals(Long localeId) {
        return (root, q, cb) ->
                localeId == null ? null : cb.equal(root.get("locale").get("id"), localeId);
    }

    private static Specification<Item> expansionIdEquals(Long expansionId) {
        return (root, q, cb) ->
                expansionId == null ? null : cb.equal(root.get("expansion").get("id"), expansionId);
    }

}
