package intset;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Patrick Beuks (s2288842) & Rik Schaaf
 */
public class IntSetTest {

    private IntSet intSet;
    private static final int CAPASITY = 10;

    @Before
    public void setUp() {
        intSet = new IntSet(CAPASITY);
    }

    @Test
    public void testGetCount() {
        System.out.println("getCount()");
        assertEquals(0, intSet.getCount());
    }

    @Test
    public void TestGetCapacity() {
        System.out.println("GetCapacity()");
        assertEquals(CAPASITY, intSet.getCapacity());
    }

    @Test
    public void testIntSet() {
        System.out.println("IntSet(int capacity)");
        assertEquals(0, intSet.getCount());
        assertEquals(CAPASITY, intSet.getCapacity());
    }

    @Test
    public void testHas() {
        System.out.println("has(int value)");

        assertTrue(!intSet.has(234));
        assertTrue(!intSet.has(0));
        
        intSet.add(45);

        assertTrue(intSet.has(45));
    }

    @Test
    public void testAdd() {
        System.out.println("add(int value)");
        
        
        // set = []; count = 0;
        // voeg een element toe
        intSet.add(254);
        assertTrue(intSet.has(254));
        assertEquals(1, intSet.getCount());
        
        // set = [254]; count = 1;
        // probeer een bestaand element toe te voegen
        intSet.add(254);
        assertEquals(1, intSet.getCount());
        assertTrue(intSet.has(254));
        
        // set = [254]; count = 1;
        // kijk of toevoegen meerdere elementen werkt
        intSet.add(25);
        assertEquals(2, intSet.getCount());
        assertTrue(intSet.has(25));
        
        // set = [254, 25]; count = 2;
        intSet.add(315);
        assertEquals(3, intSet.getCount());
        assertTrue(intSet.has(315));
        
        // set = [254, 25, 315]; count = 3;
        intSet.add(32);
        assertEquals(4, intSet.getCount());
        assertTrue(intSet.has(32));
        
        // set = [254, 25, 315, 32]; count = 4;
        // test of negative getallen en nul het doen
        intSet.add(-23);
        assertEquals(5, intSet.getCount());
        assertTrue(intSet.has(-23));
        
        // set = [254, 25, 315, 32, -23]; count = 5;
        intSet.add(0);
        assertEquals(6, intSet.getCount());
        assertTrue(intSet.has(0));
        
        // set = [254, 25, 315, 32, 0]; count = 6;
    }

    @Test
    public void testRemove() {
        System.out.println("remove(int value)");

        // set = []; count = 0;
        // verwijder element van een lege array
        intSet.remove(24);

        assertTrue(!intSet.has(24));
        assertEquals(0, intSet.getCount());

        intSet.add(12);
        intSet.add(24);
        intSet.add(37);
        intSet.add(23);

        // set = [12, 24, 37, 23]; count = 4;
        // verwijder bestaand element
        intSet.remove(24);

        assertEquals(3, intSet.getCount());
        assertTrue( intSet.has(12));
        assertTrue(!intSet.has(24));
        assertTrue( intSet.has(37));
        assertTrue( intSet.has(23));

        // set = [12, 37, 23]; count = 3;
        // verwijder twee keer een bestaand element

        intSet.remove(12);
        intSet.remove(12);

        assertEquals(2, intSet.getCount());
        assertTrue(!intSet.has(12));
        assertTrue( intSet.has(37));
        assertTrue( intSet.has(23));
        // set = [37, 23]; count = 2;
    }
    
    @Test
    public void testIsEmpty(){
        System.out.println("isEmpty()");
        
        // set = []; count = 0;
        // kijken of de lijst leeg is naar initalisatie
        assertEquals(true, intSet.isEmpty());
        
        intSet.add(25);
        // set = [25]; count = 1;
        // kijken of de set niet meer leeg is na toevoegen van een element
        assertEquals(false, intSet.isEmpty());
        
        intSet.remove(25);
        // set = []; count = 0;
        // kijken of de set nleeg is na verwijderen van een element
        assertEquals(true, intSet.isEmpty());
        
        intSet.add(25);
        intSet.add(54);
        intSet.add(27);
        intSet.add(12);
        intSet.add(12); // dubble check
        intSet.remove(25); 
        intSet.remove(25); // dubble check
        intSet.remove(12);
        intSet.remove(54);
        intSet.remove(27);
        // set = []; count = 0;
        // kijken of de set nleeg is na toevoegen en verwijderen van meerdere elementen
        assertEquals(true, intSet.isEmpty());
    }
    
    @Test
    public void testGetArray(){
        System.out.println("getArray()");
        
        // set = []; count = 0;
        // kijk of een lege lijst 0 lengte heeft
        assertEquals(0, intSet.getArray().length);
        
        intSet.add(24);
        intSet.add(34);
        intSet.add(41);
        // set = [24, 34, 41]; count = 3;
        // kijk of na 3 element hij lengte 3 heeft
        assertEquals(3, intSet.getArray().length);
        
        // kijk of echt alle elementen er nog insitten en de oorspronkelijke lijst niet is gewijziged
        for (int i = 0; i < intSet.getArray().length; i++) {
            assertTrue(intSet.has(intSet.getArray()[i]));
        }
    }
    
