package com.jeyster.gestionnaire_collection_tcg.repository.specifications;

import com.jeyster.gestionnaire_collection_tcg.model.UserItem;
import org.springframework.data.jpa.domain.Specification;

public class UserItemSpecifications {

    public static Specification<UserItem> withFilters(
            Long userId,
            Long itemId
    ) {
        return Specification.where(userIdEquals(userId))
                .and(itemIdEquals(itemId));
    }

    private static Specification<UserItem> userIdEquals(Long userId) {
        return (root, q, cb) ->
                userId == null ? null : cb.equal(root.get("user").get("id"), userId);
    }

    private static Specification<UserItem> itemIdEquals(Long itemId) {
        return (root, q, cb) ->
                itemId == null ? null : cb.equal(root.get("item").get("id"), itemId);
    }

}
