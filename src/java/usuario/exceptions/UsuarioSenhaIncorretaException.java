package usuario.exceptions;

public class UsuarioSenhaIncorretaException extends Exception {

    public UsuarioSenhaIncorretaException() {
        super("Senha Incorreta");
    }
}
