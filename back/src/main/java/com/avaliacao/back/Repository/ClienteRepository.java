package com.avaliacao.back.Repository;

import com.avaliacao.back.DTO.ClienteDTO;
import com.avaliacao.back.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome);
    Optional <Cliente> findByIdCliente(Long id);

}
