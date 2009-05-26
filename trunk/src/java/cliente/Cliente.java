package cliente;

import java.sql.Date;

public class Cliente {
    
    private int id_cli;
    private String nome_cli;
    private String endereco_cli;
    private int id_usu;
    private Date dthr_atualizacao;
        
    /** Creates a new instance of Cliente */
    public Cliente( int id_cli, 
                    String nome_cli, 
                    String endereco_cli,
                    int id_usu,
                    Date dthr_atualizacao
                    ) {
        this.setId_cli(id_cli);
        this.setNome_cli(nome_cli);
        this.setEndereco_cli(endereco_cli);
        this.setId_usu(id_usu);
        this.setDthr_atualizacao(dthr_atualizacao);
    }
public Cliente( int id_cli, 
                    String nome_cli, 
                    String endereco_cli,
                    int id_usu
                    ) {
        this.setId_cli(id_cli);
        this.setNome_cli(nome_cli);
        this.setEndereco_cli(endereco_cli);
        this.setId_usu(id_usu);
    }
    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }
    
    public String getEndereco_cli() {
        return endereco_cli;
    }

    public void setEndereco_cli(String endereco_cli) {
        this.endereco_cli = endereco_cli;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public Date getDthr_atualizacao() {
        return dthr_atualizacao;
    }

    public void setDthr_atualizacao(Date dthr_atualizacao) {
        this.dthr_atualizacao = dthr_atualizacao;
    }
    
}
