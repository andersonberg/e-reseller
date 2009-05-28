/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package promocao;

import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hélio Bentzen
 */
public class RepositorioPromocoesMySQLTest {

    Promocao promocao;
    RepositorioPromocoesMySQL repositorioPromocoes;
    

    public RepositorioPromocoesMySQLTest()  throws Exception {

       this.promocao = new Promocao(001, 0123, "Caixa de Chocolate", 0010, 00007, java.sql.Date.valueOf("11-11-2009"));
       this.repositorioPromocoes = new RepositorioPromocoesMySQL();

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of procurar method, of class RepositorioPromocoesMySQL.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_pro = 0;
        Promocao expResult = null;
        Promocao result = repositorioPromocoes.procurar(id_pro);
        assertEquals(expResult, result);
    }

    /**
     * Test of atualizar method, of class RepositorioPromocoesMySQL.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Promocao promocao = null;
        repositorioPromocoes.atualizar(promocao);

        
    }

    /**
     * Test of inserir method, of class RepositorioPromocoesMySQL.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Promocao promocao = null;
        repositorioPromocoes.inserir(promocao);

        
    }

    /**
     * Test of procurarPromocoes method, of class RepositorioPromocoesMySQL.
     */
    @Test
    public void testProcurarPromocoes_0args() throws Exception {
        System.out.println("procurarPromocoes");
        Collection expResult = null;
        Collection result = repositorioPromocoes.procurarPromocoes();
        assertEquals(expResult, result);

        
    }

    /**
     * Test of procurarPromocoes method, of class RepositorioPromocoesMySQL.
     */
    @Test
    public void testProcurarPromocoes_Promocao() throws Exception {
        System.out.println("procurarPromocoes");
       // Promocao promocao = null;
        Collection expResult = null;
        Collection result = repositorioPromocoes.procurarPromocoes(promocao);
        assertEquals(expResult, result);

        
    }

    /**
     * Test of remover method, of class RepositorioPromocoesMySQL.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        //Promocao promocao = null;
        boolean expResult = false;
        boolean result = repositorioPromocoes.remover(promocao);
        assertEquals(expResult, result);

        
    }

}