package com.jeyster.gestionnaire_collection_tcg.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "expansion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expansion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
