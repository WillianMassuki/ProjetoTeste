package br.comvarejonline.projetoinicial.produto.controller;

import br.comvarejonline.projetoinicial.produto.dto.ProdutoDTO;
import br.comvarejonline.projetoinicial.produto.service.ProdutoService;
import br.comvarejonline.projetoinicial.produto.vo.ProdutoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PreAuthorize("hasRole('GERENTE', 'OPERADOR')")

    @GetMapping(produces = "application/json")
    public List<ProdutoVO> listagemEstoque() {
        return this.produtoService.listarTodosProdutos();
    }

    @PreAuthorize("hasRole('GERENTE', 'OPERADOR)")
    @GetMapping("{idProduto}")
    public ResponseEntity<ProdutoVO> detalhar(@PathVariable Long idProduto)
    {
        return  ResponseEntity.of(this.produtoService.detalharProduto(idProduto));
    }

    @PreAuthorize("hasRole('GERENTE', 'OPERADOR')")
    @PostMapping(produces = "application/json")
    public ResponseEntity<Long> adicionarProduto(
            @RequestBody ProdutoDTO produtoDTO
    ) {
        return ResponseEntity.ok(this.produtoService.salvarProduto(produtoDTO));
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PutMapping(value = "/{produtoId}", produces = "application/json")
    public ResponseEntity<Long> atualizaProduto(
            @PathVariable Long produtoId,
             @RequestBody ProdutoDTO produtoDTO
    ) {
        return ResponseEntity.of(this.produtoService.alterar(produtoId, produtoDTO));

    }


}
