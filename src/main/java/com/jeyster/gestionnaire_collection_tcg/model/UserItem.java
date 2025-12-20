package com.jeyster.gestionnaire_collection_tcg.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Double purchasePrice;

    private LocalDateTime purchaseDate;

    private String purchaseComment;

    private Double sellingPrice;

    private LocalDateTime sellingOrOpeningDate;

    private String sellingOrOpeningComment;

    public UserItem(
            User user,
            Item item,
            Double purchasePrice,
            LocalDateTime purchaseDate,
            String purchaseComment
    ) {
        this.user = user;
        this.item = item;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.purchaseComment = purchaseComment;
    }
}
