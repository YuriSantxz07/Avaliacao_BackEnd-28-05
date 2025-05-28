package com.avaliacao.back.Service;

import com.avaliacao.back.DTO.PedidoDTO;
import com.avaliacao.back.Entity.Cliente;
import com.avaliacao.back.Entity.Item;
import com.avaliacao.back.Entity.Pedido;
import com.avaliacao.back.Repository.ClienteRepository;
import com.avaliacao.back.Repository.ItemRepository;
import com.avaliacao.back.Repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItemRepository itemRepository;

    private PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setStatus(pedido.getStatus());
        dto.setData(pedido.getData());
//        dto.setIdClientes(pedido.getCliente().getId());
//        dto.setIdItens(pedido.getItemComprado().getId());
        return dto;
    }

//    private Pedido toEntity(PedidoDTO dto) {
//        Pedido pedido = new Pedido();
//        pedido.setId(dto.getId());
//        pedido.setStatus(dto.getStatus());
//        pedido.setData(dto.getData());
////        pedido.setCliente(clienteRepository.findById(dto.getIdClientes())
////                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado")));
////        pedido.setItemComprado(itemRepository.findById(dto.getIdItens())
////                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado")));
////        return pedido;
//    }

//    @Transactional
//    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
//
//        //Pedido pedido = toEntity(pedidoDTO);
//        //Pedido novaConsulta = pedidoRepository.save(pedido);
//
////        cliente.getPedidos().add(novaConsulta);
////
////        clienteRepository.save(cliente);
////        itemRepository.save(item);
//
//        return toDTO(novaConsulta);
//    }
}
