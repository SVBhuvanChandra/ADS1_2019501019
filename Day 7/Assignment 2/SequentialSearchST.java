import java.util.*;
/**
 * Class for implementig the sequential search.
 * @author Bhuvan
 * @param <Key> key
 * @param <Value> value
 */
public class SequentialSearchST<Key, Value> {
    /**
     * Field to hold the keys.
     */
    Key[] keys;
    /**
     * Field to hold the values.
     */
    Value[] values;
    /**
     * Field to hold the size.
     */
    int size;
    /**
     * Construtor for the above class.
     */
    public SequentialSearchST() {
        keys = (Key[]) new Comparable[10];
        values = (Value[]) new Object[10];
        size = 0;
    }
    /**
     * this method is to insert the keys and values.
     * @param k key
     * @param v value
     */
    public void put(Key k, Value v) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)) {
                values[i] = v;
                return;
            }
        }
        keys[size] = k;
        values[size] = v;
        size++;
        if (size == keys.length) {
            resize();
        }
    }
    /**
     * Method to get the value associated with key.
     * @param k key
     * @return value
     */
    public Value get(Key k) {
        if (size == 0) {
            return null;
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)) {
                index = i;
            }
        }
        if (index < 0) {
            return null;
        }
        Key temp = keys[index];
        Value result = values[index];
        for (int j = index; j > 0; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[0] = temp;
        values[0] = result;
        return result;
    }
    /**
     * Method to convert into string format.
     */
    public String toString() {
        String str = "";
        for (int i = size - 1; i >= 0; i--) {
            str += keys[i] + " ";
        }
        return str;
    }
    /**
     * Method to resize the arrays.
     */
    public void resize() {
        keys = Arrays.copyOf(keys, 2*size);
        values = Arrays.copyOf(values, 2*size);
    }
    /**
     * Method to find the key is available or not.
     * @param k key
     * @return true / fasle
     */
    public boolean contains(Key k) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)) {
                return true;
            }
        }
        return false;
    }
}