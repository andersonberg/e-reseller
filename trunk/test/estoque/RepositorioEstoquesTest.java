/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estoque;

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
public class RepositorioEstoquesTest {

    Estoque estoque;
    RepositorioEstoques repositorioEstoques;

    public RepositorioEstoquesTest() throws  Exception {
        this.repositorioEstoques = new RepositorioEstoquesMySQL();
        String data = (new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        this.estoque = new Estoque(1, 12, 40, 300.0F, 1, Date.valueOf(data));
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
     * Test of inserir method, of class RepositorioEstoques.
     */
    @Ignore
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        this.repositorioEstoques.inserir(this.estoque);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class RepositorioEstoques.
     */
    @Ignore
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Estoque estoqueLocal = this.estoque;
        estoqueLocal.setQuantidade_est(50);
        this.repositorioEstoques.atualizar(estoqueLocal);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of procurar method, of class RepositorioEstoques.
     */
    @Ignore
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = 12;
//        int novoId = this.estoque.getId_est();
        Estoque esperado = this.estoque;
//        esperado.setId_est(novoId + 1);
        Estoque result = this.repositorioEstoques.procurar(id_prod);
        assertEquals(esperado.getId_est(), result.getId_est());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarEstoque method, of class RepositorioEstoques.
     */
    @Ignore
    @Test
    public void testProcurarEstoque() throws Exception {
        System.out.println("procurarEstoque");
        Collection expResult = null;
        Collection result = this.repositorioEstoques.procurarEstoque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of remover method, of class RepositorioEstoques.
     */
    @Ignore
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        int id_prod = this.estoque.getId_prod();
        boolean esperado = true;
        boolean result = this.repositorioEstoques.remover(id_prod);
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}