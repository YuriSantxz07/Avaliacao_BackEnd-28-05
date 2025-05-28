package com.avaliacao.back.Service;

import com.avaliacao.back.DTO.ClienteDTO;
import com.avaliacao.back.Entity.Cliente;
import com.avaliacao.back.Entity.Pedido;
import com.avaliacao.back.Repository.ClienteRepository;
import com.avaliacao.back.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;



    public ResponseEntity<?> salvarPaciente(ClienteDTO clienteDTO) {
        Cliente cliente = toEntity(clienteDTO);
        clienteRepository.save(cliente);
        return new ResponseEntity<>(toClienteDTO(cliente), HttpStatus.CREATED);
}

    public ResponseEntity<List<ClienteDTO>> listarCliente() {
        List<ClienteDTO> clientes = clienteRepository.findAll()
                .stream()
                .map(cliente -> toClienteDTO(cliente))
                .collect(Collectors.toList());
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    public ResponseEntity<ClienteDTO> atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Cliente cliente = clienteOpt.get();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setContato(clienteDTO.getContato());

        clienteRepository.save(cliente);
        return new ResponseEntity<>(toClienteDTO(cliente), HttpStatus.OK);
    }

    public ResponseEntity<Void> deletarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private ClienteDTO toClienteDTO(Cliente cliente) {
        List<Pedido> pedidos = cliente.getPedidos();

        if(pedidos == null){
            return new ClienteDTO(
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getEndereco(),
                    cliente.getContato(),
                    null
            );
        }

        List<Long> pedidoIds = pedidos.stream()
                .map(Pedido::getId)
                .collect(Collectors.toList());

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getContato(),
                pedidoIds
        );

    }
    private Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEndereco(dto.getEndereco());
        return cliente;
    }

    public Optional<ClienteDTO> buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(this::toClienteDTO);
    }

    public Optional<ClienteDTO> buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome)
                .map(this::toClienteDTO);
    }
}
