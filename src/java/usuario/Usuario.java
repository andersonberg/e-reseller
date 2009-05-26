package usuario;

public class Usuario {
    
    private int id_usu;
    private String nome_usu;
    private String login_usu;
    private String senha_usu;
    private int id_cli;
    private String status_usu;
        
    /** Creates a new instance of Usuario */
    public Usuario( int id_usu, 
                    String nome_usu, 
                    String login_usu,
                    String senha_usu,
                    int id_cli,
                    String status_usu
                    ) {
        this.setId_usu(id_usu);
        this.setNome_usu(nome_usu);
        this.setLogin_usu(login_usu);
        this.setSenha_usu(senha_usu);
         this.setId_cli(id_cli);
        this.setStatus_usu(status_usu);
    }
    
    public Usuario(int id_usu){
        this.setId_usu(id_usu);
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }
    
    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getNome_usu() {
        return nome_usu;
    }

    public void setNome_usu(String nome_usu) {
        this.nome_usu = nome_usu;
    }

    public String getLogin_usu() {
        return login_usu;
    }

    public void setLogin_usu(String login_usu) {
        this.login_usu = login_usu;
    }

    public String getSenha_usu() {
        return senha_usu;
    }

    public void setSenha_usu(String senha_usu) {
        this.senha_usu = senha_usu;
    }

    public String getStatus_usu() {
        return status_usu;
    }

    public void setStatus_usu(String status_usu) {
        this.status_usu = status_usu;
    }

}
