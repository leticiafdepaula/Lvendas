package com.lvendas.gestao_vendas.controlador;

import com.lvendas.gestao_vendas.dto.produto.ProdutoResponseDTO;
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
import java.util.stream.Collectors;

@Api(tags = "Produto")
@RestController
@RequestMapping("/categoria{codigoCategoria}/produto")
public class ProdutoControlador {

    @Autowired
    private ProdutoServico produtoServico;


    @ApiOperation(value = "listar", nickname = "listarTodos")
    @GetMapping
    public List<ProdutoResponseDTO> listarTodos(@PathVariable Long codigoCategoria) {
        return produtoServico.listarTodos (codigoCategoria).stream ().map (produto -> ProdutoResponseDTO
                .converterParaProdutoDTO (produto)).collect (Collectors.toList ());
    }

    @ApiOperation(value = "listar por codigo", nickname = "buscarPorCodigo")
    @GetMapping
    public ResponseEntity<ProdutoResponseDTO> buscarPorCodigo(@PathVariable Long codigoCategoria, @PathVariable Long codigo) {
          Optional<Produto> produto = produtoServico.buscarPorCodigo (codigo);
          return produto.isPresent () ? ResponseEntity.ok (ProdutoResponseDTO.
          converterParaProdutoDTO (produto.get ())) : ResponseEntity.notFound ().build ();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto produto) {
        Produto ProdutoSalvo = produtoServico.salvar (produto.getCategoria ());
        return ResponseEntity.status (HttpStatus.CREATED).body (produto);

    }

    @ApiOperation(value = "deletar", nickname = "deletarProduto")
    @DeleteMapping("/{codigoProduto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long codigoCategoria, @PathVariable Long codigoProduto) {
        produtoServico.deletar (codigoProduto, codigoCategoria);
    }
}
