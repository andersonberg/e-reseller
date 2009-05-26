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
public class RepositorioClienteTest {

    Cliente cliente;
    RepositorioClientes repositorioClientes;
    
    public RepositorioClienteTest() throws Exception {
        this.repositorioClientes = new RepositorioClientesMySQL();
        String data = (new java.text.SimpleDateFormat("yyyy-mm-dd").format(new java.util.Date(System.currentTimeMillis())));
        this.cliente = new Cliente(1, "Loja", "Rua Nova", 11, Date.valueOf(data));
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
     * Test of inserir method, of class RepositorioCliente.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        this.repositorioClientes.inserir(this.cliente);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class RepositorioCliente.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Cliente clienteLocal = this.cliente;
        clienteLocal.setNome_cli("Loja Nova");
        this.repositorioClientes.atualizar(clienteLocal);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of procurar method, of class RepositorioCliente.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id_cli = this.cliente.getId_cli();
        Cliente esperado = this.cliente;
        Cliente resultado = this.repositorioClientes.procurar(id_cli);
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remover method, of class RepositorioCliente.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("remover");
        boolean esperado = false;
        boolean resultado = this.repositorioClientes.remover(this.cliente);
        assertEquals(esperado, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of procurarClientes method, of class RepositorioCliente.
     */
    @Ignore
    @Test
    public void testProcurarClientes() throws Exception {
        System.out.println("procurarClientes");
        Collection expResult = null;
        Collection result = this.repositorioClientes.procurarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}