    @Test
    public void testIntersect(){
        System.out.println("intersect(IntSet other)");
        IntSet intersectList;
        IntSet otherIntSet = new IntSet(5);
                
        otherIntSet.add(25);
        otherIntSet.add(37);
        otherIntSet.add(58);
        intSet.add(25);
        intSet.add(28);
        intSet.add(58);
        intSet.add(23);
        //      intSet: set = [25, 28, 58, 23]; count = 4;
        // otherIntSet: set = [25, 37, 58];     count = 3;
        intersectList = intSet.intersect(otherIntSet);
        assertEquals(2, intersectList.getCount());
        assertTrue(intersectList.has(25));
        assertTrue(intersectList.has(58));
        for (int i = 0; i < intersectList.getCount(); i++) {
             assertTrue(intSet.has(intersectList.getArray()[i]));
             assertTrue(otherIntSet.has(intersectList.getArray()[i]));
        }
        
        otherIntSet = new IntSet(5);
        //      intSet: set = [25, 28, 58, 23]; count = 4;
        // otherIntSet: set = [];               count = 0;
        // kijk of intersect het kan hebben als other leeg is
        intersectList = intSet.intersect(otherIntSet);
        assertEquals(0, intersectList.getCount());
        
        intSet = new IntSet(CAPASITY);
        otherIntSet.add(25);
        otherIntSet.add(37);
        otherIntSet.add(58);
        //      intSet: set = [];               count = 0;
        // otherIntSet: set = [25, 37, 58];     count = 3;
        // kijk of intersect het kan hebben als intSet zelf leeg is
        intersectList = intSet.intersect(otherIntSet);
        assertEquals(0, intersectList.getCount());
    }
    
    
    /**
     * Returns the union of this set and another set.
     *
     * @param other the set to union this set with
     * @return the union
     * @pre other != null
     * @post forall int v: has(v) implies return.has(v)
     * @post forall int v: other.has(v) implies return.has(v)
     * @post forall int v: return.has(v) implies (has(v) or other.has(v))
     */
    @Test
    public void testUnion(){
        System.out.println("union(IntSet other)");
        
        IntSet unionList;
        IntSet otherIntSet = new IntSet(5);
                
        otherIntSet.add(25);
        otherIntSet.add(37);
        otherIntSet.add(58);
        intSet.add(25);
        intSet.add(28);
        intSet.add(58);
        intSet.add(23);
        //      intSet: set = [25, 28, 58, 23]; count = 4;
        // otherIntSet: set = [25, 37, 58];     count = 3;
        // kijken of hij union goed doet
        unionList = intSet.union(otherIntSet);
        assertEquals(5, unionList.getCount());
        assertTrue(unionList.has(25));
        assertTrue(unionList.has(37));
        assertTrue(unionList.has(58));
        assertTrue(unionList.has(28));
        assertTrue(unionList.has(23));
        
        for (int i = 0; i < intSet.getCount(); i++) {
            assertTrue(unionList.has(intSet.getArray()[i]));
        }
        for (int i = 0; i < otherIntSet.getCount(); i++) {
            assertTrue(unionList.has(otherIntSet.getArray()[i]));
        }
        for (int i = 0; i < unionList.getCount(); i++) {
            assertTrue(intSet.has(unionList.getArray()[i]) || otherIntSet.has(unionList.getArray()[i]));
        }
        
        otherIntSet = new IntSet(5);
        //      intSet: set = [25, 28, 58, 23]; count = 4;
        // otherIntSet: set = [0];              count = 0;
        // kijken of hij union het nog doet als other een lege lijst is
        unionList = intSet.union(otherIntSet);
        assertEquals(4, unionList.getCount());
        assertTrue(unionList.has(25));
        assertTrue(unionList.has(58));
        assertTrue(unionList.has(28));
        assertTrue(unionList.has(23));
        
        for (int i = 0; i < intSet.getCount(); i++) {
            assertTrue(unionList.has(intSet.getArray()[i]));
        }
        for (int i = 0; i < otherIntSet.getCount(); i++) {
            assertTrue(unionList.has(otherIntSet.getArray()[i]));
        }
        for (int i = 0; i < unionList.getCount(); i++) {
            assertTrue(intSet.has(unionList.getArray()[i]) || otherIntSet.has(unionList.getArray()[i]));
        }
        
        intSet = new IntSet(CAPASITY);
        otherIntSet.add(25);
        otherIntSet.add(37);
        otherIntSet.add(58);
        //      intSet: set = [];               count = 0;
        // otherIntSet: set = [25, 37, 58];     count = 3;
        // kijken of hij union het nog doet als hijzelf een lege lijst is
        unionList = intSet.union(otherIntSet);
        assertEquals(3, unionList.getCount());
        assertTrue(unionList.has(25));
        assertTrue(unionList.has(37));
        assertTrue(unionList.has(58));
        
        for (int i = 0; i < intSet.getCount(); i++) {
            assertTrue(unionList.has(intSet.getArray()[i]));
        }
        for (int i = 0; i < otherIntSet.getCount(); i++) {
            assertTrue(unionList.has(otherIntSet.getArray()[i]));
        }
        for (int i = 0; i < unionList.getCount(); i++) {
            assertTrue(intSet.has(unionList.getArray()[i]) || otherIntSet.has(unionList.getArray()[i]));
        }
    }
}