package com.lvendas.gestao_vendas.controlador;

import com.lvendas.gestao_vendas.dto.CategoriaRequestDTO;
import com.lvendas.gestao_vendas.dto.CategoriaResponseDto;
import com.lvendas.gestao_vendas.entidade.Categoria;
import com.lvendas.gestao_vendas.entidade.Produto;
import com.lvendas.gestao_vendas.servico.CategoriaServico;
import com.lvendas.gestao_vendas.servico.ProdutoServico;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
    @Autowired
    private ProdutoServico produtoServico;
    private CategoriaServico categoriaServico;

    @GetMapping
    public List<CategoriaResponseDto> ListarTodas() {
        return categoriaServico.listarTodas ().stream ().map (categoria -> CategoriaResponseDto.
                converterParaCategoriaDto (categoria)).collect(Collectors.toList());
    }

    @ApiOperation(value = "listar por codigo", nickname = "buscarPorCodigo")
    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<CategoriaResponseDto>> buscarPorId(@PathVariable Long codigo) {
        Optional<Produto> categoria = produtoServico.buscarPorCodigo (codigo);
        return categoria.isPresent () ? ResponseEntity.ok (Optional.of (CategoriaResponseDto.converterParaCategoriaDto (categoria.get ().getCategoria ()))) : ResponseEntity.notFound ().build ();
    }

    @ApiOperation(value = "Salvar", nickname = "SalvarProduto")
    @PostMapping
    public ResponseEntity<CategoriaResponseDto> salvar(@Valid @RequestBody CategoriaRequestDTO categoriaDto) {
       Categoria categoriaSalva = categoriaServico.salvar (categoriaDto.converterParaEntidade ());
        return ResponseEntity.status (HttpStatus.CREATED).body (CategoriaResponseDto.
                converterParaCategoriaDto (categoriaSalva));
    }

    @ApiOperation(value = "Atualizar", nickname = "AtualizarCategoria")
    @PutMapping("/{codigo}")
    public ResponseEntity<Categoria> atualizar( @PathVariable Long codigo, @Valid @RequestBody CategoriaRequestDTO categoriaDTO) {
        return ResponseEntity.ok (categoriaServico.atualizar (codigo, categoriaDTO.converterParaEntidade (codigo)));
    }

    @ApiOperation(value = "Deletar", nickname = "DeletarCategoria")
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long codigo) {
        categoriaServico.deletar (codigo);
    }
}
