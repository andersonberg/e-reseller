package cliente;

import java.sql.*;
import conexao.RepositorioException;
import cliente.exceptions.*;
import conexao.GerenciadorConexao;
import conexao.GerenciadorConexaoGeral;
import java.util.Collection;
import java.util.Vector;

public class RepositorioClientesMySQL implements RepositorioClientes {

    private GerenciadorConexao gerenciador;
    private static RepositorioClientesMySQL instancia;

    /** Creates a new instance of RepositorioClientesMySQL */
    public RepositorioClientesMySQL() throws ClassNotFoundException, SQLException {
        gerenciador = GerenciadorConexaoGeral.obterInstancia();
    }

    public Cliente procurar(int id_cli) throws ClienteInexistenteException, RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Cliente procurado = null;
        try {
            String query = "SELECT * FROM cliente_cli " + " WHERE id_cli='" + id_cli + "'";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                procurado = new Cliente(
                        rs.getInt("id_cli"),
                        rs.getString("nome_cli"),
                        rs.getString("endereco_cli"),
                        rs.getInt("id_usu"),
                        rs.getDate("dthr_atualizacao"));
            } else {
                throw new ClienteInexistenteException();
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

    public void atualizar(Cliente cliente) throws ClienteInexistenteException, RepositorioException {
        Statement stmt = null;
        try {
            String query = "UPDATE cliente_cli set " 
                    + "nome_cli='" + cliente.getNome_cli() + "', " 
                     + "endereco_cli='" + cliente.getEndereco_cli() + "', " 
                    + "id_usu='" + cliente.getId_usu() + "' " 
                    + " WHERE id_cli='" + cliente.getId_cli()+ "'";
            stmt = gerenciador.getConnection().createStatement();
            //query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
            if (i == 0) {
                throw new ClienteInexistenteException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        }catch(Exception ex){
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

     public void inserir(Cliente cliente) throws RepositorioException {
        Statement stmt = null;
        try {
            String query = "INSERT INTO cliente_cli (nome_cli,endereco_cli,id_usu) VALUES( " + "'" 
                    + cliente.getNome_cli() + "', " + "'" 
                    + cliente.getEndereco_cli() + "', " + "'" 
                    + cliente.getId_usu() +"')";

            stmt = gerenciador.getConnection().createStatement();
            //query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RepositorioException(ex);
        }catch(Exception ex){
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

    public Collection procurarClientes() throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Vector resp = new Vector();

        try {
            String query = "SELECT * FROM cliente_cli ORDER BY nome_cli";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_cli = rs.getInt("id_cli");
                int id_usu = rs.getInt("id_usu");
                String nome_cli = rs.getString("nome_cli");
                String endereco_cli = rs.getString("endereco_cli");
                Date dthr_atualizacao = rs.getDate("dthr_atualizacao");
                Cliente atual = null;
                atual = new Cliente(id_cli, nome_cli,endereco_cli, id_usu,dthr_atualizacao);
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

    public boolean remover(Cliente cliente) throws RepositorioException {
        Statement stmt = null;
        boolean resp = false;
        try {
            String query = "DELETE FROM cliente_cli WHERE id_cli= " + cliente.getId_cli();
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


}
