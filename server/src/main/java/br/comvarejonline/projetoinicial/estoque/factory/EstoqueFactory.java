package br.comvarejonline.projetoinicial.estoque.factory;

import br.comvarejonline.projetoinicial.estoque.dto.EstoqueDTO;
import br.comvarejonline.projetoinicial.estoque.model.Estoque;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class EstoqueFactory {

    public Estoque createEstoqueFactory(EstoqueDTO estoqueDTO)
    {
        return  Estoque.builder()
                .codigoEstoque(estoqueDTO.getCodigoEstoque())
                .movimentacoesEnuns(estoqueDTO.getMovimentacoesEnuns())
                .produto(estoqueDTO.getProduto())
                .quantidade(estoqueDTO.getQuantidade())
                .data(estoqueDTO.getData())
                .motivo(estoqueDTO.getMotivo())
                .documento(estoqueDTO.getDocumento())
                .build();
    }
}
