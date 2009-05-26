/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

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
public class ClienteTest {

    public ClienteTest() {
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
     * Test of getId_cli method, of class Cliente.
     */
    @Test
    public void testGetId_cli() throws Exception{
        System.out.println("getId_cli");
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        int esperado = 1;
        int result = cliente.getId_cli();
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail();
    }

    /**
     * Test of setId_cli method, of class Cliente.
     */
    @Test
    public void testSetId_cli() {
        System.out.println("setId_cli");
        int id_cli = 2;
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        cliente.setId_cli(id_cli);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNome_cli method, of class Cliente.
     */
    @Test
    public void testGetNome_cli() {
        System.out.println("getNome_cli");
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        String esperado = "Loja";
        String resultado = cliente.getNome_cli();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNome_cli method, of class Cliente.
     */
    @Test
    public void testSetNome_cli() {
        System.out.println("setNome_cli");
        String nome_cli = "Loja2";
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        cliente.setNome_cli(nome_cli);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEndereco_cli method, of class Cliente.
     */
    @Test
    public void testGetEndereco_cli() {
        System.out.println("getEndereco_cli");
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        String esperado = "Avenida";
        String resultado = cliente.getEndereco_cli();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEndereco_cli method, of class Cliente.
     */
    @Test
    public void testSetEndereco_cli() {
        System.out.println("setEndereco_cli");
        String endereco_cli = "Rua Nova";
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        cliente.setEndereco_cli(endereco_cli);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId_usu method, of class Cliente.
     */
    @Test
    public void testGetId_usu() {
        System.out.println("getId_usu");
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        int esperado = 11;
        int resultado = cliente.getId_usu();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId_usu method, of class Cliente.
     */
    @Test
    public void testSetId_usu() {
        System.out.println("setId_usu");
        int id_usu = 0;
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11);
        cliente.setId_usu(id_usu);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDthr_atualizacao method, of class Cliente.
     */
    @Test
    public void testGetDthr_atualizacao() {
        System.out.println("getDthr_atualizacao");
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11, Date.valueOf("2009-05-23"));
        Date esperado = Date.valueOf("2009-05-23");
        Date resultado = cliente.getDthr_atualizacao();
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDthr_atualizacao method, of class Cliente.
     */
    @Test
    public void testSetDthr_atualizacao() {
        System.out.println("setDthr_atualizacao");
        Date dthr_atualizacao = Date.valueOf("2008-06-22");
        Cliente cliente = new Cliente(1, "Loja", "Avenida", 11, Date.valueOf("2009-05-23"));
        cliente.setDthr_atualizacao(dthr_atualizacao);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}