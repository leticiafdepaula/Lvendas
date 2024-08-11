package com.lvendas.gestao_vendas.dto.produto;

import com.lvendas.gestao_vendas.entidade.Categoria;
import com.lvendas.gestao_vendas.entidade.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Getter
@Setter
@ApiModel("produto requesição DTO")
public class ProdutoRequestDTO {

    @ApiModelProperty(value = "descrição")
    @NotBlank(message = "Descrição")
    @Length(min = 3, max = 100, message = "descrição")
    private String descricao;
    @ApiModelProperty(value = "quantidade")
    @NotNull(message = "Quantidade")
    private Integer quantidade;
    @ApiModelProperty(value = "preço Custo")
    @NotNull(message = "Preco custo")
    private BigDecimal precoCusto;
    @ApiModelProperty(value = "preço Venda")
    @NotNull(message = "Preco venda")
    private BigDecimal precoVenda;
    @ApiModelProperty(value = "observação")
    @Length(max = 500, message = "observação")
    private String observacao;


    public Produto converterParaEntidade(Long codigoCategoria) {
        return new Produto (descricao, quantidade, precoCusto, precoVenda, observacao,
                new Categoria (codigoCategoria));
    }

    public @Valid ProdutoRequestDTO converterParaEntidade(Long codigoCategoria, Long codigoProduto ) {
        return new Produto (codigoProduto, descricao, quantidade, precoCusto, precoVenda, observacao,
                new Categoria (codigoCategoria));
    }

}
