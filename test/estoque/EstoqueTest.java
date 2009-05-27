/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estoque;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anderson Berg
 */
public class EstoqueTest {

    Estoque estoque;
    String data;

    public EstoqueTest() {
        this.data = (new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        this.estoque = new Estoque(1, 12, 34, 120, 1, Date.valueOf(data));
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
     * Test of getId_est method, of class Estoque.
     */
    @Test
    public void testGetId_est() {
        System.out.println("getId_est");
        int esperado = 1;
        int result = this.estoque.getId_est();
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId_est method, of class Estoque.
     */
    @Test
    public void testSetId_est() {
        System.out.println("setId_est");
        int id_est = 15;
        this.estoque.setId_est(id_est);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId_prod method, of class Estoque.
     */
    @Test
    public void testGetId_prod() {
        System.out.println("getId_prod");
        int esperado = 12;
        int result = this.estoque.getId_prod();
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_prod method, of class Estoque.
     */
    @Test
    public void testSetId_prod() {
        System.out.println("setId_prod");
        int id_prod = 11;
        this.estoque.setId_prod(id_prod);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidade_est method, of class Estoque.
     */
    @Test
    public void testGetQuantidade_est() {
        System.out.println("getQuantidade_est");
        int esperado = 34;
        int result = this.estoque.getQuantidade_est();
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantidade_est method, of class Estoque.
     */
    @Test
    public void testSetQuantidade_est() {
        System.out.println("setQuantidade_est");
        int quantidade_est = 55;
        this.estoque.setQuantidade_est(quantidade_est);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getValor_prod_est method, of class Estoque.
     */
    @Test
    public void testGetValor_prod_est() {
        System.out.println("getValor_prod_est");
        float esperado = 120.0F;
        float result = this.estoque.getValor_prod_est();
        assertEquals(esperado, result, 0.0F);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setValor_prod_est method, of class Estoque.
     */
    @Test
    public void testSetValor_prod_est() {
        System.out.println("setValor_prod_est");
        float valor_prod_est = 130.0F;
        this.estoque.setValor_prod_est(valor_prod_est);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_usu method, of class Estoque.
     */
    @Test
    public void testGetId_usu() {
        System.out.println("getId_usu");
        int esperado = 1;
        int result = this.estoque.getId_usu();
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_usu method, of class Estoque.
     */
    @Test
    public void testSetId_usu() {
        System.out.println("setId_usu");
        int id_usu = 2;
        this.estoque.setId_usu(id_usu);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDthr_atualizacao method, of class Estoque.
     */
    @Test
    public void testGetDthr_atualizacao() {
        System.out.println("getDthr_atualizacao");
        Date esperada = Date.valueOf(this.data);
        Date result = this.estoque.getDthr_atualizacao();
        assertEquals(esperada, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDthr_atualizacao method, of class Estoque.
     */
    @Test
    public void testSetDthr_atualizacao() {
        System.out.println("setDthr_atualizacao");
        Date dthr_atualizacao = Date.valueOf(new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        this.estoque.setDthr_atualizacao(dthr_atualizacao);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}