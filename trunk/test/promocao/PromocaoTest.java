/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package promocao;

import java.sql.Date;
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
public class PromocaoTest {



    public PromocaoTest() {
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
     * Test of getId_pro method, of class Promocao.
     */
    @Test
    public void testGetId_pro() {
        System.out.println("getId_pro");
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        int expResult = 001;
        int result = promocao.getId_pro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_pro method, of class Promocao.
     */
    @Test
    public void testSetId_pro() {
        System.out.println("setId_pro");
        int id_pro = 002;
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        promocao.setId_pro(id_pro);

    }

    /**
     * Test of getId_prod method, of class Promocao.
     */
    @Test
    public void testGetId_prod() {
        System.out.println("getId_prod");
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        int expResult = 0345;
        int result = promocao.getId_prod();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId_prod method, of class Promocao.
     */
    @Test
    public void testSetId_prod() {
        System.out.println("setId_prod");
        int id_prod = 0346;
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        promocao.setId_prod(id_prod);

    }

    /**
     * Test of getDesconto_pro method, of class Promocao.
     */
    @Test
    public void testGetDesconto_pro() {
        System.out.println("getDesconto_pro");
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        int expResult = 001;
        int result = promocao.getDesconto_pro();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDesconto_pro method, of class Promocao.
     */
    @Test
    public void testSetDesconto_pro() {
        System.out.println("setDesconto_pro");
        int desconto_pro = 003;
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        promocao.setDesconto_pro(desconto_pro);
    }

    /**
     * Test of getDescricao_pro method, of class Promocao.
     */
    @Test
    public void testGetDescricao_pro() {
        System.out.println("getDescricao_pro");
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        String expResult = "Liquidificador Arno";
        String result = promocao.getDescricao_pro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao_pro method, of class Promocao.
     */
    @Test
    public void testSetDescricao_pro() {
        System.out.println("setDescricao_pro");
        String descricao_pro = "Batedeira Pirunanga";
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        promocao.setDescricao_pro(descricao_pro);
    }

    /**
     * Test of getId_usu method, of class Promocao.
     */
    @Test
    public void testGetId_usu() {
        System.out.println("getId_usu");
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 0013, 002, Date.valueOf("2009-05-23"));
        int expResult = 002;
        int result = promocao.getId_usu();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId_usu method, of class Promocao.
     */
    @Test
    public void testSetId_usu() {
        System.out.println("setId_usu");
        int id_usu = 004;
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        promocao.setId_usu(id_usu);

    }

    /**
     * Test of getDthr_atualizacao method, of class Promocao.
     */
    @Test
    public void testGetDthr_atualizacao() {
        System.out.println("getDthr_atualizacao");
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        Date expResult = Date.valueOf("2009-05-23");
        Date result = promocao.getDthr_atualizacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDthr_atualizacao method, of class Promocao.
     */
    @Test
    public void testSetDthr_atualizacao() {
        System.out.println("setDthr_atualizacao");
        Date dthr_atualizacao = Date.valueOf("2009-12-12");
        Promocao promocao = new Promocao(001, 0345, "Liquidificador Arno", 001, 002, Date.valueOf("2009-05-23"));
        promocao.setDthr_atualizacao(dthr_atualizacao);
    }

}