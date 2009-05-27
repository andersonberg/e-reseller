/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produto;

import java.util.Collection;
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
public class RepositorioProdutosMySQLTest {

    Produto produto;

    public RepositorioProdutosMySQLTest() {

        this.produto = new Produto(1, "Harry Potter", "Livro", "20x14", "300", "Ficcao", 123);
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
     * Test of procurar method, of class RepositorioProdutosMySQL.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = this.produto.getId_prod();
        RepositorioProdutosMySQL instance = new RepositorioProdutosMySQL();
        Produto expResult = this.produto;
        Produto result = instance.procurar(id_prod);
        assertEquals(expResult, result);
    }

    /**
     * Test of atualizar method, of class RepositorioProdutosMySQL.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Produto produtoLocal = this.produto;
        produtoLocal.setDescricao_prod("Mudado");
        RepositorioProdutosMySQL instance = new RepositorioProdutosMySQL();
        instance.atualizar(produto);
    }

    /**
     * Test of inserir method, of class RepositorioProdutosMySQL.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Produto produto = this.produto;
        RepositorioProdutosMySQL instance = new RepositorioProdutosMySQL();
        int expResult = 0;
        int result = instance.inserir(produto);
        assertEquals(expResult, result);

    }

    /**
     * Test of procurarProdutos method, of class RepositorioProdutosMySQL.
     */
    @Test
    public void testProcurarProdutos() throws Exception {
        System.out.println("procurarProdutos");
        RepositorioProdutosMySQL instance = new RepositorioProdutosMySQL();
        Collection expResult = null;
        Collection result = instance.procurarProdutos();
        assertEquals(expResult, result);

    }

    /**
     * Test of remover method, of class RepositorioProdutosMySQL.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        Produto produto = null;
        RepositorioProdutosMySQL instance = new RepositorioProdutosMySQL();
        boolean expResult = false;
        boolean result = instance.remover(this.produto);
        assertEquals(expResult, result);

    }

}