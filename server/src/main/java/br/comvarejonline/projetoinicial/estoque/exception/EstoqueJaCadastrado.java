package br.comvarejonline.projetoinicial.estoque.exception;

public class EstoqueJaCadastrado extends RuntimeException{

    public EstoqueJaCadastrado(Long codigo) {
        System.out.println(" O Produto já está cadastrado no estoque " + codigo);
    }
}
