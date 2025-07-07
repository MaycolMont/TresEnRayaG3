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
public class BoxTest {
    
    public BoxTest() {
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
     * Test of setValue method, of class Box.
     */
    @Test
    public void testSetValue() throws Exception {
        System.out.println("setValue");
        char value = 'X';
        Box instance = new Box();
        instance.setValue(value);
        // Verify that the value was set correctly
        assertEquals(value, instance.getValue());

        // Test setting the value again, which should throw an exception
        System.out.println("setValueFail");
        boolean result = false;
        try {
            instance.setValue('O'); // Attempt to set a different value
        } catch (Exception e) {
            result = true;
        }
        assertTrue(result);
    }

    /**
     * Test of getValue method, of class Box.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Box instance = new Box();
        char expResult = 0; // Represents an empty box
        char result = instance.getValue();
        assertEquals(expResult, result);

        // Set a value and check again
        System.out.println("getValueSet");
        try {
            instance.setValue('O');
        } catch (Exception e) {}
        expResult = 'O'; // Now the box should contain 'O'
        result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Box.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Box instance = new Box();
        boolean expResult = true; // Initially, the box should be empty
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
        // Set a value and check again
        System.out.println("isEmptyFalse");
        try {
            instance.setValue('X');
        } catch (Exception e) {
        }
        
        expResult = false; // Now the box should not be empty
        result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class Box.
     */
    @Test
    public void testContains() {
        System.out.println("containsEmpty");
        char value = 'X';
        Box instance = new Box();
        
        // Initially, the box should not contain any value
        boolean result = instance.contains(value);
        assertFalse(result);
        
        // Set a value and check again
        System.out.println("containsTrue");
        try {
            instance.setValue(value);
        } catch (Exception e) {
            fail("Setting value failed: " + e.getMessage());
        }
        
        // Now the box should contain the value
        result = instance.contains(value);
        assertTrue(result);

        // Check for a different value
        
        System.out.println("containsFalse");
        char differentValue = 'O';
        result = instance.contains(differentValue);
        assertFalse(result);
    }

    /**
     * Test of toString method, of class Box.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Box instance = new Box();
        String expResult = "_";
        String result = instance.toString();
        assertEquals(expResult, result);

        // Set a value and check the string representation
        System.out.println("toStringWithValue");
        try {
            instance.setValue('X');
        } catch (Exception e) {
            fail("Setting value failed: " + e.getMessage());
        }
        expResult = "X"; // Now the box should represent 'X'
        result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
