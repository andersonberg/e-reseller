package promocao;

import conexao.RepositorioException;
import promocao.exceptions.*;
import java.util.Collection;

public interface RepositorioPromocoes {
 
    public void inserir(Promocao promocao) throws RepositorioException;

    public void atualizar(Promocao promocao) throws PromocaoInexistenteException, RepositorioException;

    public Promocao procurar(int id_prod) throws PromocaoInexistenteException, RepositorioException;

    public boolean remover(Promocao promocao) throws RepositorioException;

    public Collection procurarPromocoes() throws RepositorioException;
    
    public Collection procurarPromocoes(Promocao promocao) throws RepositorioException;
}
