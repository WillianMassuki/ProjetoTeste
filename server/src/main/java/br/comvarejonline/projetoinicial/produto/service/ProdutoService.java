package br.comvarejonline.projetoinicial.produto.service;

import br.comvarejonline.projetoinicial.produto.dto.ProdutoDTO;
import br.comvarejonline.projetoinicial.produto.exception.ProdutoException;
import br.comvarejonline.projetoinicial.produto.factory.ProdutoFactory;
import br.comvarejonline.projetoinicial.produto.model.Produto;
import br.comvarejonline.projetoinicial.produto.repository.ProdutoRepository;
import br.comvarejonline.projetoinicial.produto.vo.ProdutoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final ProdutoFactory produtoFactory;

    public List<ProdutoVO> listarTodosProdutos() {
        return this.produtoRepository.findAllProducts();
    }

    public Optional<ProdutoVO> detalharProduto(Long idProduto) {
        return this.produtoRepository.findByOneProduto(idProduto);
    }

    public Long salvarProduto(ProdutoDTO produtoDTO) {

        this.produtoRepository.findById(
                produtoDTO.getId()
        ).ifPresent(idOperador -> {
                    throw new ProdutoException(produtoDTO.getId());
                }
        );

        return this.produtoRepository.save(
                this.produtoFactory.createFactoryProduto(produtoDTO)
        ).getId();
    }

    public Optional<Long> alterar(Long id, ProdutoDTO produtoDTO)
    {
        return this.produtoRepository.findById(id)
                .map(produto ->
                        produto.toBuilder()
                                .nomeProduto(produtoDTO.getCodigoBarras())
                                .codigoBarras(produtoDTO.getCodigoBarras())
                                .quantidadeMinima(produtoDTO.getQuantidadeMinima())
                                .saldoInicial(produtoDTO.getSaldoInicial())
                                .build()
                ).map(this.produtoRepository::save)
                .map(Produto::getId);


    }



}
