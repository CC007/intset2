package intset;

/**
 *
 * @author Patrick Beuks (s2288842) & Rik Schaaf (s2391198)
 * edited from assignment of AOOP at the University of Groningen.
 */
/**
 * Representation of a finite set of integers.
 *
 * @invariant getCount() >= 0
 * @invariant getCount() <= getCapacity()
 */
public class IntSet {

    private int[] set;
    private int capacity;
    private int count = 0;

    /**
     * Creates a new set with 0 elements.
     *
     * @param capacity the maximal number of elements this set can have
     * @pre capacity >= 0
     * @post getCount() == 0
     * @post getCapacity() == capacity
     */
    public IntSet(int capacity) {
        this.capacity = capacity;
        set = new int[this.capacity];
    }

    /**
     * Test whether the set is empty.
     *
     * @return getCount() == 0
     */
    public boolean isEmpty() {
        return getCount() == 0;
    }

    /**
     * Test whether a value is in the set
     *
     * @return exists int v in getArray() such that v == value
     */
    public boolean has(int value) {
        for (int i = 0; i < getCount(); i++) {
            if (set[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a value to the set.
     *
     * @pre getCount() < getCapacity() @post has( value) @post
     * !this@pre.has(value ) implies (getCount() == this@pre.getCount() + 1)
     * @post this@pre.has(value) implies (getCount() == this@pre.getCount())
     */
    public void add(int value) {
        if (!has(value)) {
            set[count] = value;
            count++;
        }
    }

    /**
     * Removes a value from the set.
     *
     * @post !has(value)
     * @post this@pre.has(value) implies (getCount() == this@pre.getCount() - 1)
     * @post !this@pre.has(value) implies (getCount() == this@pre.getCount())
     */
    public void remove(int value) {
        if (has(value)) {
            int elementPos = 0;
            for (int i = 0; i < getCount(); i++) {
                if (set[i] == value) {
                    elementPos = i;
                    break;
                }
            }
            for (int i = elementPos; i < getCount() - 1; i++) {
                set[i] = set[i + 1];
            }
            count--;
        }
    }

    /**
     * Returns the intersection of this set and another set.
     *
     * @param other the set to intersect this set with
     * @return the intersection
     * @pre other != null
     * @post forall int v: (has(v) and other.has(v)) implies return.has(v)
     * @post forall int v: return.has(v) implies (has(v) and other.has(v))
     */
    public IntSet intersect(IntSet other) {
        IntSet returnIntSet;
        int hits = 0;
        for (int i = 0; i < getCount(); i++) {
            if (other.has(set[i])) {
                hits++;
            }
        }
        returnIntSet = new IntSet(hits);
        for (int i = 0; i < getCount(); i++) {
            if (other.has(set[i])) {
                returnIntSet.add(set[i]);
            }
        }
        return returnIntSet;
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
    public IntSet union(IntSet other) {
        int hits = getCount();
        IntSet returnSet;
        for (int i = 0; i < other.getCount(); i++) {
            if (!has(other.getArray()[i])) {
                hits++;
            }
        }
        returnSet = new IntSet(hits);
        for (int i = 0; i < getCount(); i++) {
            returnSet.add(getArray()[i]);
        }
        for (int i = 0; i < other.getCount(); i++) {
            returnSet.add(other.getArray()[i]);
        }
        return returnSet;
    }

    /**
     * Returns the difference of this set and another set.
     *
     * @param other the set to difference this set with
     * @return the difference
     * @pre other != null
     * @post forall int v: (has(v) and !other.has(v)) implies return.has(v)
     * @post forall int v: return.has(v) implies (has(v) and !other.has(v))
     */
    public IntSet difference(IntSet other) {
        int hits = getCount();
        IntSet returnSet;
        for (int i = 0; i < other.getCount(); i++) {
            if (has(other.getArray()[i])) {
                hits--;
            }
        }
        returnSet = new IntSet(hits);
        for (int i = 0; i < getCount(); i++) {
            if (!other.has(getArray()[i])) {
                returnSet.add(getArray()[i]);
            }
        }
        return returnSet;
    }

    /**
     * Returns the symmetric difference of this set and another set.
     *
     * @param other the set to symmetric difference this set with
     * @return the symmetric difference
     * @pre other != null
     * @post forall int v: !(has(v) and other.has(v)) and (has(v) or
     * other.has(v)) implies return.has(v)
     * @post forall int v: has(v) and result.has(v) implies !other.has(v)
     * @post forall int v: other.has(v) and result.has(v) implies !has(v)
     */
    public IntSet symmetricDifference(IntSet other) {
        IntSet r1 = difference(other);
        IntSet r2 = other.difference(this);
        return r2.union(r1);
    }

    /**
     * Returns a representation of this set as an array
     *
     * @post return.length == getCount()
     * @post forall int v in return: has(v)
     */
    public int[] getArray() {
        int[] returnArray = new int[getCount()];
        System.arraycopy(set, 0, returnArray, 0, getCount());
        return returnArray;
    }

    /**
     * Returns the number of elements in the set.
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the maximal number of elements in the set.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns a string representation of the set. The empty set is represented
     * as {}, a singleton set as {x}, a set with more than one element like {x,
     * y, z}.
     */
    @Override
    public String toString() {
        String result = "{";
        for (int i = 0; i < getCount(); i++) {
            if (i != 0) {
                result += ", ";
            }
            result += set[i];
        }
        result += "}";
        return result;
    }
}
