package br.comvarejonline.projetoinicial.estoque.service;

import br.comvarejonline.projetoinicial.estoque.dto.EstoqueDTO;
import br.comvarejonline.projetoinicial.estoque.exception.EstoqueJaCadastrado;
import br.comvarejonline.projetoinicial.estoque.factory.EstoqueFactory;
import br.comvarejonline.projetoinicial.estoque.model.Estoque;
import br.comvarejonline.projetoinicial.estoque.repository.EstoqueRepository;
import br.comvarejonline.projetoinicial.estoque.vo.EstoqueVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    private final EstoqueFactory estoqueFactory;

    public List<EstoqueVO> listarEstoques() {
        return this.estoqueRepository.findByAll();
    }

    public Optional<EstoqueVO> detalharProdutoEstoque(Long codigoEstoque) {
        return this.estoqueRepository.findByOne(codigoEstoque);
    }

    public Long salvarProdutoEstoque(EstoqueDTO estoqueDTO) {

        this.estoqueRepository.findById(
              estoqueDTO.getCodigoEstoque()
        ).ifPresent(idOperador -> {
                    throw new EstoqueJaCadastrado(estoqueDTO.getCodigoEstoque());
                }
        );

        return this.estoqueRepository.save(
                this.estoqueFactory.createEstoqueFactory(estoqueDTO)
        ).getCodigoEstoque();
    }

    public Optional<Long> alterar(Long id, EstoqueDTO estoqueDTO)
    {
        return this.estoqueRepository.findById(id)
                .map(estoque ->
                        estoque.toBuilder()
                                .produto(estoqueDTO.getProduto())
                                .data(estoqueDTO.getData())
                                .motivo(estoqueDTO.getMotivo())
                                .documento(estoqueDTO.getDocumento())
                                .movimentacoesEnuns(estoqueDTO.getMovimentacoesEnuns())
                                .quantidade(estoqueDTO.getQuantidade())
                                .build()
                ).map(this.estoqueRepository::save)
                .map(Estoque::getCodigoEstoque);


    }

    public Page<EstoqueVO> getAllBy(Pageable pageable, EstoqueVO estoqueVO) {
        return this.estoqueRepository.findAllBy(
                pageable,
                estoqueVO.getNomeProduto(),
                estoqueVO.getData()
        );
    }

}
