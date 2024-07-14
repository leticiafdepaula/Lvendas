package com.lvendas.gestao_vendas.repositorio;

import com.lvendas.gestao_vendas.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
