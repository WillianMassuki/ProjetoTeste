package br.comvarejonline.projetoinicial.produto.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@Data
public class ProdutoDTO {

    private Long id;

    private String codigoBarras;

    private Integer quantidadeMinima;

    private String nome;

    private Double saldoInicial;
}
