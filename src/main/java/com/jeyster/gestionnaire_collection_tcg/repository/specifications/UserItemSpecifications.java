package com.jeyster.gestionnaire_collection_tcg.repository.specifications;

import com.jeyster.gestionnaire_collection_tcg.model.UserItem;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class UserItemSpecifications {

    public static Specification<UserItem> withFilters(
            Long userId,
            Long itemId,
            boolean notSoldOrOpened
    ) {
        return Specification.where(userIdEquals(userId))
                .and(itemIdEquals(itemId))
                .and(userItemNotSoldOrOpened(notSoldOrOpened));
    }

    public static Specification<UserItem> withFilters(
            Long userId,
            Long itemId,
            boolean isSold,
            boolean isOpened
    ) {
        return Specification.where(userIdEquals(userId))
                .and(itemIdEquals(itemId))
                .and(isSold(isSold, isOpened))
                .and(isOpened(isOpened, isSold));
    }

    private static Specification<UserItem> userIdEquals(Long userId) {
        return (root, q, cb) ->
                userId == null ? null : cb.equal(root.get("user").get("id"), userId);
    }

    private static Specification<UserItem> itemIdEquals(Long itemId) {
        return (root, q, cb) ->
                itemId == null ? null : cb.equal(root.get("item").get("id"), itemId);
    }

    private static Specification<UserItem> isSold(boolean isSold, boolean isOpened) {
        return (root, q, cb) -> {
            if (isOpened) {
                return null;
            }
            return isSold ? cb.isNotNull(root.get("sellingPrice")) : cb.isNull(root.get("sellingPrice"));
        };
    }

    private static Specification<UserItem> isOpened(boolean isOpened, boolean isSold) {
        return (root, q, cb) -> {
            if (isSold) {
                return null;
            } else if (isOpened) {
                Predicate sellingPriceIsNull = cb.isNull(root.get("sellingPrice"));
                Predicate sellingOrOpeningDateIsNotNull = cb.isNotNull(root.get("sellingOrOpeningDate"));
                return cb.and(sellingPriceIsNull, sellingOrOpeningDateIsNotNull);
            } else {
                return cb.isNull(root.get("sellingOrOpeningDate"));
            }
        };
    }

    private static Specification<UserItem> userItemNotSoldOrOpened(boolean notSoldOrOpened) {
        return (root, q, cb) ->
                notSoldOrOpened ? cb.isNull(root.get("sellingOrOpeningDate")) : null;
    }

}
