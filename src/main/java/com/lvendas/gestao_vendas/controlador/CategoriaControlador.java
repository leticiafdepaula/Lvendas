package com.lvendas.gestao_vendas.controlador;

import com.lvendas.gestao_vendas.entidade.Categoria;
import com.lvendas.gestao_vendas.entidade.Produto;
import com.lvendas.gestao_vendas.servico.ProdutoServico;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
    @Autowired
    private ProdutoServico produtoServico;

    @GetMapping
    public List<Categoria> ListarTodas() {
        return categoriaServico.listarTodas ();
    }

    @ApiOperation (value = "listar por codigo", nickname = "buscarPorCodigo")
    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable Long codigo){
        Optional<Categoria> categoria = produtoServico.buscarPorCodigo (codigo);
        return categoria.isPresent () ? ResponseEntity.ok (categoria) : ResponseEntity.notFound ().build ();
    }
     @ApiOperation (value = "Salvar", nickname = "SalvarProduto")
     @PostMapping
     public ResponseEntity<Categoria> salvar(@Valid  @RequestBody Categoria categoria) {
        Categoria categoriaSalvar = produtoServico.salvar (categoria);
        return ResponseEntity.status (HttpStatus.CREATED).body (categoriaSalvar);
    }
    @ApiOperation (value = "Atualizar", nickname = "AtualizarProduto")
    @PostMapping("/{codigoProduto}")
    public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long codigoCategoria, @PathVariable Long codigoProduto, @Valid @RequestBody Produto produto) {
    return ResponseEntity.ok (produtoServico.Atualizar (codigoCategoria, codigoProduto,produto));
    }

    @ApiOperation (value = "deletar")
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long codigo) {
        produtoServico.deletar (codigo);

    }
}
