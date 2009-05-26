package usuario.exceptions;

public class UsuarioInexistenteException extends Exception {

    public UsuarioInexistenteException() {
        super("Usuario não cadastrado");
    }
}
