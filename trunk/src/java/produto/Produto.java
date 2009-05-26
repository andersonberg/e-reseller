package produto;

import java.sql.Date;

public class Produto {
    
    private int id_prod;
    private String descricao_prod;
    private String caracteristicas_prod;
    private String dimensao_prod;
    private String peso_prod;
    private String espec_tecnicas_prod;
    private int id_usu;
    private Date dthr_atualizacao;
        
    /** Creates a new instance of Produto */
    public Produto( int id_prod, 
                    String descricao_prod,
                    String caracteristicas_prod,
                    String dimensao_prod,
                    String peso_prod,
                    String espec_tecnicas_prod,
                    int id_usu,
                    Date dthr_atualizacao
                    ) {
        this.setId_prod(id_prod);
        this.setDescricao_prod(descricao_prod);
        this.setCaracteristicas_prod(caracteristicas_prod);
        this.setDimensao_prod(dimensao_prod);
        this.setPeso_prod(peso_prod);
        this.setEspec_tecnicas(espec_tecnicas_prod);
        this.setId_usu(id_usu);
        this.setDthr_atualizacao(dthr_atualizacao);
    }
public Produto( int id_prod, 
                    String descricao_prod,
                    String caracteristicas_prod,
                    String dimensao_prod,
                    String peso_prod,
                    String espec_tecnicas_prod,
                    int id_usu
                    ) {
        this.setId_prod(id_prod);
        this.setDescricao_prod(descricao_prod);
        this.setCaracteristicas_prod(caracteristicas_prod);
        this.setDimensao_prod(dimensao_prod);
        this.setPeso_prod(peso_prod);
        this.setEspec_tecnicas(espec_tecnicas_prod);
        this.setId_usu(id_usu);
    }
    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getDescricao_prod() {
        return descricao_prod;
    }

    public void setDescricao_prod(String descricao_prod) {
        this.descricao_prod = descricao_prod;
    }
     public String getCaracteristicas_prod() {
        return caracteristicas_prod;
    }

    public void setCaracteristicas_prod(String caracteristicas_prod) {
        this.caracteristicas_prod = caracteristicas_prod;
    }
    public String getDimensao_prod() {
        return dimensao_prod;
    }

    public void setDimensao_prod(String dimensao_prod) {
        this.dimensao_prod = dimensao_prod;
    }
    
     public String getPeso_prod() {
        return peso_prod;
    }

    public void setPeso_prod(String peso_prod) {
        this.peso_prod = peso_prod;
    }
    
     public String getEspec_tecnicas_prod() {
        return espec_tecnicas_prod;
    }

    public void setEspec_tecnicas(String espec_tecnicas_prod) {
        this.espec_tecnicas_prod = espec_tecnicas_prod;
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
