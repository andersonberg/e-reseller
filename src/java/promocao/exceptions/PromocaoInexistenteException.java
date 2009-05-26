package promocao.exceptions;

public class PromocaoInexistenteException extends Exception {

    public PromocaoInexistenteException() {
        super("Promoção não cadastrado");
    }
}
