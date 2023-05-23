package br.comvarejonline.projetoinicial.estoque.vo;

import br.comvarejonline.projetoinicial.produto.enuns.MovimentacoesEnuns;
import br.comvarejonline.projetoinicial.produto.model.Produto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class EstoqueVO {

    private final Long codigoEstoque;

    private final MovimentacoesEnuns movimentacoesEnuns;

    private final String nomeProduto;

    private final Integer quantidade;

    private final LocalDateTime data;

    private final String motivo;

    private final String documento;
}
