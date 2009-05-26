package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface GerenciadorConexao {
  public Connection getConnection() throws SQLException;
  public void liberarStatement(Statement stmt) throws SQLException;
  public void liberarResultset(ResultSet rs) throws SQLException;
  public void returnConnection() throws SQLException;

  public void conexao_begin() throws SQLException;          
  public void conexao_commit() throws SQLException;  
  public void conexao_abort() throws SQLException;  
}