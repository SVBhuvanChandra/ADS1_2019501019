import java.util.Arrays;
/**
 * Class Linear probing.
 * @author Bhuvan
 */
public class LinearProbing<Key, Value> {
    /**
     * Key array
     */
    Key[] keys;
    /**
     * Value array
     */
    Value[] values;
    /**
     * Constructor of the above class.
     * @param ks key array
     * @param vs Value array
     */
    public LinearProbing(Key[] ks, Value[] vs) {
        keys = (Key[]) new Object[ks.length * 100];
        values = (Value[]) new Object[ks.length * 100];
        createDict(ks, vs);
    }
    /**
     * Method to find the hashcode.
     * @param k key
     * @return hash key
     */
    public int hash(Key k) {
        return ((k.hashCode() & 0x7fffffff) % (keys.length));
    }
    /**
     * Method to inser the key
     * @param k key
     * @param v value
     */
    // Time complexity O(n)
    public void put(Key k, Value v) {
        if (k == null) {
            return;
        }
        int index = hash(k);
        int i;
        for(i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                values[i] = v;
                return;
            }
        }
        keys[i] = k;
        values[i] = v;
    }
    /**
     * Method to find the key and value.
     * @param k key
     * @return value
     */
    // Time complexity O(n)
    public Value get(Key k) {
        if (k == null) {
            return null;
        }
        int index = hash(k);
        for (int i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                return values[i];
            }
        }
        return null;
    }
    /**
     * Method to delete the key.
     */
    // Time complexity O(n)
    public void delete(Key k) {
        if (k == null) {
            return;
        }
        int index = hash(k);
        for (int i = index; keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(k)) {
                keys[i] = null;
                values[i] = null;
                for (int j = i + 1; keys[j] != null; j = (j + 1) % keys.length) {
                    if (hash(keys[j]) != index) {
                        return;
                    }
                    put(keys[j], values[j]);
                    keys[j] = null;
                    values[j] = null;
                }
                return;
            }
        }
    }
    /**
     * Method to create a dictionary.
     * @param k key
     * @param v value
     */
    // Time complexity O(n)
    public void createDict(Key[] k, Value[] v) {
        for (int i = 0; i < k.length; i++) {
            put(k[i], v[i]);
        }
    }
    /**
     * Method to display the key.
     */
    // Time complexity O(n)
    public void display() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null){
            System.out.println(keys[i] + ", " + values[i]);
            }
        }
        System.out.println("==================");
    }
    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        String str = "Bhuvan always beleives that hardwork will always beats the tallent";
        String[] test1_keys = str.split(" ");
        System.out.println(Arrays.toString(test1_keys));
        Integer[] test1_vals = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(Arrays.toString(test1_vals));
        LinearProbing<String, Integer> lp1 = new LinearProbing(test1_keys, test1_vals);
        lp1.display();
    }
}
