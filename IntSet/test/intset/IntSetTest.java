/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intset;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rik Schaaf
 */
public class IntSetTest {
    private IntSet instance;
    private static final int TEST_CAPACITY = 7;
    private static final int TEST_VALUE = 243;

    public IntSetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new IntSet(TEST_CAPACITY);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class IntSet.
     */
    
    @Test
    public void testIntSet() {
        System.out.println("constructor");
        assert TEST_CAPACITY >= 0;
        instance = new IntSet(TEST_CAPACITY);
        assertEquals(0, instance.getCount());
        assertEquals(TEST_CAPACITY, instance.getCapacity());
    }
    
    @Test
    public void testIsEmpty() {
//        System.out.println("isEmpty");
//        IntSet instance = null;
//        boolean expResult = false;
//        boolean result = instance.isEmpty();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of has method, of class IntSet.
     */
    @Test
    public void testHas() {
        System.out.println("has");
        boolean expResult;
        boolean result;

        expResult = false;
        result = instance.has(TEST_VALUE);
        assertEquals(expResult, result);

//      expResult = false;
        result = instance.has(TEST_VALUE + 1);
        assertEquals(expResult, result);

        instance.add(TEST_VALUE);

        expResult = true;
        result = instance.has(TEST_VALUE);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.has(TEST_VALUE + 1);
        assertEquals(expResult, result);

        instance.add(TEST_VALUE + 1);

        expResult = true;
        result = instance.has(TEST_VALUE);
        assertEquals(expResult, result);

//      expResult = true;
        result = instance.has(TEST_VALUE + 1);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class IntSet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        assert instance.getCount() < instance.getCapacity();
        int testValue;
        boolean testHad;
        int preCount;

        testValue = TEST_VALUE;
        testHad = instance.has(testValue);
        assertEquals(false, testHad);
        preCount = instance.getCount();
        instance.add(testValue);
        assertTrue(instance.has(testValue));
        assertEquals(preCount + 1, instance.getCount());

        testHad = instance.has(testValue);
        assertEquals(true, testHad);
        preCount = instance.getCount();
        instance.add(testValue);
        assertTrue(instance.has(testValue));
        assertEquals(preCount, instance.getCount());

        testValue = 943;

        testHad = instance.has(testValue);
        assertEquals(false, testHad);
        preCount = instance.getCount();
        instance.add(testValue);
        assertTrue(instance.has(testValue));
        assertEquals(preCount + 1, instance.getCount());

        testValue = 28365;

        testHad = instance.has(testValue);
        assertEquals(false, testHad);
        preCount = instance.getCount();
        instance.add(testValue);
        assertTrue(instance.has(testValue));
        assertEquals(preCount + 1, instance.getCount());

        testHad = instance.has(testValue);
        assertEquals(true, testHad);
        preCount = instance.getCount();
        instance.add(testValue);
        assertTrue(instance.has(testValue));
        assertEquals(preCount, instance.getCount());
    }

    /**
     * Test of remove method, of class IntSet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int value = 0;
        instance = new IntSet(TEST_CAPACITY);
        instance.remove(value);
    }

    /**
     * Test of intersect method, of class IntSet.
     */
    @Test
    public void testIntersect() {
//        System.out.println("intersect");
//        IntSet other = null;
//        IntSet instance = null;
//        IntSet expResult = null;
//        IntSet result = instance.intersect(other);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class IntSet.
     */
    @Test
    public void testUnion() {
//        System.out.println("union");
//        IntSet other = null;
//        IntSet instance = null;
//        IntSet expResult = null;
//        IntSet result = instance.union(other);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getArray method, of class IntSet.
     */
    @Test
    public void testGetArray() {
//        System.out.println("getArray");
//        IntSet instance = null;
//        int[] expResult = null;
//        int[] result = instance.getArray();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class IntSet.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        int expResult;
        int result;
        
        expResult = 0;
        result = instance.getCount();
        assertEquals(expResult, result);
        
        instance.add(TEST_VALUE);
        
        expResult = 1;
        result = instance.getCount();
        assertEquals(expResult, result);
        
        instance.add(TEST_VALUE);
        
        expResult = 1;
        result = instance.getCount();
        assertEquals(expResult, result);
        
        instance.add(TEST_VALUE+1);
        
        expResult = 2;
        result = instance.getCount();
        assertEquals(expResult, result);
        
        instance.add(TEST_VALUE+1);
        
        expResult = 2;
        result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCapacity method, of class IntSet.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        int expResult = TEST_CAPACITY;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class IntSet.
     */
    @Test
    public void testToString() {
//        System.out.println("toString");
//        IntSet instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}