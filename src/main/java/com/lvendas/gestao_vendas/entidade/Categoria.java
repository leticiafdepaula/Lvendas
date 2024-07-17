package com.lvendas.gestao_vendas.entidade;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "nome")
    @NotBlank (message = "Nome")
    @Length(min = 3, max = 50, message = "Nome")
    private String nome;


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
