package venda.exceptions;

public class VendaInexistenteException extends Exception {

    public VendaInexistenteException() {
        super("Venda não localizada");
    }
}
