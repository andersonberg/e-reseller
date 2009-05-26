package estoque.exceptions;

public class EstoqueInexistenteException extends Exception {

    public EstoqueInexistenteException() {
        super("Produto não cadastrado");
    }
}
