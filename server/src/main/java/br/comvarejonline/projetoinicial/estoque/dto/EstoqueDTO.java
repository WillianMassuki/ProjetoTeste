package br.comvarejonline.projetoinicial.estoque.dto;

import br.comvarejonline.projetoinicial.produto.enuns.MovimentacoesEnuns;
import br.comvarejonline.projetoinicial.produto.model.Produto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class EstoqueDTO {

    private Long codigoEstoque;

    private MovimentacoesEnuns movimentacoesEnuns;

    private Produto produto;

    private Integer quantidade;

    private LocalDateTime data;

    private String motivo;

    private String documento;
}
