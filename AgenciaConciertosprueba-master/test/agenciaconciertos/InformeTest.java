/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciaconciertos;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DAW104 (Alberto Liñan)
 */
public class InformeTest {
    
    public InformeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Informe.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Informe instance = new Informe();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Informe.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Informe instance = new Informe();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRevisado method, of class Informe.
     */
    @Test
    public void testIsRevisado() {
        System.out.println("isRevisado");
        Informe instance = new Informe();
        boolean expResult = false;
        boolean result = instance.isRevisado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRevisado method, of class Informe.
     */
    @Test
    public void testSetRevisado() {
        System.out.println("setRevisado");
        boolean revisado = false;
        Informe instance = new Informe();
        instance.setRevisado(revisado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class Informe.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Informe instance = new Informe();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Informe.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Informe instance = new Informe();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGira method, of class Informe.
     */
    @Test
    public void testGetGira() {
        System.out.println("getGira");
        Informe instance = new Informe();
        Gira expResult = null;
        Gira result = instance.getGira();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGira method, of class Informe.
     */
    @Test
    public void testSetGira() {
        System.out.println("setGira");
        Gira gira = null;
        Informe instance = new Informe();
        instance.setGira(gira);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Informe.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Informe instance = new Informe();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of data method, of class Informe.
     */
    @Test
    public void testData() {
        System.out.println("data");
        Informe instance = new Informe();
        String expResult = "";
        String result = instance.data();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInformeById method, of class Informe.
     */
    @Test
    public void testGetInformeById() {
        System.out.println("getInformeById");
        long id = 0L;
        Informe instance = new Informe();
        Informe expResult = null;
        Informe result = instance.getInformeById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInforme method, of class Informe.
     */
    @Test
    public void testGetAllInforme() {
        System.out.println("getAllInforme");
        Informe instance = new Informe();
        ArrayList<Informe> expResult = null;
        ArrayList<Informe> result = instance.getAllInforme();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoInforme method, of class Informe.
     */
    @Test
    public void testNuevoInforme() {
        System.out.println("nuevoInforme");
        Informe instance = new Informe();
        Informe expResult = null;
        Informe result = instance.nuevoInforme();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisarInforme method, of class Informe.
     */
    @Test
    public void testRevisarInforme() {
        System.out.println("revisarInforme");
        Informe instance = new Informe();
        boolean expResult = false;
        boolean result = instance.revisarInforme();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportaInformeCaracteres method, of class Informe.
     */
    @Test
    public void testExportaInformeCaracteres() {
        System.out.println("exportaInformeCaracteres");
        String rutaFichero = "";
        Informe instance = new Informe();
        instance.exportaInformeCaracteres(rutaFichero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importaInformeCaracter method, of class Informe.
     */
    @Test
    public void testImportaInformeCaracter() {
        System.out.println("importaInformeCaracter");
        String rutaFichero = "";
        ArrayList<Informe> expResult = null;
        ArrayList<Informe> result = Informe.importaInformeCaracter(rutaFichero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportaInformeBinario method, of class Informe.
     */
    @Test
    public void testExportaInformeBinario() {
        System.out.println("exportaInformeBinario");
        String rutaFichero = "";
        Informe instance = new Informe();
        instance.exportaInformeBinario(rutaFichero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importaInformeBinario method, of class Informe.
     */
    @Test
    public void testImportaInformeBinario() {
        System.out.println("importaInformeBinario");
        String rutaFichero = "";
        ArrayList<Informe> expResult = null;
        ArrayList<Informe> result = Informe.importaInformeBinario(rutaFichero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
