import java.util.*;
/**
 * Class BinarySearch symbol table.
 * @@author Bhuvan
 */
public class BinarySearchST {
    /**
     * Field to store the keys.
     */
    int[] keys;
    /**
     * Field to store the size.
     */
    int size;
    /**
     * Constructor for the above class.
     */
    public BinarySearchST() {
        keys = new int[10];
        size = 0;
    }
    /**
     * Method to insert element in the array.
     * the order of complexity will vary as per the condition.
     * @param k element
     */
    public void put(int k) {
        if (size == 0) {
            keys[size] = k;
            size++;
            return;
        }
        // If the input key is less the current element in the array then,
        // it will be inserted with constant compelxxity ie., O(N).
        if (keys[size - 1] < k) {
            keys[size++] = k;
        }
        // else input key is greater than the current element in the array then,
        // it will find its position by using rank() function, which needs O(log N) complexity internally. 
        else {
            int i = rank(k);
            for (int j = size; j > i; j--) {
                keys[j] = keys[j - 1];
            }
            keys[i] = k;
            size++;
        }
    }
    /**
     * Method return the number of positions less than key.
     * @param k key
     * @return position of the key.
     */
    // Time complexity is O(log N)
    public int rank(int k) {
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
            if (keys[mid] < k) {
                lo = mid + 1;
            } else if (keys[mid] > k) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
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
    public static void main(String[] args) {
        BinarySearchST bsst = new BinarySearchST();
        bsst.put(10);
        bsst.put(2);
        bsst.put(3);
        bsst.put(5);
        bsst.put(4);
        bsst.put(8);
        bsst.put(7);
        bsst.put(6);
        bsst.put(1);
        bsst.put(9);
        System.out.println(bsst.toString());
    }
}
