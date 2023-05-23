package br.comvarejonline.projetoinicial.estoque.repository;

import br.comvarejonline.projetoinicial.estoque.model.Estoque;
import br.comvarejonline.projetoinicial.estoque.vo.EstoqueVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query(" SELECT " +
            " new br.comvarejonline.projetoinicial.estoque.vo.EstoqueVO(" +
            " estoque.codigoEstoque, " +
            " estoque.movimentacoesEnuns, " +
            " produto.nomeProduto, " +
            " estoque.saldoInicial" +
            ")" +
            " FROM " +
            " Estoque estoque" +
            " JOIN " +
            " estoque.produto produto "
    )
    List<EstoqueVO> findByAll();


    @Query(" SELECT " +
            " new br.comvarejonline.projetoinicial.estoque.vo.EstoqueVO(" +
            " estoque.codigoEstoque, " +
            " estoque.movimentacoesEnuns, " +
            " produto.nomeProduto, " +
            " estoque.saldoInicial" +
            ")" +
            " FROM " +
            " Estoque estoque" +
            " JOIN " +
            " estoque.produto produto " +
            " WHEN " +
            " estoque.codigoEstoque =:codigoEstoque "
    )
    Optional<EstoqueVO> findByOne(@Param("codigoEstoque") Long codigoEstoque);


    /*
        @Query(
            " SELECT " +
                    "  new br.gov.sp.prodesp.saa.programas.domain.ProgramaVO( " +
                    "   programa.id, " +
                    "   programa.codigoPrograma, " +
                    "   programa.descricao, " +
                    "   programa.ativo, " +
                    "   programa.cda " +
                    "  ) " +
                    " FROM " +
                    "  Programa programa " +
                    " WHERE " +
                    "  programa.cda = FALSE " +
                    " AND " +
                    "  ( :codigoPrograma IS NULL OR programa.codigoPrograma = :codigoPrograma ) " +
                    " AND " +
                    "  ( :descricao IS NULL OR programa.descricao LIKE CONCAT(:descricao, '%') ) "
    )
    Page<ProgramaVO> findAllBy(
            Pageable pageable,
            @Param("codigoPrograma") Long codigoPrograma,
            @Param("descricao") String descricao
    );
     */

    @Query(" SELECT " +
            " new br.comvarejonline.projetoinicial.estoque.vo.EstoqueVO(" +
            " estoque.codigoEstoque, " +
            " estoque.movimentacoesEnuns, " +
            " produto.nomeProduto, " +
            " estoque.saldoInicial" +
            ")" +
            " FROM " +
            " Estoque estoque" +
            " JOIN " +
            " estoque.produto produto " +
            " WHEN " +
            " estoque.codigoEstoque =:codigoEstoque " +
            "  ( :nomeProduto IS NULL OR estoque.nomeProduto LIKE CONCAT(:nomeProduto, '%') " +
            " AND " +
            "  ( :descricao IS NULL OR programa.descricao LIKE CONCAT(:descricao, '%') ) "
    )
    Page<EstoqueVO> findAllBy(
            Pageable pageable,
            @Param("nomeProduto") String nomeProduto,
            @Param("Período")LocalDateTime data
            );
}
