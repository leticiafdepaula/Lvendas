package com.lvendas.gestao_vendas.servico;

import com.lvendas.gestao_vendas.entidade.Produto;
import com.lvendas.gestao_vendas.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public List<Produto> listarTodos(Long codigoCategoria) {
        return produtoRepositorio.findByCategoriaCodigo(codigoCategoria);
    }

    public Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria) {
        return produtoRepositorio.buscarPorCodigo(codigo, codigoCategoria);
    }

    public Produto salvar (Produto produto) {
        return produtoRepositorio.save (produto);

    }
}
