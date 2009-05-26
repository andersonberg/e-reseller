package cliente;

import cliente.exceptions.*;
import conexao.RepositorioException;
import java.util.Collection;

public class CadastroClientes {

    private RepositorioClientes clientes;

    /** Creates a new instance of CadastroClientes */
    public CadastroClientes(RepositorioClientes rep) {
        if (rep == null) {
            throw new IllegalArgumentException("Argumento lista grupo nula");
        }
        this.clientes = rep;
    }

    public Cliente procurar(int id_cli) throws ClienteInexistenteException, RepositorioException {
        return clientes.procurar(id_cli);
    }

    public void inserir(Cliente cliente) throws RepositorioException {
        clientes.inserir(cliente);
        
    }

    public void atualizar(Cliente cliente) throws RepositorioException, ClienteInexistenteException {
            clientes.atualizar(cliente);
      
    }

    public boolean remover(Cliente cliente) throws ClienteInexistenteException, RepositorioException {
            return clientes.remover(cliente);
    }

    public Collection procurarClientes() throws RepositorioException {
        return clientes.procurarClientes();
    }
}
