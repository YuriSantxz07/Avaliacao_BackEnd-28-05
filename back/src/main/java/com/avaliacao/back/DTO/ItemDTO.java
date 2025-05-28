package com.avaliacao.back.DTO;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String nome;
    private int quantidade;
    private String tipoAco;
    private String especificacoes;
}
