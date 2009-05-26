package venda.exceptions;

public class VendaExistenteException extends Exception {

    public VendaExistenteException() {
	super("Venda ja registrada");
  }
}
