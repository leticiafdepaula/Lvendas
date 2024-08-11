package com.lvendas.gestao_vendas.dto.produto;

import com.lvendas.gestao_vendas.dto.categoria.CategoriaResponseDto;
import com.lvendas.gestao_vendas.entidade.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ApiModel("Produto retorno DTO")
public class ProdutoResponseDTO {

    @ApiModelProperty(value = "Codigo")
    private Long codigo;
    @ApiModelProperty(value = "descrição")
    private String descricao;
    @ApiModelProperty(value = "quantidade")
    private Integer quantidade;
    @ApiModelProperty(value = "preço Custo")
    private BigDecimal precoCusto;
    @ApiModelProperty(value = "preço Venda")
    private BigDecimal precoVenda;
    @ApiModelProperty(value = "observação")
    private String observacao;
    @ApiModelProperty(value = "Categoria")
    private CategoriaResponseDto categoriaResponseDto;

    public ProdutoResponseDTO(Long codigo, String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda, String observacao, CategoriaResponseDto categoriaResponseDto) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.observacao = observacao;
        this.categoriaResponseDto = categoriaResponseDto;

    }

    public static ProdutoResponseDTO converterParaProdutoDTO(Produto produto) {
        return new ProdutoResponseDTO (produto.getCodigo (), produto.getDescricao (), produto.getQuantidade (),
                produto.getPrecoCusto (), produto.getPrecoVenda (), produto.getObservacao (), CategoriaResponseDto.converterParaCategoriaDto (produto.getCategoria ()));
    }


}

