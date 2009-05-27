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
public class CadastroUsuariosTest {

    CadastroUsuarios cadastroUsuarios;
    Usuario usuario;

    public CadastroUsuariosTest() throws  Exception{

        RepositorioUsuarios repositorioUsuarios = new RepositorioUsuariosMySQL();
        cadastroUsuarios = new CadastroUsuarios(repositorioUsuarios);
        usuario = new Usuario(123, "Adam Smith", "adam", "12345", 001, "online");
        
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
     * Test of procurar method, of class CadastroUsuarios.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id = this.usuario.getId_usu();
        int tipo = 0;
        Usuario expResult = this.usuario;
        Usuario result = this.cadastroUsuarios.procurar(id, tipo);
        assertEquals(expResult, result);
    }

    /**
     * Test of inserir method, of class CadastroUsuarios.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Usuario usuarioEsperado = usuario;
        this.cadastroUsuarios.inserir(usuarioEsperado);
    }

    /**
     * Test of atualizar method, of class CadastroUsuarios.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Usuario usuarioLocal = this.usuario;
        usuarioLocal.setNome_usu("Moraes Moreira");
        this.cadastroUsuarios.atualizar(usuarioLocal);

    }

    /**
     * Test of remover method, of class CadastroUsuarios.
     */
    @Test
    public void testRemover_Usuario() throws Exception {
        System.out.println("remover");
        boolean expResult = false;
        boolean result = this.cadastroUsuarios.remover(usuario);
        assertEquals(expResult, result);

    }

    /**
     * Test of remover method, of class CadastroUsuarios.
     */
    @Test
    public void testRemover_int() throws Exception {
        System.out.println("remover");
        int id_us = this.usuario.getId_usu();
        boolean expResult = false;
        boolean result = this.cadastroUsuarios.remover(id_us);
        assertEquals(expResult, result);

    }

    /**
     * Test of procurarUsuarios method, of class CadastroUsuarios.
     */
    @Test
    public void testProcurarUsuarios() throws Exception {
        System.out.println("procurarUsuarios");
        Collection expResult = null;
        Collection result = this.cadastroUsuarios.procurarUsuarios();
        assertEquals(expResult, result);

    }

    /**
     * Test of existe method, of class CadastroUsuarios.
     */
    @Test
    public void testExiste() throws Exception {
        System.out.println("existe");
        int id_usu = this.usuario.getId_usu();
        boolean expResult = false;
        boolean result = this.cadastroUsuarios.existe(id_usu);
        assertEquals(expResult, result);

    }

    /**
     * Test of existeLogin method, of class CadastroUsuarios.
     */
    @Test
    public void testExisteLogin() throws Exception {
        System.out.println("existeLogin");
        boolean expResult = false;
        boolean result = this.cadastroUsuarios.existeLogin(usuario);
        assertEquals(expResult, result);

    }

    /**
     * Test of liberarAcesso method, of class CadastroUsuarios.
     */
    @Test
    public void testLiberarAcesso() throws Exception {
        System.out.println("liberarAcesso");
        String login_usu = "adam";
        String senha_usu = "12345";
        int expResult = 0;
        int result = this.cadastroUsuarios.liberarAcesso(login_usu, senha_usu);
        assertEquals(expResult, result);

    }

}