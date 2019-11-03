import java.io.*;
import java.util.*;
/**
 * StringStack class to perform stack methods.
 * @author Bhuvan.
 */
public class StringStack {
    /**
     * Main method implementation.
     * @param args input parameters.
     */
    public static void main(String[] args) {
        /**
         * Input string.
         */
        String s = "it was - the best - of times - - - it was - the - -";
        /**
         * Implementening the Stack data structure.
         */
        Stack <String> a = new Stack<>();
        /**
         * Field to hold string array.
         */
        String[] sa = s.split(" ");
        for (int i = 0; i < sa.length; i++) {
            if (sa[i].equals("-")) {
                a.pop();
            } else {
                a.push(sa[i]);
            }
        }
        System.out.println("\nThe output in java stack is : " + a);

    }
}