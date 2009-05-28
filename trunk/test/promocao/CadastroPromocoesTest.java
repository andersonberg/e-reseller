/*
 * Teste unitário na Classe de CadastroPromocoes
 */

package promocao;

import java.util.Collection;
import java.util.Date;
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
public class CadastroPromocoesTest {

    CadastroPromocoes cadastroPromocoes;
    RepositorioPromocoes repositorioPromocoes;
    Promocao promocao;

    public CadastroPromocoesTest() throws Exception{

        this.cadastroPromocoes = new CadastroPromocoes(repositorioPromocoes);
        this.promocao = new Promocao(001, 0035, "Poker Black", 004, 15, java.sql.Date.valueOf("2009-05-05"));
        this.repositorioPromocoes = new RepositorioPromocoesMySQL();

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
     * Test of procurar method, of class CadastroPromocoes.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_prod = 0;
        //CadastroPromocoes instance = null;
        Promocao expResult = null;
        Promocao result = this.repositorioPromocoes.procurar(id_prod);
        assertEquals(expResult, result);
    }

    /**
     * Test of inserir method, of class CadastroPromocoes.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        repositorioPromocoes.inserir(promocao);
    }

    /**
     * Test of atualizar method, of class CadastroPromocoes.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Promocao promocaoLocal = promocao;
        promocaoLocal.setId_prod(23);
        repositorioPromocoes.atualizar(promocaoLocal);

    }

    /**
     * Test of remover method, of class CadastroPromocoes.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        boolean expResult = false;
        boolean result = this.repositorioPromocoes.remover(this.promocao);
        assertEquals(expResult, result);

    }

    /**
     * Test of procurarPromocoes method, of class CadastroPromocoes.
     */
    @Test
    public void testProcurarPromocoes_0args() throws Exception {
        System.out.println("procurarPromocoes");
        Collection expResult = null;
        Collection result = repositorioPromocoes.procurarPromocoes();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of procurarPromocoes method, of class CadastroPromocoes.
     */
    @Test
    public void testProcurarPromocoes_Promocao() throws Exception {
        System.out.println("procurarPromocoes");
        Collection expResult = (Collection)promocao;
        Collection result = repositorioPromocoes.procurarPromocoes(this.promocao);
        assertEquals(expResult, result);

    }

}