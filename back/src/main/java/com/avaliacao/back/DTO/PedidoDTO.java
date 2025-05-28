package com.avaliacao.back.DTO;

import com.avaliacao.back.Entity.Cliente;
import com.avaliacao.back.Entity.Item;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;
    private LocalDateTime data;
    private String status;

    private List<Cliente> idClientes;
    private List<Item> idItens;
}
