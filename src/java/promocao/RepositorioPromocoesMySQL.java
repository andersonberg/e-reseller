package promocao;

import java.sql.*;
import conexao.RepositorioException;
import promocao.exceptions.*;
import conexao.GerenciadorConexao;
import conexao.GerenciadorConexaoGeral;
import java.util.Collection;
import java.util.Vector;

public class RepositorioPromocoesMySQL implements RepositorioPromocoes {

    private GerenciadorConexao gerenciador;
    private static RepositorioPromocoesMySQL instancia;

    /** Creates a new instance of RepositorioPromocoesMySQL */
    public RepositorioPromocoesMySQL() throws ClassNotFoundException, SQLException {
        gerenciador = GerenciadorConexaoGeral.obterInstancia();
    }

    public Promocao procurar(int id_pro) throws PromocaoInexistenteException, RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Promocao procurado = null;
        try {
            String query = "SELECT * FROM promocao_pro " + " WHERE id_prod='" + id_pro + "' ORDER BY dthr_atualizacao DESC";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                procurado = new Promocao(
                        rs.getInt("id_pro"),
                        rs.getInt("id_prod"),
                        rs.getString("descricao_pro"),
                        rs.getInt("desconto_pro"),
                        rs.getInt("id_usu"),
                        rs.getDate("dthr_atualizacao"));
            } else {
                throw new PromocaoInexistenteException();
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

    public void atualizar(Promocao promocao) throws PromocaoInexistenteException, RepositorioException {
        Statement stmt = null;
        try {
            String query = "UPDATE promocao_pro set " 
                    + "descricao_pro='" + promocao.getDescricao_pro() + "', " 
                    + "id_usu='" + promocao.getId_usu() + "' " 
                    + " WHERE id_pro='" + promocao.getId_pro()+ "'";
            stmt = gerenciador.getConnection().createStatement();
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
            if (i == 0) {
                throw new PromocaoInexistenteException();
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

     public void inserir(Promocao promocao) throws RepositorioException {
        Statement stmt = null;
        try {
            String query = "INSERT INTO promocao_pro (id_prod,descricao_pro,desconto_pro,id_usu) VALUES( " + "'" 
                    + promocao.getId_prod() + "', " + "'" 
                    + promocao.getDescricao_pro() +"', " + "'"
                    + promocao.getDesconto_pro() +"', " + "'"
                    + promocao.getId_usu() +"')";

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

    public Collection procurarPromocoes() throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Vector resp = new Vector();

        try {
            String query = "SELECT * FROM promocao_pro ORDER BY descricao_pro";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_pro = rs.getInt("id_pro");
                int id_prod = rs.getInt("id_prod");
                int id_usu = rs.getInt("id_usu");
                String descricao_pro = rs.getString("descricao_pro");
                int desconto_pro = rs.getInt("desconto_pro");
                Date dthr_atualizacao = rs.getDate("dthr_atualizacao");
                Promocao atual = null;
                atual = new Promocao(id_pro,id_prod, descricao_pro,desconto_pro, id_usu,dthr_atualizacao);
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
    
    public Collection procurarPromocoes(Promocao promocao) throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Vector resp = new Vector();

        try {
            String query = "SELECT * FROM promocao_pro WHERE id_prod= "+promocao.getId_prod()+" ORDER BY id_pro desc";
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_pro = rs.getInt("id_pro");
                int id_prod = rs.getInt("id_prod");
                int id_usu = rs.getInt("id_usu");
                String descricao_pro = rs.getString("descricao_pro");
                int desconto_pro = rs.getInt("desconto_pro");
                Date dthr_atualizacao = rs.getDate("dthr_atualizacao");
                Promocao atual = null;
                atual = new Promocao(id_pro,id_prod, descricao_pro,desconto_pro, id_usu,dthr_atualizacao);
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

    public boolean remover(Promocao promocao) throws RepositorioException {
        Statement stmt = null;
        boolean resp = false;
        try {
            String query = "DELETE FROM promocao_pro WHERE id_prod= " + promocao.getId_prod();
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
