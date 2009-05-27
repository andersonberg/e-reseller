/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produto;

import java.sql.Date;
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
public class ProdutoTest {

    public ProdutoTest() {
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
     * Test of getId_prod method, of class Produto.
     */
    @Test
    public void testGetId_prod() {
        System.out.println("getId_prod");
        Produto produto = new Produto(1, "Harry Potter", "Livro", "20x14", "300", "Ficcao", 203120);
        int expResult = 1;
        int result = produto.getId_prod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_prod method, of class Produto.
     */
    @Test
    public void testSetId_prod() {
        System.out.println("setId_prod");
        int id_prod = 0;
        Produto produto = new Produto(1, "Descricao", "Livro", "20x20", "400", "Didático", 230);
        produto.setId_prod(id_prod);
    }

    /**
     * Test of getDescricao_prod method, of class Produto.
     */
    @Test
    public void testGetDescricao_prod() {
        System.out.println("getDescricao_prod");
        Produto produto = new Produto(3, "Livreto", "Adulto", "20x10", "300", "Ficcao", 03212);
        String expResult = "Livreto";
        String result = produto.getDescricao_prod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao_prod method, of class Produto.
     */
    @Test
    public void testSetDescricao_prod() {
        System.out.println("setDescricao_prod");
        String descricao_prod = "Livreto";
        Produto produto = new Produto(3, "Livrao", "Comedia", "20x13", "300", "Entretenimento", 3212);
        produto.setDescricao_prod(descricao_prod);
    }

    /**
     * Test of getCaracteristicas_prod method, of class Produto.
     */
    @Test
    public void testGetCaracteristicas_prod() {
        System.out.println("getCaracteristicas_prod");
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 123);
        String expResult = "Livreto";
        String result = produto.getCaracteristicas_prod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCaracteristicas_prod method, of class Produto.
     */
    @Test
    public void testSetCaracteristicas_prod() {
        System.out.println("setCaracteristicas_prod");
        String caracteristicas_prod = "";
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 123);
        produto.setCaracteristicas_prod(caracteristicas_prod);
    }

    /**
     * Test of getDimensao_prod method, of class Produto.
     */
    @Test
    public void testGetDimensao_prod() {
        System.out.println("getDimensao_prod");
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        String expResult = "25x13";
        String result = produto.getDimensao_prod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDimensao_prod method, of class Produto.
     */
    @Test
    public void testSetDimensao_prod() {
        System.out.println("setDimensao_prod");
        String dimensao_prod = "25x10";
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        produto.setDimensao_prod(dimensao_prod);
    }

    /**
     * Test of getPeso_prod method, of class Produto.
     */
    @Test
    public void testGetPeso_prod() {
        System.out.println("getPeso_prod");
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        String expResult = "300";
        String result = produto.getPeso_prod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPeso_prod method, of class Produto.
     */
    @Test
    public void testSetPeso_prod() {
        System.out.println("setPeso_prod");
        String peso_prod = "400";
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        produto.setPeso_prod(peso_prod);
    }

    /**
     * Test of getEspec_tecnicas_prod method, of class Produto.
     */
    @Test
    public void testGetEspec_tecnicas_prod() {
        System.out.println("getEspec_tecnicas_prod");
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        String expResult = "Entretenimento";
        String result = produto.getEspec_tecnicas_prod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEspec_tecnicas method, of class Produto.
     */
    @Test
    public void testSetEspec_tecnicas() {
        System.out.println("setEspec_tecnicas");
        String espec_tecnicas_prod = "Drama";
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        produto.setEspec_tecnicas(espec_tecnicas_prod);
    }

    /**
     * Test of getId_usu method, of class Produto.
     */
    @Test
    public void testGetId_usu() {
        System.out.println("getId_usu");
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        int expResult = 256;
        int result = produto.getId_usu();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_usu method, of class Produto.
     */
    @Test
    public void testSetId_usu() {
        System.out.println("setId_usu");
        int id_usu = 100;
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256);
        produto.setId_usu(id_usu);
    }

    /**
     * Test of getDthr_atualizacao method, of class Produto.
     */
    @Test
    public void testGetDthr_atualizacao() {
        System.out.println("getDthr_atualizacao");
        Produto produto = new Produto(1, "Livrao", "Comedia", "25x13", "300", "Entretenimento", 256, Date.valueOf("2009-05-23"));
        Date expResult = Date.valueOf("2009-05-23");
        Date result = produto.getDthr_atualizacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDthr_atualizacao method, of class Produto.
     */
    @Test
    public void testSetDthr_atualizacao() {
        System.out.println("setDthr_atualizacao");
        Date dthr_atualizacao = Date.valueOf("2009-06-22");
        Produto produto = new Produto(2, "Revista", "Usada", "10x15", "100", "Adulta", 123, Date.valueOf("2009-05-23"));
        produto.setDthr_atualizacao(dthr_atualizacao);
    }

}