package produto.exceptions;

public class ProdutoRestricaoException extends Exception {

    public ProdutoRestricaoException() {
	super("Produto encontra-se com restrição para exclusão");
  }
}
