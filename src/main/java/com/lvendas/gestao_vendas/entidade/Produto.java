package com.lvendas.gestao_vendas.entidade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco_custo")
    private BigDecimal precoCusto;
    @Column(name = "preco_venda")
    private BigDecimal precoVenda;
    @Column(name = "observacao")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    private Categoria categoria;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return Objects.equals (getCodigo (), produto.getCodigo ()) && Objects.equals (getDescricao (),
                produto.getDescricao ()) && Objects.equals (getQuantidade (), produto.getQuantidade ())
                && Objects.equals (getPrecoCusto (), produto.getPrecoCusto ())
                && Objects.equals (getPrecoVenda (), produto.getPrecoVenda ())
                && Objects.equals (getObservacao (), produto.getObservacao ())
                && Objects.equals (getCategoria (), produto.getCategoria ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getCodigo (), getDescricao (), getQuantidade (), getPrecoCusto (),
                getPrecoVenda (), getObservacao (), getCategoria ());
    }
}
