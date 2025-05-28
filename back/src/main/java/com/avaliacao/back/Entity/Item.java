package com.avaliacao.back.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quantidade;
    private String tipoAco;
    private String especificacoes;

    @ManyToOne
    private Estoque estoque;
}
