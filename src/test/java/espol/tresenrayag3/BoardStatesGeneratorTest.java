/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package espol.tresenrayag3;

import java.util.Iterator;
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
public class BoardStatesGeneratorTest {
    
    public BoardStatesGeneratorTest() {
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
     * Test of iterator method, of class BoardStatesGenerator.
     */
    @Test
    public void testIterator() throws Exception {
        System.out.println("iterator");
        Board board = new Board();
        board.markBox(new int[]{1, 1}, 'X');
        BoardStatesGenerator instance = new BoardStatesGenerator(board, 'O');
        Iterator<Board> expResult = null;
        Iterator<Board> result = instance.iterator();
        assertEquals(expResult, result);
    }
    
}
