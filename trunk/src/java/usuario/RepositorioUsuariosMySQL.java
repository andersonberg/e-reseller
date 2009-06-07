package usuario;

import java.sql.*;
import conexao.RepositorioException;
import usuario.exceptions.*;
import conexao.GerenciadorConexao;
import conexao.GerenciadorConexaoGeral;
import java.util.Collection;
import java.util.Vector;

public class RepositorioUsuariosMySQL implements RepositorioUsuarios {

    private GerenciadorConexao gerenciador;
    private static RepositorioUsuariosMySQL instancia;

    /** Creates a new instance of RepositorioUsuariosMySQL */
    public RepositorioUsuariosMySQL() throws ClassNotFoundException, SQLException {
        gerenciador = GerenciadorConexaoGeral.obterInstancia();
    }

    public Usuario procurar(int id, int tipo) throws UsuarioInexistenteException, RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Usuario procurado = null;
        try {
            String query;
            if (tipo == 1) {
                query = "SELECT * FROM usuario_usu " + " WHERE id_usu='" + id + "'";
            } else {
                query = "SELECT * FROM usuario_usu " + " WHERE id_cli='" + id + "'";
            }
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                procurado = new Usuario(
                        rs.getInt("id_usu"),
                        rs.getString("nome_usu"),
                        rs.getString("login_usu"),
                        rs.getString("senha_usu"),
                        rs.getInt("id_cli"),
                        rs.getString("status_usu"));
            } else {
                throw new UsuarioInexistenteException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } finally {
            try {
                gerenciador.liberarResultset(rs);
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }
        return procurado;
    }

    public void atualizar(Usuario usuario) throws UsuarioInexistenteException, RepositorioException {
        Statement stmt = null;
        try {
            String query = "UPDATE usuario_usu set " + "nome_usu='" + usuario.getNome_usu() + "', " + "login_usu='" + usuario.getLogin_usu() + "', " + "senha_usu='" + usuario.getSenha_usu() + "', " + "status_usu='" + usuario.getStatus_usu() + "' " + " WHERE id_usu='" + usuario.getId_usu() + "'";
            stmt = gerenciador.getConnection().createStatement();
            //query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
            if (i == 0) {
                throw new UsuarioInexistenteException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error();
        } finally {
            try {
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }
    }

    public boolean existe(int id_usu) throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            String query = "SELECT * FROM usuario_usu " + "WHERE id_usu='" + id_usu + "'";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } finally {
            try {
                gerenciador.liberarResultset(rs);
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }
        return resp;
    }

    public boolean existeLogin(Usuario usuario) throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            String query = "SELECT * FROM usuario_usu " + "WHERE id_usu<>" + usuario.getId_usu() + " and login_usu='" + usuario.getLogin_usu().trim() + "'";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } finally {
            try {
                gerenciador.liberarResultset(rs);
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }
        return resp;
    }

    public void inserir(Usuario usuario) throws RepositorioException {
        Statement stmt = null;
        try {
            String query = "INSERT INTO usuario_usu (nome_usu,login_usu,senha_usu,id_cli,status_usu) VALUES( " + "'" + usuario.getNome_usu() + "', " + "'" + usuario.getLogin_usu() + "', " + "'" + usuario.getSenha_usu() + "', " + "'" + usuario.getId_cli() + "', " + "'" + usuario.getStatus_usu() + "')";

            stmt = gerenciador.getConnection().createStatement();
           // query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error();
        } finally {

            try {
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }
    }

    public Collection procurarUsuarios() throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Vector resp = new Vector();

        try {
            String query = "SELECT * FROM usuario_usu ORDER BY nome_usu";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_usu = rs.getInt("id_usu");
                String nome_usu = rs.getString("nome_usu");
                String login_usu = rs.getString("login_usu");
                String status_usu = rs.getString("status_usu");
                int id_cli = rs.getInt("id_cli");

                Usuario atual = null;
                atual = new Usuario(id_usu, nome_usu, login_usu, "", id_cli, status_usu);
                resp.addElement(atual);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } finally {
            try {
                gerenciador.liberarResultset(rs);
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                throw new RepositorioException(ex);
            }
        }
        return resp;
    }

    public boolean remover(Usuario usuario) throws RepositorioException {
        Statement stmt = null;
        boolean resp = false;
        try {
            String query = "DELETE FROM usuario_usu WHERE id_usu= " + usuario.getId_usu();
            stmt = gerenciador.getConnection().createStatement();
            stmt.executeUpdate(query);
            resp=true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } finally {
            try {
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }

        return resp;
    }

    public boolean remover(int id_cli) throws RepositorioException {
        Statement stmt = null;
        boolean resp = false;
        try {
            String query = "DELETE FROM usuario_usu WHERE id_cli= " + id_cli;
            stmt = gerenciador.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } finally {
            try {
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }

        return resp;
    }

    public int liberarAcesso(String login_usu, String senha_usu) throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        int resp = 0;
        try {
            String query = "SELECT id_usu FROM usuario_usu " + "WHERE status_usu='A' and login_usu='" + login_usu.trim() + "' AND senha_usu='" + senha_usu.trim() + "'";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                resp = rs.getInt("id_usu");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        } finally {
            try {
                gerenciador.liberarResultset(rs);
                gerenciador.liberarStatement(stmt);
                gerenciador.returnConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RepositorioException(ex);
            }
        }
        return resp;
    }
}
