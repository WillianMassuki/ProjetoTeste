package br.comvarejonline.projetoinicial.produto.factory;

import br.comvarejonline.projetoinicial.produto.dto.ProdutoDTO;
import br.comvarejonline.projetoinicial.produto.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoFactory {

    public Produto createFactoryProduto(ProdutoDTO produtoDTO)
    {
        return Produto.builder()
                .codigoBarras(produtoDTO.getCodigoBarras())
                .quantidadeMinima(produtoDTO.getQuantidadeMinima())
                .saldoInicial(produtoDTO.getSaldoInicial())
                .nome(produtoDTO.getNome())
                .build();
    }
}
