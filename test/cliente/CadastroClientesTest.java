/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

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
public class CadastroClientesTest {

    CadastroClientes cadastroClientes;
    Cliente cliente;

    public CadastroClientesTest() throws  Exception {
        RepositorioClientes repositorioClientes = new RepositorioClientesMySQL();
        cadastroClientes = new CadastroClientes(repositorioClientes);
        String data = (new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        cliente = new Cliente(1, "Loja", "Rua Nova", 11, Date.valueOf(data));
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp(){
    }

    @After
    public void tearDown() {
    }

     /**
     * Test of inserir method, of class CadastroClientes.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Cliente clienteEsperado = this.cliente;
        this.cadastroClientes.inserir(clienteEsperado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of procurar method, of class CadastroClientes.
     */
    @Ignore
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_cli = cliente.getId_cli();
        Cliente esperado = this.cliente;
        Cliente resultado = this.cadastroClientes.procurar(id_cli);
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of atualizar method, of class CadastroClientes.
     */
    @Ignore
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Cliente clienteLocal = this.cliente;
        clienteLocal.setNome_cli("Loja Nova");
        this.cadastroClientes.atualizar(clienteLocal);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of procurarClientes method, of class CadastroClientes.
     */
    @Ignore
    @Test
    public void testProcurarClientes() throws Exception {
        System.out.println("procurarClientes");
        Collection expResult = null;
        Collection result = this.cadastroClientes.procurarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of remover method, of class CadastroClientes.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        boolean expResult = false;
        boolean result = this.cadastroClientes.remover(this.cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}