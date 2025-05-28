package com.avaliacao.back.DTO;

import com.avaliacao.back.Entity.Item;
import lombok.Data;

import java.util.List;

@Data
public class EstoqueDTO {
    private Long id;
    private List<Item> id_itens;
}
