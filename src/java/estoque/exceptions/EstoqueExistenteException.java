package estoque.exceptions;

public class EstoqueExistenteException extends Exception {

    public EstoqueExistenteException() {
	super("Produto ja cadastrado");
  }
}
