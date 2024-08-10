package com.lvendas.gestao_vendas.dto;

import com.lvendas.gestao_vendas.entidade.Categoria;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CategoriaRequestDTO {


    @NotBlank(message = "Nome")
    @Length(min = 3, max = 50, message = "Nome")
    private String nome;


    public Categoria converterParaEntidade() {

        return new Categoria (nome);
    }

    public Categoria converterParaEntidade(Long codigo) {

        return new Categoria (codigo, nome);
    }

}
