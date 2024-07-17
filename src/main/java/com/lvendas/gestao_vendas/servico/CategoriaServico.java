package com.lvendas.gestao_vendas.servico;

import com.lvendas.gestao_vendas.entidade.Categoria;
import com.lvendas.gestao_vendas.repositorio.CategoriaRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServico {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> listarTodas() {
        return categoriaRepositorio.findAll ();
    }
    public Optional<Categoria> buscarPorCodigo(Long codigo){
        return categoriaRepositorio.findById (codigo);
    }

      public Categoria salvar(Categoria categoria){
        return categoriaRepositorio.save (categoria);
      }

      public Categoria atualizar(Long codigo, Categoria categoria) {
        Categoria categoriaSalvar = validarCategoriaExiste(codigo);
          BeanUtils.copyProperties (categoria, categoriaSalvar, "codigo");
          return categoriaRepositorio.save (categoriaSalvar);
      }

    private Categoria validarCategoriaExiste(Long codigo) {
        Optional<Categoria> categoria = buscarPorCodigo (codigo);
        if (categoria.isEmpty ()){
            throw new EmptyResultDataAccessException (1);
        }
    return categoria.get ();
    }

}
