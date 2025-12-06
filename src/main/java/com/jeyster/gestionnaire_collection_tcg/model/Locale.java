package com.jeyster.gestionnaire_collection_tcg.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "locale")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Locale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
