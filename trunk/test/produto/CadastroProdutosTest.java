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
public class CadastroProdutosTest {

    Produto produto;
    CadastroProdutos cadastroProdutos;
    
    public CadastroProdutosTest() throws  Exception  {

        RepositorioProdutos repositorioProdutos = new RepositorioProdutosMySQL();
        cadastroProdutos = new CadastroProdutos(repositorioProdutos);
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
     * Test of procurar method, of class CadastroProdutos.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = produto.getId_prod();
        Produto expResult = this.produto;
        Produto result = this.cadastroProdutos.procurar(id_prod);
        assertEquals(expResult, result);
    }

    /**
     * Test of inserir method, of class CadastroProdutos.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Produto produtoEsperado = this.produto;
        int result = this.cadastroProdutos.inserir(produto);
        assertEquals(produtoEsperado, result);
    }

    /**
     * Test of atualizar method, of class CadastroProdutos.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Produto produtoLocal = this.produto;
        produtoLocal.setDimensao_prod("20x5");
        this.cadastroProdutos.atualizar(produtoLocal);
    }

    /**
     * Test of remover method, of class CadastroProdutos.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        boolean expResult = false;
        boolean result = this.cadastroProdutos.remover(produto);
        assertEquals(expResult, result);
    }

    /**
     * Test of procurarProdutos method, of class CadastroProdutos.
     */
    @Test
    public void testProcurarProdutos() throws Exception {
        System.out.println("procurarProdutos");
        Collection expResult = null;
        Collection result = this.cadastroProdutos.procurarProdutos();
        assertEquals(expResult, result);
    }

}