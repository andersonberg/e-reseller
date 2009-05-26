package conexao;

import conexao.GerenciadorConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class GerenciadorConexaoGeral implements GerenciadorConexao {

    private static GerenciadorConexaoGeral instancia;
    private String nomeDriver = "org.gjt.mm.mysql.Driver";
    private String url = "jdbc:mysql://localhost/si2009?user=root&password=root&autoReconnect=true";
    private Connection conexao = null;
    private boolean bloqueada = false;

    public synchronized static GerenciadorConexaoGeral obterInstancia() throws
            ClassNotFoundException, SQLException {

        if (instancia == null) {
            instancia = new GerenciadorConexaoGeral();
        }
        return instancia;
    }

    private GerenciadorConexaoGeral() throws ClassNotFoundException, SQLException {
        abrirConexao();
    }

    private synchronized void abrirConexao() throws SQLException, ClassNotFoundException {
        Class.forName(nomeDriver);
        conexao = DriverManager.getConnection(url);
        bloqueada = false;
    }

    public synchronized Connection getConnection() throws SQLException {
        if (conexao == null) {
            try {
                abrirConexao();
            } catch (ClassNotFoundException ex) {
                throw new SQLException(ex.getMessage());
            }
        }
        bloqueada = true;
        return conexao;
    }

    public synchronized void returnConnection() throws SQLException {
        bloqueada = false;
        notifyAll();
    }

    public synchronized void liberarStatement(Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        } else {
        }
    }

    public synchronized void liberarResultset(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        } else {
        }
    }

    public synchronized void conexao_begin() throws SQLException {
        conexao.setAutoCommit(false);
    }

    public synchronized void conexao_commit() throws SQLException {
        if (conexao.getAutoCommit() == false) {
            conexao.commit();
            conexao.setAutoCommit(true);
        }
    }

    public synchronized void conexao_abort() throws SQLException {
        if (conexao.getAutoCommit() == false) {
            conexao.rollback();
            conexao.setAutoCommit(true);
        }
    }
}