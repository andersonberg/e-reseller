package promocao;

import java.sql.Date;

public class Promocao {
    
    private int id_pro;
    private int id_prod;
    private String descricao_pro;
    private int desconto_pro;
    private int id_usu;
    private Date dthr_atualizacao;
        
    /** Creates a new instance of Promocao */
    public Promocao( int id_pro, int id_prod,
                    String descricao_pro, int desconto_pro,
                    int id_usu,
                    Date dthr_atualizacao
                    ) {
        this.setId_prod(id_prod);
        this.setId_pro(id_pro);
        this.setDescricao_pro(descricao_pro);
        this.setDesconto_pro(desconto_pro);
        this.setId_usu(id_usu);
        this.setDthr_atualizacao(dthr_atualizacao);

    }
public Promocao( int id_pro, int id_prod,
                    String descricao_pro, int desconto_pro,
                    int id_usu
                    ) {
        this.setId_prod(id_prod);
        this.setId_pro(id_pro);
        this.setDescricao_pro(descricao_pro);
        this.setDesconto_pro(desconto_pro);
        this.setId_usu(id_usu);
    }

public Promocao( int id_prod
                    ) {
        this.setId_prod(id_prod);
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }
    
    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }
    
    public int getDesconto_pro() {
        return desconto_pro;
    }

    public void setDesconto_pro(int desconto_pro) {
        this.desconto_pro = desconto_pro;
    }

    public String getDescricao_pro() {
        return descricao_pro;
    }

    public void setDescricao_pro(String descricao_pro) {
        this.descricao_pro = descricao_pro;
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
