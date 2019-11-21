import java.util.*;
import java.io.*;
/**
 * Class probability
 * @@author Bhuvan
 */
public class Probability {
    /**
     * Field to store the 10 pow 6 elements.
     */
    int[] arr = new int[1000000];
    /**
     * Field to store the length of the array.
     */
    int len = arr.length;
    /**
     * Field to store the count.
     */
    int count = 0;
    /**
     * Method to find the hash code.
     * @param k input key
     * @return hash key
     */
    public int hasher(int k) {
        return k;
    }
    /**
     * Method to insert the elements in tbe array.
     * 
     * Linear probing implementation. Time complexity - O(N) in worst case.
     * @param k input key.
     * @param ind index value.
     */
    public void put(int k, int ind) {
        int index = hasher(ind);
        int i;
        for(i = index; arr[i] != 0; i = (i + 1) % len) {
        }
        arr[i] = k;
    }
    /**
     * Main Method to check the probability of the inserted values.
     * @param args input arguments.
     */
    public static void main(String[] args) {
        Probability prob = new Probability();
        /**
         * Field to store the half filled elements.
         */
        int[] input = new int[500000];
        /**
         * Iterating item.
         */
        int j = 0;
        for (int e = 1; e < input.length+1; e++) {
            input[j++] = e;
        }
        Random rand = new Random();
        for (int p = 0; p < input.length; p++) {
            int ri = rand.nextInt(1000000);
            prob.put(input[p], ri);
        }
        for (int f = 1; f < prob.len+1; f= (f+100)) {
            if (prob.arr[f] != 0) {
                prob.count++;
            }
        }
        System.out.println("Probability is : " + prob.count/10000.00);
    }
}