package produto;

import java.sql.*;
import conexao.RepositorioException;
import produto.exceptions.*;
import conexao.GerenciadorConexao;
import conexao.GerenciadorConexaoGeral;
import java.util.Collection;
import java.util.Vector;

public class RepositorioProdutosMySQL implements RepositorioProdutos {

    private GerenciadorConexao gerenciador;
    private static RepositorioProdutosMySQL instancia;

    /** Creates a new instance of RepositorioProdutosMySQL */
    public RepositorioProdutosMySQL() throws ClassNotFoundException, SQLException {
        gerenciador = GerenciadorConexaoGeral.obterInstancia();
    }

    public Produto procurar(int id_prod) throws ProdutoInexistenteException, RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Produto procurado = null;
        try {
            String query = "SELECT * FROM produto_prod " + " WHERE id_prod='" + id_prod + "'";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                procurado = new Produto(
                        rs.getInt("id_prod"),
                        rs.getString("descricao_prod"),
                        rs.getString("caracteristicas_prod"),
                        rs.getString("dimensao_prod"),
                        rs.getString("peso_prod"),
                        rs.getString("espec_tecnicas_prod"),
                        rs.getInt("id_usu"),
                        rs.getDate("dthr_atualizacao"));
            } else {
                throw new ProdutoInexistenteException();
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

    public void atualizar(Produto produto) throws ProdutoInexistenteException, RepositorioException {
        Statement stmt = null;
        try {
            String query = "UPDATE produto_prod set " 
                    + "descricao_prod='" + produto.getDescricao_prod() + "', " 
                    + "caracteristicas_prod='" + produto.getCaracteristicas_prod() + "', "
                    + "dimensao_prod='" + produto.getDimensao_prod() + "', "
                    + "peso_prod='" + produto.getPeso_prod() + "', "
                    + "espec_tecnicas_prod='" + produto.getEspec_tecnicas_prod() + "', "
                    + "id_usu='" + produto.getId_usu() + "' " 
                    + " WHERE id_prod='" + produto.getId_prod()+ "'";
            stmt = gerenciador.getConnection().createStatement();
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
            if (i == 0) {
                throw new ProdutoInexistenteException();
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

     public int inserir(Produto produto) throws RepositorioException {
        ResultSet rs = null;
         Statement stmt = null;
         int retorno = 0;
        try {
            String query = "INSERT INTO produto_prod (descricao_prod,caracteristicas_prod,dimensao_prod,peso_prod,espec_tecnicas_prod,id_usu) VALUES( " + "'" 
                    + produto.getDescricao_prod() + "', " + "'"
                    + produto.getCaracteristicas_prod() + "', " + "'" 
                    + produto.getDimensao_prod() + "', " + "'" 
                    + produto.getPeso_prod() + "', " + "'" 
                    + produto.getEspec_tecnicas_prod() + "', " + "'" 
                    + produto.getId_usu() +"')";

            stmt = gerenciador.getConnection().createStatement();
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
            
            query = "SELECT id_prod FROM produto_prod order by id_prod desc limit 1";
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            rs = stmt.executeQuery(query);
             while (rs.next()) {
                 retorno = rs.getInt("id_prod");
                 
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
        return retorno;
    }

    public Collection procurarProdutos() throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Vector resp = new Vector();

        try {
            String query = "SELECT * FROM produto_prod ORDER BY descricao_prod";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_prod = rs.getInt("id_prod");
                int id_usu = rs.getInt("id_usu");
                String descricao_prod = rs.getString("descricao_prod");
                String caracteristicas_prod = rs.getString("caracteristicas_prod");
                String dimensao_prod = rs.getString("dimensao_prod");
                String peso_prod = rs.getString("peso_prod");
                String espec_tecnicas_prod = rs.getString("espec_tecnicas_prod");
                Date dthr_atualizacao = rs.getDate("dthr_atualizacao");
                Produto atual = null;
                atual = new Produto(id_prod, descricao_prod,caracteristicas_prod,dimensao_prod,peso_prod,espec_tecnicas_prod,id_usu,dthr_atualizacao);
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

    public boolean remover(Produto produto) throws RepositorioException {
        Statement stmt = null;
        boolean resp = false;
        try {
            String query = "DELETE FROM produto_prod WHERE id_prod= " + produto.getId_prod();
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


}
