/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estoque;

import java.util.Collection;
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
public class CadastroEstoquesTest {

    public CadastroEstoquesTest() {
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
     * Test of procurar method, of class CadastroEstoques.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = 0;
        CadastroEstoques instance = null;
        Estoque expResult = null;
        Estoque result = instance.procurar(id_prod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class CadastroEstoques.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Estoque estoque = null;
        CadastroEstoques instance = null;
        instance.inserir(estoque);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class CadastroEstoques.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Estoque estoque = null;
        CadastroEstoques instance = null;
        instance.atualizar(estoque);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remover method, of class CadastroEstoques.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        int id_prod = 0;
        CadastroEstoques instance = null;
        boolean expResult = false;
        boolean result = instance.remover(id_prod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarEstoque method, of class CadastroEstoques.
     */
    @Test
    public void testProcurarEstoque() throws Exception {
        System.out.println("procurarEstoque");
        CadastroEstoques instance = null;
        Collection expResult = null;
        Collection result = instance.procurarEstoque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}