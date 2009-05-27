package venda;

import java.sql.*;
import conexao.RepositorioException;
import venda.exceptions.*;
import conexao.GerenciadorConexao;
import conexao.GerenciadorConexaoGeral;
import java.util.Collection;
import java.util.Vector;

public class RepositorioVendasMySQL implements RepositorioVendas {

    private GerenciadorConexao gerenciador;
    private static RepositorioVendasMySQL instancia;

    /** Creates a new instance of RepositorioVendasMySQL */
    public RepositorioVendasMySQL() throws ClassNotFoundException, SQLException {
        gerenciador = GerenciadorConexaoGeral.obterInstancia();
    }

    public Venda procurar(int id, int tipo) throws VendaInexistenteException, RepositorioException {
                Statement stmt = null;
        ResultSet rs = null;
        Venda procurado = null;
        try {
            String query;
            if (tipo == 1) {
                query = "SELECT * FROM venda_ven " + " WHERE id_prod='" + id + "'";
            } else {
                query = "SELECT * FROM venda_ven " + " WHERE id_cli='" + id + "'";
            } 
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                procurado = new Venda(
                        rs.getInt("id_ven"),
                        rs.getInt("id_prod"),
                        rs.getInt("id_cli"),
                        rs.getInt("qtd_ven"),
                        rs.getFloat("valor_ven"),
                        rs.getString("prazo_ven"),
                        rs.getInt("id_usu"),
                        rs.getDate("dthr_atualizacao"));
            } else {
                throw new VendaInexistenteException();
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

    public void inserir(Venda venda) throws RepositorioException {
        Statement stmt = null;
        try {
            String query = "INSERT INTO venda_ven (id_prod,id_cli,qtd_ven,valor_ven,prazo_ven,id_usu) VALUES( " 
                    + "'" + venda.getId_prod() + "', " + "'" + venda.getId_cli() + "', " 
                    + "'" + venda.getQtd_ven() + "', " + "'" + venda.getValor_ven() + "', " 
                    + "'" + venda.getPrazo_ven() + "', " + "'" + venda.getId_usu() + "')";

            stmt = gerenciador.getConnection().createStatement();
            query = new String(query.getBytes("ISO-8859-1"), "UTF-8");
            int i = stmt.executeUpdate(query);
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

    public Collection procurarVendas(int id, int tipo) throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        Vector resp = new Vector();

        try {
            String query = null; 
            if (tipo==1){
                query="SELECT v.* FROM venda_ven v, produto_prod p, cliente_cli c where v.id_prod= "+id
                        +" and v.id_prod=p.id_prod and v.id_cli=c.id_cli ORDER BY descricao_prod";
            }else{
            query="SELECT v.* FROM venda_ven v, produto_prod p, cliente_cli c where v.id_cli= "+id
                        +" and v.id_prod=p.id_prod and v.id_cli=c.id_cli ORDER BY nome_cli";
            }
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_ven = rs.getInt("id_ven");
                int id_prod = rs.getInt("id_prod");
                int id_cli = rs.getInt("id_cli");
                int qtd_ven = rs.getInt("qtd_ven");
                float valor_ven = rs.getFloat("valor_ven");
                String prazo_ven = rs.getString("prazo_ven");
                int id_usu = rs.getInt("id_usu");
                Date dthr_atualizacao = rs.getDate("dthr_atualizacao");
                

                Venda atual = null;
                atual = new Venda(id_ven, id_prod,id_cli, qtd_ven, valor_ven, prazo_ven,id_usu,dthr_atualizacao);
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

    public Collection procurarVendas(int id_prod, int id_cli, String dtInicial, String dtFinal) throws RepositorioException {
        Statement stmt = null;
        ResultSet rs = null;
        dtInicial = dtInicial.substring(6,10) + "-" + dtInicial.substring(3,5) + "-" + dtInicial.substring(0,2);
        dtFinal = dtFinal.substring(6,10) + "-" + dtFinal.substring(3,5) + "-" + dtFinal.substring(0,2);
        Vector resp = new Vector();

        try {
            String query = "SELECT * FROM venda_ven where id_prod= "+id_prod+ " and date_format(dthr_atualizacao,'%Y-%m-%d') between '"+dtInicial+"' and '"+dtFinal+"'";
                   if (id_cli>0){
                       query = query+" and id_cli="+id_cli;
                   }     
                   query = query+" ORDER BY dthr_atualizacao";
           
            stmt = gerenciador.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_ven = rs.getInt("id_ven");
                int prod = rs.getInt("id_prod");
                int cli = rs.getInt("id_cli");
                int qtd_ven = rs.getInt("qtd_ven");
                float valor_ven = rs.getFloat("valor_ven");
                String prazo_ven = rs.getString("prazo_ven");
                int id_usu = rs.getInt("id_usu");
                Date dthr_atualizacao = rs.getDate("dthr_atualizacao");
                

                Venda atual = null;
                atual = new Venda(id_ven, prod,cli, qtd_ven, valor_ven, prazo_ven,id_usu,dthr_atualizacao);
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
    
    public boolean remover(Venda venda) throws RepositorioException {
        Statement stmt = null;
        boolean resp = false;
        try {
            String query = "DELETE FROM venda_ven WHERE id_ven= " + venda.getId_ven();
            stmt = gerenciador.getConnection().createStatement();
            int i = stmt.executeUpdate(query);
            resp = true;
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
