package com.lvendas.gestao_vendas.entidade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@ApiModel("Categoria requisição DTO")
@Entity
@Table(name = "categoria")
public class Categoria {

    @ApiModelProperty(value = "Nome")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nome")
    private String nome;

    public Categoria(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public Categoria( ) {
    }

    public Categoria(String nome) {
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria categoria)) return false;
        return Objects.equals (getCodigo (), categoria.getCodigo ()) && Objects.equals (getNome (), categoria.getNome ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getCodigo (), getNome ());
    }
}
