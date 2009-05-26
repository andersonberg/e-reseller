package produto.exceptions;

public class ProdutoInexistenteException extends Exception {

    public ProdutoInexistenteException() {
        super("Produto não cadastrado");
    }
}
