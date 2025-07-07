/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package espol.tresenrayag3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elmay
 */
public class BoardTest {
    
    public BoardTest() {
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
     * Test of markBox method, of class Board.
     */
    @Test
    public void testMarkBox() throws Exception {
        System.out.println("markBox");
        int[] position = null;
        char value = ' ';
        Board instance = new Board();
        instance.markBox(position, value);
    }

    /**
     * Test of getValueAt method, of class Board.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int row = 0;
        int column = 0;
        Board instance = new Board();
        char expResult = ' ';
        char result = instance.getValueAt(row, column);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUtility method, of class Board.
     */
    @Test
    public void testGetUtility() {
    }

    /**
     * Test of clone method, of class Board.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        int[] position = {1, 1};
        Board instance = new Board();
        instance.markBox(position, 'X');
        char expResult = 'X';
        char result = instance.clone().getValueAt(position[0], position[1]);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Board instance = new Board();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of onNotify method, of class Board.
     */
    @Test
    public void testOnNotify() {
        System.out.println("onNotify");
    }
    
}
