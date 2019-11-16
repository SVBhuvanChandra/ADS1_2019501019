import java.util.Arrays;
/**
 * Cards class which implements the Comparable.
 * In this class we have used Quick sort class.
 * @@author Bhuvan
 */
public class Cards implements Comparable<Cards> {
    /**
     * Field to store the face card.
     */
    String key;
    /**
     * Field to store the face card value
     */
    int value;
    /**
     * Constructor of the Cards class.
     * @param key face card
     * @param value face card value
     */
    public Cards(String key, int value) {
        this.key = key;
        this.value = value;
    }
    /**
     * Field to store the sixe of the array.
     */
    static int size;
    /**
     * Method to compare the face card values.
     */
    public int compareTo(Cards p) {
        return this.value - p.value;
    }
    /**
     * Methods to represent in string method.
     */
    public String toString() {
        return (key);
    }
    /**
     * Main method.
     * @param args input arguments.
     */
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        Cards[] arr = new Cards[52];
        size = 0;
        /**
         * Feild to store the face cards keys.
         */
        String[] keys = {"SA", "HA", "CA", "DA", "S2", "H2", "C2", "D2", "S3", "H3", "C3", "D3", "S4", "H4", "C4", "D4", "S5", "H5", "C5", "D5", "S6", "H6", "C6", "D6", "S7", "H7", "C7", "D7", "S8", "H8", "C8", "D8", "S9", "H9", "C9", "D9", "S10", "H10", "C10", "D10", "SJ", "HJ", "CJ", "DJ", "SQ", "HQ", "CQ", "DQ", "SK", "HK", "CK", "DK"};
        /**
         * Feild to store the face card values.
         */
        int[] values = {1, 14, 27, 40, 2, 15, 28, 41, 3, 16, 29, 42, 4, 17, 30, 43, 5, 18, 31, 44, 6, 19, 32, 45, 7, 20, 33, 46, 8, 21, 34, 47, 9, 22, 35, 48, 10, 23, 36, 49, 11, 24, 37, 50, 12, 25, 38, 51, 13, 26, 39, 52};
        for (int i = 0; i < keys.length; i++) {
            arr[size++] = new Cards(keys[i], values[i]);
        }
            // implementing the quick sort method which performs O(n logn) complexity in this case.
            q.sort(arr);
            System.out.println("\n");
            System.out.println(Arrays.toString(arr));
            System.out.println("\n");
    }
}