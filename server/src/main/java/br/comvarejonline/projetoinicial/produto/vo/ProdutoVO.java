package br.comvarejonline.projetoinicial.produto.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ProdutoVO {

    private final Long id;

    private final String codigoBarras;

    private final Integer quantidadeMinima;

    private final String nome;

    private final Double saldoInicial;
}
