package usuario;

import usuario.*;
import usuario.exceptions.*;
import conexao.RepositorioException;
import java.util.Collection;

public class CadastroUsuarios {

    private RepositorioUsuarios usuarios;

    /** Creates a new instance of CadastroUsuarios */
    public CadastroUsuarios(RepositorioUsuarios rep) {
        if (rep == null) {
            throw new IllegalArgumentException("Argumento lista grupo nula");
        }
        this.usuarios = rep;
    }

    public Usuario procurar(int id,int tipo) throws UsuarioInexistenteException, RepositorioException {
        return usuarios.procurar(id,tipo);
    }

    public void inserir(Usuario usuario) throws UsuarioLoginExistenteException, RepositorioException {
        if (!usuarios.existe(usuario.getId_usu())) {
            if (!usuarios.existeLogin(usuario)) {
                usuarios.inserir(usuario);
            } else {
                throw new UsuarioLoginExistenteException();
            }
        }
    }

    public void atualizar(Usuario usuario) throws UsuarioExistenteException, RepositorioException, UsuarioInexistenteException {
        if (!usuarios.existeLogin(usuario)){
            usuarios.atualizar(usuario);
        }else{
            throw new UsuarioExistenteException();
        }
        
    }

    public boolean remover(Usuario usuario) throws UsuarioInexistenteException, RepositorioException {
        if (usuarios.existe(usuario.getId_usu())) {
            return usuarios.remover(usuario);
        } else {
            throw new UsuarioInexistenteException();
        }
    }
    
     public boolean remover(int id_cli) throws UsuarioInexistenteException, RepositorioException {
            return usuarios.remover(id_cli);
    }

    public Collection procurarUsuarios() throws RepositorioException {
        return usuarios.procurarUsuarios();
    }

    public boolean existe(int id_usu) throws RepositorioException {
        return usuarios.existe(id_usu);
    }
    
    public boolean existeLogin(Usuario usuario) throws RepositorioException {
        return usuarios.existeLogin(usuario);
    }
    
    public int liberarAcesso(String login_usu, String senha_usu)throws RepositorioException{
        return usuarios.liberarAcesso(login_usu, senha_usu);
    } 

}
