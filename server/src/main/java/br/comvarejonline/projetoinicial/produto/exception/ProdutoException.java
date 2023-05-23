package br.comvarejonline.projetoinicial.produto.exception;

public class ProdutoException extends RuntimeException{

    public ProdutoException(Long codigoProduto) {
        System.out.println(" O produto já está cadastrado em nosso sistema, por favor inserir outro." + codigoProduto);
    }
}
