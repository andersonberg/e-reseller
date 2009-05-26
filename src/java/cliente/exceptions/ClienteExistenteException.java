package cliente.exceptions;

public class ClienteExistenteException extends Exception {

    public ClienteExistenteException() {
	super("Cliente ja cadastrado");
  }
}
