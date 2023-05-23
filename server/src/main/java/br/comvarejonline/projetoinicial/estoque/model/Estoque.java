package br.comvarejonline.projetoinicial.estoque.model;

import br.comvarejonline.projetoinicial.produto.enuns.MovimentacoesEnuns;
import br.comvarejonline.projetoinicial.produto.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.file.LinkOption;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoEstoque;

    @Enumerated(EnumType.STRING)
    private MovimentacoesEnuns movimentacoesEnuns;

    @OneToOne
    @JoinColumn
    private Produto produto;

    @Column
    private Integer quantidade;

    @Column
    private LocalDateTime data;

    @Column
    private String motivo;

    @Column
    private String documento;


}
