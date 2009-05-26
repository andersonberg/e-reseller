package estoque;

import conexao.RepositorioException;
import estoque.exceptions.*;
import java.util.Collection;

public interface RepositorioEstoques {
 
    public void inserir(Estoque estoque) throws RepositorioException;

    public void atualizar(Estoque estoque) throws EstoqueInexistenteException, RepositorioException;

    public Estoque procurar(int id_prod) throws EstoqueInexistenteException, RepositorioException;
    
    public Collection procurarEstoque() throws RepositorioException;
    
    public boolean remover(int id_prod) throws EstoqueInexistenteException,RepositorioException;
    
    public void alterarEstoque(int id_prod, int alterar, int tipo) throws EstoqueInexistenteException,RepositorioException;
}
