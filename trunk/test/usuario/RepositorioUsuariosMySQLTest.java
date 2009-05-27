/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario;

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
public class RepositorioUsuariosMySQLTest {

    Usuario usuario;

    

    public RepositorioUsuariosMySQLTest() {

        this.usuario = new Usuario(123, "Jackson Five", "jackson", "senha", 001, "online");
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
     * Test of procurar method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id = this.usuario.getId_usu();
        int tipo = 0;
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        Usuario expResult = this.usuario;
        Usuario result = instance.procurar(id, tipo);
        assertEquals(expResult, result);

    }

    /**
     * Test of atualizar method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        instance.atualizar(usuario);
    }

    /**
     * Test of existe method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testExiste() throws Exception {
        System.out.println("existe");
        int id_usu = this.usuario.getId_usu();
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        boolean expResult = false;
        boolean result = instance.existe(id_usu);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeLogin method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testExisteLogin() throws Exception {
        System.out.println("existeLogin");
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        boolean expResult = false;
        boolean result = instance.existeLogin(this.usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of inserir method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        instance.inserir(usuario);

    }

    /**
     * Test of procurarUsuarios method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testProcurarUsuarios() throws Exception {
        System.out.println("procurarUsuarios");
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        Collection expResult = null;
        Collection result = instance.procurarUsuarios();
        assertEquals(expResult, result);

    }

    /**
     * Test of remover method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testRemover_Usuario() throws Exception {
        System.out.println("remover");
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        boolean expResult = false;
        boolean result = instance.remover(this.usuario);
        assertEquals(expResult, result);

    }

    /**
     * Test of remover method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testRemover_int() throws Exception {
        System.out.println("remover");
        int id_us = this.usuario.getId_usu();
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        boolean expResult = false;
        boolean result = instance.remover(id_us);
        assertEquals(expResult, result);

    }

    /**
     * Test of liberarAcesso method, of class RepositorioUsuariosMySQL.
     */
    @Test
    public void testLiberarAcesso() throws Exception {
        System.out.println("liberarAcesso");
        String login_usu = this.usuario.getLogin_usu();
        String senha_usu = this.usuario.getSenha_usu();
        RepositorioUsuariosMySQL instance = new RepositorioUsuariosMySQL();
        int expResult = 0;
        int result = instance.liberarAcesso(login_usu, senha_usu);
        assertEquals(expResult, result);
    }

}