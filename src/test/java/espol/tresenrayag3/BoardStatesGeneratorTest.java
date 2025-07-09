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
 * @author maycmont
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
    
    @Test
    public void generatedBoardsDoNotModifyOriginal() {
        System.out.println("generatedBoardsDoNotModifyOriginal");
        Board board = new Board();
        BoardStatesGenerator generator = new BoardStatesGenerator(board, 'X');

        for (Board state : generator) {
            // El tablero original no debe haber cambiado
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    assertEquals(0, board.getValueAt(row, col));
                }
            }
        }
    }

    
    @Test
    public void eachStateHasOnlyOneNewMark() {
        System.out.println("StateHasOnlyOneNewMark");
        Board board = new Board();
        BoardStatesGenerator generator = new BoardStatesGenerator(board, 'X');

        for (Board state : generator) {
            int countMarks = 0;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (state.getValueAt(row, col) == 'X') {
                        countMarks++;
                    }
                }
            }
            assertEquals(1, countMarks);
    }
}

    
}
