package com.lvendas.gestao_vendas.servico;

import com.lvendas.gestao_vendas.dto.produto.ProdutoRequestDTO;
import com.lvendas.gestao_vendas.entidade.Categoria;
import com.lvendas.gestao_vendas.entidade.Produto;
import com.lvendas.gestao_vendas.excecao.RegraNegocioException;
import com.lvendas.gestao_vendas.repositorio.ProdutoRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;
import java.util.Optional;

public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private CategoriaServico categoriaServico;

    public List<Produto> listarTodos(Long codigoCategoria) {
        return produtoRepositorio.findByCategoriaCodigo(codigoCategoria);
    }

    public Optional<Produto> buscarPorCodigo(Long codigo) {
        return produtoRepositorio.buscarPorCodigo(codigo);
    }
    public Produto salvar (Categoria produto) {
        validarCategoriaDoProdutoExiste (produto.getCategoria ().getCodigo ());
        validarProdutoDuplicado (produto);
        return produtoRepositorio.save (produto);
    }
    public Produto Atualizar(Long codigoCategoria, Long codigoProduto, @Valid ProdutoRequestDTO produto) {
     Produto produtoSalvar = validarProdutoExiste(codigoProduto, codigoCategoria);
        validarProdutoDuplicado (produto.getCategoria ());
        validarCategoriaDoProdutoExiste (codigoCategoria);
        BeanUtils.copyProperties (produtoSalvar, produto, "codigo");
        return produtoRepositorio.save (produtoSalvar);
    }


    public void deletar(Long codigoCategoria, Long codigoDoProduto) {
        Produto produto = validarProdutoExiste (codigoDoProduto, codigoCategoria);
              produtoRepositorio.delete (produto);
    }

    private Produto validarProdutoExiste(Long codigoProduto, Long codigoCategoria) {
        Optional<Produto> produto = buscarPorCodigo (codigoProduto);
        if (produto.isEmpty ()) {
            throw new EmptyResultDataAccessException (1);
        }
    return produto.get ();
    }

    private void validarProdutoDuplicado(Categoria produto) {
        if (produtoRepositorio.findByCategoriaCodigoAndDescricao (produto.getCategoria().getCodigo (), produto.getDescricao ()).isPresent ()) {
            throw new RegraNegocioException(String.format ("O produto %s, já está cadastrado!", produto.getDescricao ()));
        }
    }
    private void validarCategoriaDoProdutoExiste(Long codigoCategoria) {
        if(codigoCategoria == null) {
            throw new RegraNegocioException ("A categoria não pode ser null");
        }
    if (categoriaServico.buscarPorCodigo (codigoCategoria).isEmpty ()) {
        throw new RegraNegocioException(String.format ("A categoria de codigo %s informada não existe no cadastro", codigoCategoria));
    }
    }


    public Produto salvar(Long codigoCategoria, Produto produto) {
    }
}
