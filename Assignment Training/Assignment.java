import java.util.*;
import java.io.*;
/**
 * A class created for the assignemt.
 * @@author Bhuvan
 */
public class Assignment {
    /**
     * Main method of the class.
     * @param args input arguments.
     */
    public static void main(String[] args) {
        /**
         * Field to store the max value.
         */
        double max;
        /**
         * Field to store the min value.
         */
        double min;
        Scanner scan = new Scanner(System.in);
        /**
         * Field to store the input from the client in string format.
         */
        String inp = scan.nextLine();
        /**
         * Field to the list elemnts in an array in string formats.
         */
        String[] iarr = inp.split(",");
        /**
         * Field to store the elements after type casting to double.
         */
        double[] darr = new double[iarr.length];
        for (int i = 0; i < iarr.length; i++) {
            darr[i] = Double.parseDouble(iarr[i]);
        }
        max = darr[0];
        min = darr[0];

        // time complexity is : O(n) to find the min value.

        System.out.println(Arrays.toString(darr));
        for (int i = 1; i < darr.length; i++) {
            if (darr[i] < min) {
                min = darr[i];
            }
        }
        
        // time complexity is : O(n) to find the max value.

        for (int i = 1; i < darr.length; i++) {
            if (darr[i] > max) {
                max = darr[i];
            }
        }
        // in any pair of the elements, the differece between min
        // and max values is always greater than the difference of
        // any other pair elements. 
        // Henece the farthest elements in the list are.
        System.out.println("\nThe farthest pair elements :"+ min +" and "+ max);
    }
}