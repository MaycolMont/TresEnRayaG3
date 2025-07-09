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
        int[] position = {1, 2};
        char value = 'X';
        Board instance = new Board();
        instance.markBox(position, value);
        char result = instance.getValueAt(position[0], position[1]);
        assertEquals(value, result);
    }

        @Test
    public void testMarkBoxCorrectBox() throws Exception {
        System.out.println("markBoxCorrectBox");
        int[] position = {1, 2};
        char value = 'X';
        Board instance = new Board();
        instance.markBox(position, value);
        for (int i = 0; i<3; i++) {
            for (int j = 0; i<3; i++) {
                if (i != position[0] && j != position[1]) {
                    char emptyValue = instance.getValueAt(i, j);
                    char expectedResult = 0;
                    assertEquals(expectedResult, emptyValue);
                }
            }
        }
        char result = instance.getValueAt(position[0], position[1]);
        assertEquals(value, result);
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
        char expResult = 0;
        char result = instance.getValueAt(row, column);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValueAtSetValue() throws Exception {
        System.out.println("getValueAtSetValue");
        int row = 0;
        int column = 0;
        Board instance = new Board();
        instance.markBox(new int[]{row, column}, 'X');
        char expResult = 'X';
        char result = instance.getValueAt(row, column);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValueAtFail() {
        System.out.println("getValueAtFail");
        int row = 4;
        int column = 0;
        Board instance = new Board();
        boolean result = true;
        try {
            instance.getValueAt(row, column);
            result = false;
        } catch (Exception e) {}
        assertTrue(result);
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

    @Test
    public void testCloneIndependet() throws Exception {
        System.out.println("cloneIndependent");
        int[] position = {1, 1};
        Board instance = new Board();
        char result = instance.clone().getValueAt(position[0], position[1]);
        instance.markBox(position, 'X');
        char expResult = 0;
        assertEquals(expResult, result);
    }
}
