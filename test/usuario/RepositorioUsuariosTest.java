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
public class RepositorioUsuariosTest {

    RepositorioUsuarios repositorioUsuarios;
    Usuario usuario;

    public RepositorioUsuariosTest() throws Exception  {

        this.repositorioUsuarios = new RepositorioUsuariosMySQL();
        this.usuario = new Usuario(123, "Alexandre Pereira", "alex", "senha", 123, "online");
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
     * Test of existe method, of class RepositorioUsuarios.
     */
    @Test
    public void testExiste() throws Exception {
        System.out.println("existe");
        int id_usu = this.usuario.getId_usu();
        boolean expResult = false;
        boolean result = this.repositorioUsuarios.existe(id_usu);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeLogin method, of class RepositorioUsuarios.
     */
    @Test
    public void testExisteLogin() throws Exception {
        System.out.println("existeLogin");
        boolean expResult = false;
        boolean result = this.repositorioUsuarios.existeLogin(usuario);
        assertEquals(expResult, result);

    }

    /**
     * Test of liberarAcesso method, of class RepositorioUsuarios.
     */
    @Test
    public void testLiberarAcesso() throws Exception {
        System.out.println("liberarAcesso");
        String login_usu = "alex";
        String senha_usu = "senha";
        int expResult = 0;
        int result = this.repositorioUsuarios.liberarAcesso(login_usu, senha_usu);
        assertEquals(expResult, result);

    }

    /**
     * Test of inserir method, of class RepositorioUsuarios.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        this.repositorioUsuarios.inserir(usuario);
    }

    /**
     * Test of atualizar method, of class RepositorioUsuarios.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Usuario usuarioLocal = usuario;
        usuarioLocal.setNome_usu("Darley Magalhaes");
        this.repositorioUsuarios.atualizar(usuarioLocal);

    }

    /**
     * Test of procurar method, of class RepositorioUsuarios.
     */
    @Test
    public void testProcurar() throws Exception {
        System.out.println("procurar");
        int id = this.usuario.getId_usu();
        int tipo = 0;
        Usuario expResult = null;
        Usuario result = this.repositorioUsuarios.procurar(id, tipo);
        assertEquals(expResult, result);
    }

    /**
     * Test of remover method, of class RepositorioUsuarios.
     */
    @Test
    public void testRemover_Usuario() throws Exception {
        System.out.println("remover");
        boolean expResult = false;
        boolean result = this.repositorioUsuarios.remover(usuario);
        assertEquals(expResult, result);

    }

    /**
     * Test of remover method, of class RepositorioUsuarios.
     */
    @Test
    public void testRemover_int() throws Exception {
        System.out.println("remover");
        int id_cli = 0;
        boolean expResult = false;
        boolean result = this.repositorioUsuarios.remover(id_cli);
        assertEquals(expResult, result);

    }

    /**
     * Test of procurarUsuarios method, of class RepositorioUsuarios.
     */
    @Test
    public void testProcurarUsuarios() throws Exception {
        System.out.println("procurarUsuarios");
        Collection expResult = null;
        Collection result = this.repositorioUsuarios.procurarUsuarios();
        assertEquals(expResult, result);

    }

}