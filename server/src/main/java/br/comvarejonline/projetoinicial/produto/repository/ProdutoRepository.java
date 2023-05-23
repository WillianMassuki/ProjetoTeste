package br.comvarejonline.projetoinicial.produto.repository;

import br.comvarejonline.projetoinicial.produto.model.Produto;
import br.comvarejonline.projetoinicial.produto.vo.ProdutoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(" SELECT " +
            " new br.comvarejonline.projetoinicial.produto.vo.ProdutoVO( " +
            " produto.id," +
            " produto.codigoBarras," +
            " produto.quantidadeMinima," +
            " produto.nome," +
            " produto.saldoInicial " +
            ")" +
            " FROM " +
            " Produto produto "
    )
    List<ProdutoVO> findAllProducts();


    @Query(" SELECT " +
            " new br.comvarejonline.projetoinicial.produto.vo.ProdutoVO( " +
            " produto.id," +
            " produto.codigoBarras," +
            " produto.quantidadeMinima," +
            " produto.nome," +
            " produto.saldoInicial " +
            ")" +
            " FROM " +
            " Produto produto " +
            " WHEN " +
            " produto.id =: idProduto "
    )
    Optional<ProdutoVO> findByOneProduto(@Param("idProduto") Long idProduto);
}
