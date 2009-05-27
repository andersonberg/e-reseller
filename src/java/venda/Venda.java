package venda;

import java.sql.Date;

public class Venda {
    
    private int id_ven;
    private int id_prod;
    private int id_cli;
    private int qtd_ven;
    private float valor_ven;
    private String prazo_ven;
    private int id_usu;
    private Date dthr_atualizacao;

    public Venda(int id_ven, int id_prod, int id_cli, 
            int qtd_ven,float valor_ven, String prazo_ven, 
            int id_usu, Date dthr_atualizacao){
        this.setId_ven(id_ven);
        this.setId_prod(id_prod);
        this.setId_cli(id_cli);
        this.setQtd_ven(qtd_ven);
        this.setValor_ven(valor_ven);
        this.setPrazo_ven(prazo_ven);
        this.setId_usu(id_usu);
        this.setDthr_atualizacao(dthr_atualizacao);
    }
    public Venda(int id_ven, int id_prod, int id_cli, 
            int qtd_ven,float valor_ven, String prazo_ven, 
            int id_usu){
        this.setId_ven(id_ven);
        this.setId_prod(id_prod);
        this.setId_cli(id_cli);
        this.setQtd_ven(qtd_ven);
        this.setValor_ven(valor_ven);
        this.setPrazo_ven(prazo_ven);
        this.setId_usu(id_usu);        
    }
            
    public int getId_ven() {
        return id_ven;
    }

    public void setId_ven(int id_ven) {
        this.id_ven = id_ven;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public int getQtd_ven() {
        return qtd_ven;
    }

    public void setQtd_ven(int qtd_ven) {
        this.qtd_ven = qtd_ven;
    }

    public float getValor_ven() {
        return valor_ven;
    }

    public void setValor_ven(float valor_ven) {
        this.valor_ven = valor_ven;
    }

    public String getPrazo_ven() {
        return prazo_ven;
    }

    public void setPrazo_ven(String prazo_ven) {
        this.prazo_ven = prazo_ven;
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
