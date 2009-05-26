package cliente.exceptions;

public class ClienteInexistenteException extends Exception {

    public ClienteInexistenteException() {
        super("Cliente não cadastrado");
    }
}
