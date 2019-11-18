import java.util.*;
import java.io.*;
/**
 * Class to perform Min PQ.
 */
class Miniproof {
    /**
     * Field to store the integer array.
     */
    int[] pq;
    /**
     * Field to store the Size of the PQ.
     */
    int N;
    /**
     * Construtor for the class.
     * @param c
     */
    Miniproof(int c) {
        pq = new int[c];
        N=0;
    }
    /**
     * Method to inser the element in the PQ.
     * @param item integer
     * Complexity is O(1).
     */
    public void insert (int item) {
        pq[++N] = item;
        swim(N);
    }
    /**
     * Method to delete the element in the PQ.
     * @return min
     * Complexity is O(1)
     */
    public int delMin() {
        int min = pq[1];
        exch(1, N--);
        pq[N + 1] = 0;
        sink(1);
        return min;
    }
    /**
     * Method to perform swim operation, the inserted element will
     * reaches its index value by satisfying the Min heap peroperties.
     * @param k integer
     * Complexity is O(log N)
     */
    public void swim(int k) {
        while (k > 1 && pq[k] < pq[k / 2]) {
            exch(k, k/2);
            k = k/2;
        }
    }
    /**
     * Method to perform sink operation, the replaced element after deletion will
     * reaches its index value by satisfying the Min heap peroperties.
     * @param k integer
     * Compelxity is O(log N)
     */
    public void sink (int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && pq[j] > pq[j+1]) {
                j++;
            }
            if (pq[k] < pq[j]) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * Method to return the MINIMUM value in the PQ.
     * @return MIN element
     * Complexity is O(1)
     */
    public int mini() {
        return pq[1];
    }
    /**
     * Method to perform the swap opeartion.
     */
    public void exch(int a, int b) {
        int temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }
    /**
     * Main method
     * @param args input arguments.
     */
    public static void main(String[] args) {
        Miniproof mp = new Miniproof(11);
        int f=0;
        int[] test = {8, 2, 1, 3, 5, 4, 10, 6, 9, 7};
        int k = 4;
        int[] deleted = new int[test.length - k];
        for (int i = 0; i < test.length; i++) {
            mp.insert(test[i]);
        }
        for (int i = 0; i < test.length - k; i++) {
            deleted[f++] = mp.delMin();
        }
        System.out.println("\nThe deleted elements are : \n");
        System.out.println(Arrays.toString(deleted));
        System.out.println("\nThe MINIMUM element in remaining elements : "+ mp.mini());
        if (deleted[deleted.length - 1] < mp.mini()) {
            System.out.println("\nAs the MINIMUM element in the remaining elements of the queue is greater than");
            System.out.println("the all deleted elements, therefore we proove that the remaining elemements are obviously greater than the deleted.\n");
        }
    }
}