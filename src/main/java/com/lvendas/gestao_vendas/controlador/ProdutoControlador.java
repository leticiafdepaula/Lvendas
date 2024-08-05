package com.lvendas.gestao_vendas.controlador;

import com.lvendas.gestao_vendas.entidade.Produto;
import com.lvendas.gestao_vendas.servico.ProdutoServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Api(tags = "Produto")
@RestController
@RequestMapping("/categoria{codigoCategoria}/produto")
public class ProdutoControlador {

    @Autowired
    private ProdutoServico produtoServico;

    @ApiOperation (value = "listar", nickname = "listarTodos")
    @GetMapping
    public List<Produto> listarTodos(@PathVariable Long codigoCategoria) {
        return produtoServico.listarTodos(codigoCategoria);
    }

    @ApiOperation (value = "listar por codigo", nickname = "buscarPorCodigo")
    @GetMapping
    public ResponseEntity<Optional<ProdutoServico>> buscarPorCodigo(@PathVariable Long codigoCategoria,
            @PathVariable Long codigo) {
        Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo, codigoCategoria);
        return produto.isPresent () ? (ResponseEntity<Optional<ProdutoServico>>) ResponseEntity.ok () : ResponseEntity.notFound ().build ();
    }

      @PostMapping
       public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto produto){
        Produto ProdutoSalvo = produtoServico.salvar (produto);
        return ResponseEntity.status (HttpStatus.CREATED).body(produto);

    }

}
