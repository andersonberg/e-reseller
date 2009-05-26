package conexao;

public class RepositorioException extends Exception {

  public RepositorioException(Throwable cause){
    super(cause.getMessage());
  }
}