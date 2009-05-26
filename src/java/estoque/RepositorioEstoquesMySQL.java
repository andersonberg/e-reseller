package estoque;

import java.sql.*;
import conexao.RepositorioException;
import estoque.exceptions.*;
import conexao.GerenciadorConexao;
import conexao.GerenciadorConexaoGeral;
import java.util.Collection;
import java.util.Vector;

public class RepositorioEstoquesMySQL implements RepositorioEstoques {

    private GerenciadorConexao gerenciador;
    private static RepositorioEstoquesMySQL instancia;

    /** Creates a new instance of RepositorioEstoquesMySQL */
    public RepositorioEstoquesMySQL() throws ClassNotFoundException, SQLException {
        gerenciador = GerenciadorConexaoGeral.obterInstancia();
    }

    public Estoque procurar(int id_prod) throws EstoqueInexistenteException, RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Estoque procurado = null;
        try {
            String query = "SELECT * FROM estoque_est " + " WHERE id_prod='" + id_prod + "'";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                procurado = new Estoque(
                        rs.getInt("id_est"),
                        rs.getInt("id_prod"),
                        rs.getInt("quantidade_est"),
                        rs.getFloat("valor_prod_est"),
                        rs.getInt("id_usu"),
                        rs.getDate("dthr_atualizacao"));
            } else {
                throw new EstoqueInexistenteException();
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

    public void atualizar(Estoque estoque) throws EstoqueInexistenteException, RepositorioException {
        Statement stmt = null;
        try {
            String query = "UPDATE estoque_est set " 
                    + "quantidade_est='" + estoque.getQuantidade_est() + "', " 
                    + "valor_prod_est='" + estoque.getValor_prod_est() + "', "
                    + "id_usu='" + estoque.getId_usu() + "' " 
                    + " WHERE id_est='" + estoque.getId_est()+ "'";
            stmt = gerenciador.getConnection().createStatement();
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
            if (i == 0) {
                throw new EstoqueInexistenteException();
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

     public void inserir(Estoque estoque) throws RepositorioException {
        Statement stmt = null;
        try {
            String query = "INSERT INTO estoque_est (id_prod,quantidade_est,valor_prod_est,id_usu) VALUES( " + "'" 
                    + estoque.getId_prod() + "', " + "'"
                    + estoque.getQuantidade_est() + "', " + "'" 
                    + estoque.getValor_prod_est() + "', " + "'" 
                    + estoque.getId_usu() +"')";

            stmt = gerenciador.getConnection().createStatement();
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
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

    public Collection procurarEstoque() throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Vector resp = new Vector();

        try {
            String query = "SELECT * FROM estoque_est";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_est = rs.getInt("id_est");
                int id_prod = rs.getInt("id_prod");
                int quantidade = rs.getInt("quantidade_est");
                float valor = rs.getFloat("valor_prod_est");
                int id_usu = rs.getInt("id_usu");
                Date dthr_atualizacao = rs.getDate("dthr_atualizacao");
                Estoque atual = null;
                atual = new Estoque(id_est,id_prod,quantidade,valor,id_usu,dthr_atualizacao);
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
    
    public boolean remover(int id_prod) throws RepositorioException {
        Statement stmt = null;
        boolean resp = false;
        try {
            String query = "DELETE FROM estoque_est WHERE id_prod= '" + id_prod+"'";
            stmt = gerenciador.getConnection().createStatement();
            int i = stmt.executeUpdate(query);
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

    public void alterarEstoque(int id_prod, int alterar, int tipo) throws EstoqueInexistenteException, RepositorioException {
        Statement stmt = null;
        try {
            String complemento = "";
            if (tipo == 1){
                    complemento = "quantidade_est= quantidade_est-" + alterar ;
                    }else{
                    complemento = "quantidade_est= quantidade_est+" + alterar ; 
                    }
            String query = "UPDATE estoque_est set " 
                    + complemento
                    + " WHERE id_prod='" + id_prod+ "'";
            stmt = gerenciador.getConnection().createStatement();
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
            if (i == 0) {
                throw new EstoqueInexistenteException();
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

}
