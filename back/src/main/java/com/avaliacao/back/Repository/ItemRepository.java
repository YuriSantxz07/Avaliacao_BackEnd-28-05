package com.avaliacao.back.Repository;

import com.avaliacao.back.Entity.Cliente;
import com.avaliacao.back.Entity.Estoque;
import com.avaliacao.back.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByMaterial(String tipoAco);
    Optional<Item> findByItem(String nome);
}
