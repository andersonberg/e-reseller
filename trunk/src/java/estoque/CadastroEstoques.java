package estoque;

import estoque.exceptions.*;
import conexao.RepositorioException;
import java.util.Collection;

public class CadastroEstoques {

    private RepositorioEstoques estoques;

    /** Creates a new instance of CadastroEstoques */
    public CadastroEstoques(RepositorioEstoques rep) {
        if (rep == null) {
            throw new IllegalArgumentException("Argumento lista grupo nula");
        }
        this.estoques = rep;
    }

    public Estoque procurar(int id_prod) throws EstoqueInexistenteException, RepositorioException {
        return estoques.procurar(id_prod);
    }

    public void inserir(Estoque estoque) throws RepositorioException {
        estoques.inserir(estoque);
        
    }

    public void atualizar(Estoque estoque) throws RepositorioException, EstoqueInexistenteException {
            estoques.atualizar(estoque);
      
    }

    public boolean remover(int id_prod) throws EstoqueInexistenteException,RepositorioException {
            return estoques.remover(id_prod);    
    }
    
    public Collection procurarEstoque() throws RepositorioException {
        return estoques.procurarEstoque();
    }

    public void alterarEstoque(int id_prod, int alterar, int tipo) throws EstoqueInexistenteException,RepositorioException{
        estoques.alterarEstoque(id_prod, alterar, tipo);
    } 
}
