package br.ufrpe.gestao_feira.exceptions;

import br.ufrpe.gestao_feira.classesbasicas.*;

public class ProdutoNaoAssociadoException extends RuntimeException {
    public ProdutoNaoAssociadoException (Produto produto, Produtor produtor) {
        super("O produto " + produto.getNome() + "Não pertence ao produtor " + produtor.getNome() + " de CPF:" + produtor.getCpfCnpj() );
    }
}
