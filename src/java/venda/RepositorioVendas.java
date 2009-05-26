package venda;

import conexao.RepositorioException;
import venda.exceptions.*;
import java.util.Collection;

public interface RepositorioVendas {

    public void inserir(Venda venda) throws RepositorioException;

    public Venda procurar(int id, int tipo) throws VendaInexistenteException, RepositorioException;
    
    public boolean remover(Venda venda) throws RepositorioException;

    public Collection procurarVendas(int id, int tipo) throws RepositorioException;
   
    public Collection procurarVendas(int id_prod, int id_cli, String dtInicial, String dtFinal) throws RepositorioException;
}
