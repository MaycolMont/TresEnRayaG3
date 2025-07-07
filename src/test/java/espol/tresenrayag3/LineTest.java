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
public class LineTest {
    
    public LineTest() {
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
     * Test of isEqual method, of class Line.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        Line line = new Line();
        boolean result = line.isEqual();
        assertFalse(result);

        // setting a value in the first box
        System.out.println("isEqualOnlyOneBox");
        try {
            line.getAt(0).setValue('X');
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        result = line.isEqual();
        assertFalse(result); // Should still be false since not all boxes are set
        
        // setting the same value in all boxes
        System.out.println("isEqualTrue");
        line = new Line();
        try {  
            for (int i = 0; i < 3; i++) {
                line.getAt(i).setValue('X');
            }
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        result = line.isEqual();
        assertTrue(result); // Now all boxes have the same value

        // setting a different value in one box
        System.out.println("isEqualDifferentValues");
        line = new Line();
        try {
            line.getAt(1).setValue('O');
            line.getAt(0).setValue('X');
            line.getAt(2).setValue('X');
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        result = line.isEqual();
        assertFalse(result); // Now not all boxes have the same value
    }

    /**
     * Test of isAvailableFor method, of class Line.
     */
    @Test
    public void testIsAvailableFor() throws Exception {
        System.out.println("isAvailableForEmptyLine");
        Line line = new Line();
        boolean result = line.isAvailableFor('X');
        assertTrue(result);
        
        System.out.println("isAvailableForPlayerTrue");
        line.getAt(0).setValue('X');
        result = line.isAvailableFor('X');
        assertTrue(result);
        
        System.out.println("isAvilableForPlayerFalse");
        result = line.isAvailableFor('O');
        assertFalse(result);
    }

    /**
     * Test of isEmpty method, of class Line.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Line instance = new Line();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
        // Setting a value in the first box
        System.out.println("isEmptyFalse");
        try {
            instance.getAt(0).setValue('X');
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        result = instance.isEmpty();
        assertFalse(result); // Now the line should not be empty
    }
}
