package usuario;

import conexao.RepositorioException;
import usuario.exceptions.*;
import java.util.Collection;

public interface RepositorioUsuarios {

    public boolean existe(int id_usu) throws RepositorioException;

    public boolean existeLogin(Usuario usuario) throws RepositorioException;

    public int liberarAcesso(String login_usu, String senha_usu) throws RepositorioException;

    public void inserir(Usuario usuario) throws RepositorioException;

    public void atualizar(Usuario usuario) throws UsuarioInexistenteException, RepositorioException;

    public Usuario procurar(int id, int tipo) throws UsuarioInexistenteException, RepositorioException;
    
    public boolean remover(Usuario usuario) throws RepositorioException;

    public boolean remover(int id_cli) throws RepositorioException;

    public Collection procurarUsuarios() throws RepositorioException;
}
