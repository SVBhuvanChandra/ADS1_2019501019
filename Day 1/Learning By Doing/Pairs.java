import java.util.*;
/**
 * Pairs class to find the number of paired elements
 * in the given array.
 * @author Bhuvan
 */
public class Pairs {
    /**
     * Main method to perform the sort.
     * @param args input parameters.
     */
    public static void main (String[] args) {
        System.out.println("Enter no. of elements\n");
        /**
         * Implemeting scanner to scan input from terminal.
         */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        s.close();
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            }
        }
        System.out.println("\nThe no. of pairs : " + count);
    }
}