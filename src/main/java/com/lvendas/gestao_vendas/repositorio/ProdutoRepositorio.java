package com.lvendas.gestao_vendas.repositorio;

import com.lvendas.gestao_vendas.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

   List<Produto> findByCategoriaCodigo(Long codigoCategoria);

   @Query ("Select prod"
   + "from produto prod"
   + "where prod.codigo = :codigo"
   + "and prod.categoria.codigo = :codigoCategoria")
    Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria);

    Optional<Produto> findByCategoriaCodigoAndDescricao(Long codigo, String descricao);

}
