package com.lvendas.gestao_vendas.dto;

import com.lvendas.gestao_vendas.entidade.Categoria;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel("Categoria Retorno Dto")
public class CategoriaResponseDto {

    @ApiModelProperty(value = "codigo")
    private Long codigo;

    @ApiModelProperty(value = "nome")
    private String nome;


   public CategoriaResponseDto(Long codigo, String nome) {
       this.codigo = codigo;
       this.nome = nome;
   }

   public static CategoriaResponseDto converterParaCategoriaDto(Categoria categoria) {
       return new CategoriaResponseDto (categoria.getCodigo (), categoria.getNome ());
   }

   public Long getCodigo() {
       return codigo;
   }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

