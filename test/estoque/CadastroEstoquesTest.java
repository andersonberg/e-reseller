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
public class CadastroEstoquesTest {

    Estoque estoque;
    RepositorioEstoques repositorioEstoques;
    CadastroEstoques cadastroEstoques;

    public CadastroEstoquesTest() throws Exception {
        this.repositorioEstoques = new RepositorioEstoquesMySQL();
        this.cadastroEstoques = new CadastroEstoques(repositorioEstoques);
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
     * Test of procurar method, of class CadastroEstoques.
     */
    @Ignore
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = 12;
        Estoque esperado = this.estoque;
        Estoque result = this.cadastroEstoques.procurar(id_prod);
        assertEquals(esperado.getId_est(), result.getId_est());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class CadastroEstoques.
     */
    @Ignore
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        this.cadastroEstoques.inserir(this.estoque);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class CadastroEstoques.
     */
    @Ignore
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Estoque estoqueLocal = this.estoque;
        estoqueLocal.setQuantidade_est(50);
        this.cadastroEstoques.atualizar(estoqueLocal);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of remover method, of class CadastroEstoques.
     */
//    @Ignore
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        int id_prod = this.estoque.getId_prod();
        boolean esperado = true;
        boolean result = this.cadastroEstoques.remover(id_prod);
        assertEquals(esperado, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of procurarEstoque method, of class CadastroEstoques.
     */
    @Ignore
    @Test
    public void testProcurarEstoque() throws Exception {
        System.out.println("procurarEstoque");
        CadastroEstoques instance = null;
        Collection expResult = null;
        Collection result = instance.procurarEstoque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}