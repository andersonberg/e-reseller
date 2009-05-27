/*
 * Teste de unidade em RepositorioProdutos
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
public class RepositorioProdutosTest {

    Produto produto;
    RepositorioProdutos repositorioProdutos;

    public RepositorioProdutosTest() throws Exception {

        this.repositorioProdutos = new RepositorioProdutosMySQL();
        this.produto = new Produto(1, "Descricao", "Livro", "20x20", "400", "Didático", 230);
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
     * Test of inserir method, of class RepositorioProdutos.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        this.repositorioProdutos.inserir(this.produto);
          }

    /**
     * Test of atualizar method, of class RepositorioProdutos.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Produto produtoLocal = this.produto;
        produtoLocal.setDescricao_prod("Modificado");
        this.repositorioProdutos.atualizar(produto);
        }

    /**
     * Test of procurar method, of class RepositorioProdutos.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = this.produto.getId_prod();
        Produto expResult = this.produto;
        Produto result = repositorioProdutos.procurar(id_prod);
        assertEquals(expResult, result);
    }

    /**
     * Test of remover method, of class RepositorioProdutos.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        boolean expResult = false;
        boolean result = repositorioProdutos.remover(produto);
        assertEquals(expResult, result);
    }

    /**
     * Test of procurarProdutos method, of class RepositorioProdutos.
     */
    @Test
    public void testProcurarProdutos() throws Exception {
        System.out.println("procurarProdutos");
        Collection expResult = null;
        Collection result = repositorioProdutos.procurarProdutos();
        assertEquals(expResult, result);
    }

}