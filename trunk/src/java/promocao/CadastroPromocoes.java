package promocao;

import promocao.exceptions.*;
import conexao.RepositorioException;
import java.util.Collection;

public class CadastroPromocoes {

    private RepositorioPromocoes promocoes;

    /** Creates a new instance of CadastroPromocoes */
    public CadastroPromocoes(RepositorioPromocoes rep) {
        if (rep == null) {
            throw new IllegalArgumentException("Argumento lista grupo nula");
        }
        this.promocoes = rep;
    }

    public Promocao procurar(int id_prod) throws PromocaoInexistenteException, RepositorioException {
        return promocoes.procurar(id_prod);
    }

    public void inserir(Promocao promocao) throws RepositorioException {
        promocoes.inserir(promocao);
        
    }

    public void atualizar(Promocao promocao) throws RepositorioException, PromocaoInexistenteException {
            promocoes.atualizar(promocao);
      
    }

    public boolean remover(Promocao promocao) throws PromocaoInexistenteException, RepositorioException {
            return promocoes.remover(promocao);
    }

    public Collection procurarPromocoes() throws RepositorioException {
        return promocoes.procurarPromocoes();
    }
    
    public Collection procurarPromocoes(Promocao promocao) throws RepositorioException {
        return promocoes.procurarPromocoes(promocao);
    }
}
