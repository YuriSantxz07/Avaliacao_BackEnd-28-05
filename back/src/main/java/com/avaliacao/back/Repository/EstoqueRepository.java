package com.avaliacao.back.Repository;

import com.avaliacao.back.Entity.Cliente;
import com.avaliacao.back.Entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
