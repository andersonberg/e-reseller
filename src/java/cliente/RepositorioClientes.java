package cliente;

import conexao.RepositorioException;
import cliente.exceptions.*;
import java.util.Collection;

public interface RepositorioClientes {
 
    public void inserir(Cliente cliente) throws RepositorioException;

    public void atualizar(Cliente cliente) throws ClienteInexistenteException, RepositorioException;

    public Cliente procurar(int id_cli) throws ClienteInexistenteException, RepositorioException;

    public boolean remover(Cliente cliente) throws RepositorioException;

    public Collection procurarClientes() throws RepositorioException;
}
