package com.lvendas.gestao_vendas.servico;

import com.lvendas.gestao_vendas.entidade.Categoria;
import com.lvendas.gestao_vendas.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServico {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> listarTodas() {
        return categoriaRepositorio.findAll ();
    }
    public Optional<Categoria> buscarPorId(Long codigo){
        return categoriaRepositorio.findById (codigo);
    }
}
