package produto;

import estoque.exceptions.EstoqueInexistenteException;
import java.sql.SQLException;
import produto.exceptions.*;
import promocao.*;
import conexao.RepositorioException;
import estoque.*;
import java.util.Collection;
import promocao.exceptions.PromocaoInexistenteException;

public class CadastroProdutos {

    private RepositorioProdutos produtos;
    
    /** Creates a new instance of CadastroProdutos */
    public CadastroProdutos(RepositorioProdutos rep){
        if (rep == null) {
            throw new IllegalArgumentException("Argumento lista grupo nula");
        }
        this.produtos = rep;
    }

    public Produto procurar(int id_prod) throws ProdutoInexistenteException, RepositorioException {
        return produtos.procurar(id_prod);
    }

    public int inserir(Produto produto) throws RepositorioException {
        return produtos.inserir(produto);
        
    }

    public void atualizar(Produto produto) throws RepositorioException, ProdutoInexistenteException {
            produtos.atualizar(produto);
      
    }

    public boolean remover(Produto produto) throws ProdutoInexistenteException, RepositorioException {
            return produtos.remover(produto);    
    }

    public Collection procurarProdutos() throws RepositorioException {
        return produtos.procurarProdutos();
    }
}
