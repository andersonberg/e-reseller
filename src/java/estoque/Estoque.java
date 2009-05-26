package estoque;

import java.sql.Date;

public class Estoque {
    
    private int id_est;
    private int id_prod;
    private int quantidade_est;
    private float valor_prod_est;
    private int id_usu;
    private Date dthr_atualizacao;
    
    public Estoque(int id_est, int id_prod, int quantidade_est,
            float valor_prod_est, int id_usu,Date dthr_atualizacao){
       this.setId_est(id_est);
       this.setId_prod(id_prod);
       this.setQuantidade_est(quantidade_est);
       this.setValor_prod_est(valor_prod_est);
       this.setId_usu(id_usu);
       this.setDthr_atualizacao(dthr_atualizacao);
    }
    public Estoque(int id_est, int id_prod, int quantidade_est,
            float valor_prod_est, int id_usu){
       this.setId_est(id_est);
       this.setId_prod(id_prod);
       this.setQuantidade_est(quantidade_est);
       this.setValor_prod_est(valor_prod_est);
       this.setId_usu(id_usu);
    }

    public Estoque(int id_prod, int quantidade_est,
            float valor_prod_est, int id_usu){
       this.setId_prod(id_prod);
       this.setQuantidade_est(quantidade_est);
       this.setValor_prod_est(valor_prod_est);
       this.setId_usu(id_usu);
       this.setId_usu(id_usu);
    }
    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getQuantidade_est() {
        return quantidade_est;
    }

    public void setQuantidade_est(int quantidade_est) {
        this.quantidade_est = quantidade_est;
    }

    public float getValor_prod_est() {
        return valor_prod_est;
    }

    public void setValor_prod_est(float valor_prod_est) {
        this.valor_prod_est = valor_prod_est;
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
