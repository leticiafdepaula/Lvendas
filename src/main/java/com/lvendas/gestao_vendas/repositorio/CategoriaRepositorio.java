package com.lvendas.gestao_vendas.repositorio;

import com.lvendas.gestao_vendas.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    Categoria findByNome(String nome);
}
