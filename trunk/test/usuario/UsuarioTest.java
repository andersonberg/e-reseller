/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario;

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
public class UsuarioTest {

    public UsuarioTest() {
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
     * Test of getId_usu method, of class Usuario.
     */
    @Test
    public void testGetId_usu() {
        System.out.println("getId_usu");
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        int expResult = 123;
        int result = usuario.getId_usu();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId_usu method, of class Usuario.
     */
    @Test
    public void testSetId_usu() {
        System.out.println("setId_usu");
        int id_usu = 0;
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        usuario.setId_usu(id_usu);

    }

    /**
     * Test of getId_cli method, of class Usuario.
     */
    @Test
    public void testGetId_cli() {
        System.out.println("getId_cli");
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        int expResult = 001;
        int result = usuario.getId_cli();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId_cli method, of class Usuario.
     */
    @Test
    public void testSetId_cli() {
        System.out.println("setId_cli");
        int id_cli = 002;
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        usuario.setId_cli(id_cli);

    }

    /**
     * Test of getNome_usu method, of class Usuario.
     */
    @Test
    public void testGetNome_usu() {
        System.out.println("getNome_usu");
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        String expResult = "Davi";
        String result = usuario.getNome_usu();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNome_usu method, of class Usuario.
     */
    @Test
    public void testSetNome_usu() {
        System.out.println("setNome_usu");
        String nome_usu = "Manoel";
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        usuario.setNome_usu(nome_usu);

    }

    /**
     * Test of getLogin_usu method, of class Usuario.
     */
    @Test
    public void testGetLogin_usu() {
        System.out.println("getLogin_usu");
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        String expResult = "davi";
        String result = usuario.getLogin_usu();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLogin_usu method, of class Usuario.
     */
    @Test
    public void testSetLogin_usu() {
        System.out.println("setLogin_usu");
        String login_usu = "davemitinick";
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        usuario.setLogin_usu(login_usu);

    }

    /**
     * Test of getSenha_usu method, of class Usuario.
     */
    @Test
    public void testGetSenha_usu() {
        System.out.println("getSenha_usu");
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        String expResult = "123";
        String result = usuario.getSenha_usu();
        assertEquals(expResult, result);

    }

    /**
     * Test of setSenha_usu method, of class Usuario.
     */
    @Test
    public void testSetSenha_usu() {
        System.out.println("setSenha_usu");
        String senha_usu = "12345";
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        usuario.setSenha_usu(senha_usu);

    }

    /**
     * Test of getStatus_usu method, of class Usuario.
     */
    @Test
    public void testGetStatus_usu() {
        System.out.println("getStatus_usu");
        Usuario usuario = new Usuario(123, "Davi", "davi", "12345", 001, "online");
        String expResult = "online";
        String result = usuario.getStatus_usu();
        assertEquals(expResult, result);

    }

    /**
     * Test of setStatus_usu method, of class Usuario.
     */
    @Test
    public void testSetStatus_usu() {
        System.out.println("setStatus_usu");
        String status_usu = "offline";
        Usuario usuario = new Usuario(123, "Davi", "davi", "123", 001, "online");
        usuario.setStatus_usu(status_usu);

    }

}