package com.treinos.Treinos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treino")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private int repeticoes;

    @Column(nullable = false)
    private int series;

    @Column(nullable = false, length = 100)
    private String musculoa_alvo;
}
