package usuario.exceptions;

public class UsuarioExistenteException extends Exception {

    public UsuarioExistenteException() {
	super("Usuario ja cadastrado");
  }
}
