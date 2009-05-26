package promocao.exceptions;

public class PromocaoExistenteException extends Exception {

    public PromocaoExistenteException() {
	super("Promoção ja cadastrado");
  }
}
