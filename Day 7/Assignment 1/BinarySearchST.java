import java.util.*;
/**
 * Class implementation for binary search symbol table.
 * @param <Key> key
 * @param <Value> value
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * Field to store the keys.
     */
    Key[] keys;
    /**
     * Field to store the values.
     */
    Value[] values;
    /**
     * Field to store the size.
     */
    int size;
    /**
     * Constructor for the above class.
     */
    public BinarySearchST() {
        keys = (Key[]) new Comparable[10];
        values = (Value[]) new Object[10];
        /**
         * initialize size.
         */
        size = 0;
    }

    /**
     * This method is to insert the key with the help of rank() method.
     * @param k key
     * @param v value
     */
    // Time complexity is O(n)
    public void put(Key k, Value v) {
        if (v == null) {
            int i = rank(k);
            for (int j = i; j < size - 1; j++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            keys[size - 1] = null;
            values[size - 1] = null;
            size--;
            return;
        }
        // Update key
        int i = rank(k);
        if (i < size && keys[i].equals(k)) {
            values[i] = v;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = k;
        values[i] = v;
        size++;
        if (size == keys.length) {
            resize();
        }
    }

    /**
     * Returns true if it contains the key else false.
     * @param k key
     * @return true / false
     */
    public boolean contains(Key k) {
        int index = rank(k);
        if (keys[index] == null) {
            return false;
        }
        if (keys[index].equals(k)) {
            return true;
        }
        return false;
    }
    /**
     * Method returns the value if key is present else returns null.
     * @param k key
     * @return value or null.
     */
    // Time complexity is O(n)
    public Value get(Key k) {
        int index = rank(k);
        if (contains(k)) {
            return values[index];
        }
        return null;
    }

    /**
     * Method returns the maximum key.
     * @return max key or null
     */
    // Time complexity is O(n)
    public Key max() {
        if (size == 0) {
            return null;
        } else {
            return keys[size - 1];
        }
    }

    /**
     * Method return the number of positions less than key.
     * @param k key
     * @return position of the key.
     */
    // Time complexity is O(n)
    public int rank(Key k) {
        /**
         * Field to store the low key.
         */
        int lo = 0;
        /**
         * Field to store the high key.
         */
        int hi = size - 1;
        /**
         * Field to store the mid.
         */
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if ((keys[mid].compareTo(k)) < 0) {
                lo = mid + 1;
            } else if (keys[mid].compareTo(k) > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /**
     * Method to delete the minimim values of the keys and values.
     */
    // Time complexity is O(n)
    public void deleteMin() {
        for (int i = 0; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[size - 1] = null;
        values[size - 1] = null;
        size--;
    }
    /**
     * Method to return the keys and corresponding values.
     * @return keys array.
     */
    public Key[] keys() {
        return keys;
    }
    /**
     * Method to resize the array.
     */
    // Time complexity is O(n)
    public void resize() {
        keys = Arrays.copyOf(keys, 2*size);
        values = Arrays.copyOf(values, 2*size);
    }
    /**
     * Method to find the floor elements.
     * @param k key
     * @return floor value.
     */
    // Time complexity is O(n)
    public Key floor(Key k) {
        int i = rank(k);
        if (i < size && keys[i].equals(k)) {
            return keys[i];
        } else {
            return keys[i - 1];
        }
    }
    /**
     * Method is to write in string format.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += keys[i] + " ";
        }
        return str;
    }
}
