package venda;

import venda.exceptions.*;
import conexao.RepositorioException;
import java.util.Collection;

public class CadastroVendas {

    private RepositorioVendas vendas;

    /** Creates a new instance of CadastroVendas */
    public CadastroVendas(RepositorioVendas rep) {
        if (rep == null) {
            throw new IllegalArgumentException("Argumento lista grupo nula");
        }
        this.vendas = rep;
    }

    public Venda procurar(int id,int tipo) throws VendaInexistenteException, RepositorioException {
        return vendas.procurar(id,tipo);
    }

    public void inserir(Venda venda) throws VendaExistenteException, RepositorioException {
       vendas.inserir(venda);
    }

    public boolean remover(Venda venda) throws VendaInexistenteException, RepositorioException {
        return vendas.remover(venda);
    }
    
    public Collection procurarVendas(int id, int tipo) throws RepositorioException {
        return vendas.procurarVendas(id, tipo);
    }

    public Collection procurarVendas(int id_prod, int id_cli, String dtInicial, String dtFinal) throws RepositorioException {
        return vendas.procurarVendas(id_prod, id_cli, dtInicial, dtFinal);
    }
}
