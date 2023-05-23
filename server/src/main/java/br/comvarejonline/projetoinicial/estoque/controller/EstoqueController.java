package br.comvarejonline.projetoinicial.estoque.controller;

import br.comvarejonline.projetoinicial.estoque.dto.EstoqueDTO;
import br.comvarejonline.projetoinicial.estoque.service.EstoqueService;
import br.comvarejonline.projetoinicial.estoque.vo.EstoqueVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/estoque")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService estoqueService;

    @PreAuthorize("hasRole('GERENTE', 'OPERADOR)")
    @GetMapping(produces = "application/json")
    public List<EstoqueVO> listagemEstoque() {
        return this.estoqueService.listarEstoques();
    }

    @PreAuthorize("hasRole('GERENTE', 'OPERADOR)")
    @GetMapping("{codigoEstoque}")
    public ResponseEntity<EstoqueVO> detalharProdutoEstoque(@PathVariable Long codigoEstoque)
    {
        return  ResponseEntity.of(this.estoqueService.detalharProdutoEstoque(codigoEstoque));
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PostMapping(produces = "application/json")
    public ResponseEntity<Long> adicionarProdutoEstoque(
            @RequestBody EstoqueDTO estoqueDTO
    ) {
        return ResponseEntity.ok(this.estoqueService.salvarProdutoEstoque(estoqueDTO));
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PutMapping(value = "/{produtoId}", produces = "application/json")
    public ResponseEntity<Long> atualizarEstoque(
            @PathVariable Long estoqueId,
            @RequestBody EstoqueDTO estoqueDTO
    ) {
        return ResponseEntity.of(this.estoqueService.alterar(estoqueId, estoqueDTO));

    }

    @GetMapping(path = "/filtro")
    public ResponseEntity<Page<EstoqueVO>> filtroEstoque(
            @PageableDefault(size = 5, sort = "id") Pageable pageable, EstoqueVO estoqueVO) {
        return ResponseEntity.ok(this.estoqueService.getAllBy(pageable, estoqueVO));
    }

}
