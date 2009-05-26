package usuario.exceptions;

public class UsuarioLoginExistenteException extends Exception {

    public UsuarioLoginExistenteException() {
	super("Login ja cadastrado");
  }
}
