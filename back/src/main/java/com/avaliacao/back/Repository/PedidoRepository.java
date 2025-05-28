package com.avaliacao.back.Repository;

import com.avaliacao.back.Entity.Cliente;
import com.avaliacao.back.Entity.Item;
import com.avaliacao.back.Entity.Pedido;
import com.avaliacao.back.Service.PedidoService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByData(LocalDate data);

    List<Pedido> findByCliente(Cliente cliente);

    List<Pedido> findByItem(Item item);

    List<Pedido> findByStatus(String status);
}
