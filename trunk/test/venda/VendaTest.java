/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package venda;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 *
 * @author Anderson Berg
 */
public class VendaTest {

    Venda venda;
    
    public VendaTest() {
        venda = new Venda(1, 12, 1, 10, 1000, "3", 1);
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
     * Test of getId_ven method, of class Venda.
     */
    @Test
    public void testGetId_ven() {
        System.out.println("getId_ven");
        int esperado = 1;
        int resultado = this.venda.getId_ven();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_ven method, of class Venda.
     */
    @Test
    public void testSetId_ven() {
        System.out.println("setId_ven");
        int id_ven = 2;
        this.venda.setId_ven(id_ven);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_prod method, of class Venda.
     */
    @Test
    public void testGetId_prod() {
        System.out.println("getId_prod");
        int esperado = 12;
        int resultado = this.venda.getId_prod();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_prod method, of class Venda.
     */
    @Test
    public void testSetId_prod() {
        System.out.println("setId_prod");
        int id_prod = 1;
        this.venda.setId_prod(id_prod);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_cli method, of class Venda.
     */
    @Test
    public void testGetId_cli() {
        System.out.println("getId_cli");
        int esperado = 1;
        int resultado = this.venda.getId_cli();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_cli method, of class Venda.
     */
    @Test
    public void testSetId_cli() {
        System.out.println("setId_cli");
        int id_cli = 2;
        this.venda.setId_cli(id_cli);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getQtd_ven method, of class Venda.
     */
    @Test
    public void testGetQtd_ven() {
        System.out.println("getQtd_ven");
        int esperado = 10;
        int resultado = this.venda.getQtd_ven();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setQtd_ven method, of class Venda.
     */
    @Test
    public void testSetQtd_ven() {
        System.out.println("setQtd_ven");
        int qtd_ven = 20;
        this.venda.setQtd_ven(qtd_ven);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getValor_ven method, of class Venda.
     */
    @Test
    public void testGetValor_ven() {
        System.out.println("getValor_ven");
        float esperado = 1000.0F;
        float resultado = this.venda.getValor_ven();
        assertEquals(esperado, resultado, 0.0F);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setValor_ven method, of class Venda.
     */
    @Test
    public void testSetValor_ven() {
        System.out.println("setValor_ven");
        float valor_ven = 2000.0F;
        this.venda.setValor_ven(valor_ven);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrazo_ven method, of class Venda.
     */
    @Test
    public void testGetPrazo_ven() {
        System.out.println("getPrazo_ven");
        String esperado = "3";
        String resultado = this.venda.getPrazo_ven();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrazo_ven method, of class Venda.
     */
    @Test
    public void testSetPrazo_ven() {
        System.out.println("setPrazo_ven");
        String prazo_ven = "5";
        this.venda.setPrazo_ven(prazo_ven);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_usu method, of class Venda.
     */
    @Test
    public void testGetId_usu() {
        System.out.println("getId_usu");
        int esperado = 1;
        int resultado = this.venda.getId_usu();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_usu method, of class Venda.
     */
    @Test
    public void testSetId_usu() {
        System.out.println("setId_usu");
        int id_usu = 2;
        this.venda.setId_usu(id_usu);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDthr_atualizacao method, of class Venda.
     */
    @Test
    public void testGetDthr_atualizacao() {
        System.out.println("getDthr_atualizacao");
        String data = (new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        Venda novaVenda = new Venda(1, 12, 1, 10, 1000, "3", 1, Date.valueOf(data));
        Date esperado = Date.valueOf(data);
        Date resultado = novaVenda.getDthr_atualizacao();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDthr_atualizacao method, of class Venda.
     */
    @Test
    public void testSetDthr_atualizacao() {
        System.out.println("setDthr_atualizacao");
        String data = (new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        Date dthr_atualizacao = Date.valueOf(data);
        Venda novaVenda = new Venda(1, 12, 1, 10, 1000, "3", 1, dthr_atualizacao);
        novaVenda.setDthr_atualizacao(dthr_atualizacao);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}