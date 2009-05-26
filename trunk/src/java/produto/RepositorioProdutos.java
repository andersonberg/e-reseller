package produto;

import conexao.RepositorioException;
import produto.exceptions.*;
import java.util.Collection;

public interface RepositorioProdutos {
 
    public int inserir(Produto produto) throws RepositorioException;

    public void atualizar(Produto produto) throws ProdutoInexistenteException, RepositorioException;

    public Produto procurar(int id_prod) throws ProdutoInexistenteException, RepositorioException;

    public boolean remover(Produto produto) throws RepositorioException;

    public Collection procurarProdutos() throws RepositorioException;
}
