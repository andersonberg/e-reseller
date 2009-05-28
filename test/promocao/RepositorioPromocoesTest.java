/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package promocao;

import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hélio Bentzen
 */
public class RepositorioPromocoesTest {

    RepositorioPromocoes repositorioPromocoes;
    Promocao promocao;

    public RepositorioPromocoesTest() throws Exception{
        
        this.repositorioPromocoes = new RepositorioPromocoesMySQL();
        this.promocao = new Promocao(001, 00345, "Azeite de Oliva", 0005, 007, java.sql.Date.valueOf("2009-11-11"));    

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
     * Test of inserir method, of class RepositorioPromocoes.
     */
    @Ignore
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        repositorioPromocoes.inserir(this.promocao);
    }

    /**
     * Test of atualizar method, of class RepositorioPromocoes.
     */
   @Ignore
   @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Promocao promocaoLocal = this.promocao;
        promocaoLocal.setDescricao_pro("Gibi da Turma da Monica");
        this.repositorioPromocoes.atualizar(promocaoLocal);

    }

    /**
     * Test of procurar method, of class RepositorioPromocoes.
     */
    @Ignore
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = this.promocao.getId_prod();
        Promocao expResult = this.promocao;
        Promocao result = repositorioPromocoes.procurar(id_prod);
        assertEquals(expResult, result);

    }

    /**
     * Test of remover method, of class RepositorioPromocoes.
     */
    @Ignore
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        boolean expResult = false;
        boolean result = repositorioPromocoes.remover(this.promocao);
        assertEquals(expResult, result);

    }

    /**
     * Test of procurarPromocoes method, of class RepositorioPromocoes.
     */
    @Ignore
    @Test
    public void testProcurarPromocoes_0args() throws Exception {
        System.out.println("procurarPromocoes");
        Collection expResult = null;
        Collection result = repositorioPromocoes.procurarPromocoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of procurarPromocoes method, of class RepositorioPromocoes.
     */
    @Ignore
    @Test
    public void testProcurarPromocoes_Promocao() throws Exception {
        System.out.println("procurarPromocoes");
        Collection expResult = null;
        Collection result = repositorioPromocoes.procurarPromocoes(promocao);
        assertEquals(expResult, result);

    }

}