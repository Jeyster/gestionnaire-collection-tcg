package com.jeyster.gestionnaire_collection_tcg.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "item_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "itemType")
    List<Item> items;

}
