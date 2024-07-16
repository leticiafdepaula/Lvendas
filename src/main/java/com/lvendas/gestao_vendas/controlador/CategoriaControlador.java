package com.lvendas.gestao_vendas.controlador;

import com.lvendas.gestao_vendas.entidade.Categoria;
import com.lvendas.gestao_vendas.servico.CategoriaServico;
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
    private CategoriaServico categoriaServico;

    @GetMapping
    public List<Categoria> ListarTodas() {
        return categoriaServico.listarTodas ();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable Long codigo){
        Optional<Categoria> categoria = categoriaServico.buscarPorCodigo (codigo);
        return categoria.isPresent () ? ResponseEntity.ok (categoria) : ResponseEntity.notFound ().build ();
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        Categoria categoriaSalvar = categoriaServico.salvar (categoria);
        return ResponseEntity.status (HttpStatus.CREATED).body (categoriaSalvar);
    }

    @PostMapping("/{codigo}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @RequestBody Categoria categoria) {
         return ResponseEntity.ok (categoriaServico.atualizar (codigo, categoria));
    }
}
