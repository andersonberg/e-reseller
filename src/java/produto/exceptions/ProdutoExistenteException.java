package produto.exceptions;

public class ProdutoExistenteException extends Exception {

    public ProdutoExistenteException() {
	super("Produto ja cadastrado");
  }
}
