/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package venda;

import java.sql.Date;
import java.util.Collection;
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
public class RepositorioVendasMySQLTest {

    Venda venda;
    RepositorioVendasMySQL repositorioVendas;

    public RepositorioVendasMySQLTest() throws Exception {
        String data = (new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        this.venda = new Venda(1, 1, 1, 10, 1000, "3 meses", 1, Date.valueOf(data));
        this.repositorioVendas = new RepositorioVendasMySQL();
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
     * Test of procurar method, of class RepositorioVendasMySQL.
     */
    @Ignore
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id = 12;
        int tipo = 2;
        Venda esperado = this.venda;
        Venda result = this.repositorioVendas.procurar(id, tipo);
        assertEquals(esperado.getId_ven(), result.getId_ven());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class RepositorioVendasMySQL.
     */
    @Ignore
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        this.repositorioVendas.inserir(this.venda);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarVendas method, of class RepositorioVendasMySQL.
     */
    @Ignore
    @Test
    public void testProcurarVendas_int_int() throws Exception {
        System.out.println("procurarVendas");
        int id = 0;
        int tipo = 0;
        RepositorioVendasMySQL instance = new RepositorioVendasMySQL();
        Collection expResult = null;
        Collection result = instance.procurarVendas(id, tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarVendas method, of class RepositorioVendasMySQL.
     */
    @Ignore
    @Test
    public void testProcurarVendas_4args() throws Exception {
        System.out.println("procurarVendas");
        int id_prod = 0;
        int id_cli = 0;
        String dtInicial = "";
        String dtFinal = "";
        RepositorioVendasMySQL instance = new RepositorioVendasMySQL();
        Collection expResult = null;
        Collection result = instance.procurarVendas(id_prod, id_cli, dtInicial, dtFinal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remover method, of class RepositorioVendasMySQL.
     */
//    @Ignore
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        boolean esperado = true;
        boolean result = this.repositorioVendas.remover(this.venda);
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}