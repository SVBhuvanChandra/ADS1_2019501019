import java.util.*;
/**
 * Class for ThreeSum verification.
 * @author Bhuvan
 */
public class ThreeSum {
    int[] arr = {30, -40, -20, -10, 40, 0, 10, 5};
    int c;
    int count = 0;
    /**
     * Binary search implementation.
     * @param a array
     * @param k key
     * @return index of the key in the array.
     */
    public int binarySearch(int[] a, int k) {
        int low = 0;
        int high = a.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (k < a[mid]) {
                high = mid - 1;
            } else if (k > a[mid]) {
                low = mid + 1;
            } else {
                return a[mid];
            }
        }
        return -1;
    }
    /**
     * Main method to perform sort.
     * @param args input parameters.
     */
    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        Arrays.sort(t.arr);
        for (int i = 0; i < t.arr.length; i++) {
            for (int j = i+1; j < t.arr.length; j++) {
                t.c = -(t.arr[i] + t.arr[j]);
                int out = t.binarySearch(t.arr, t.c);
                if (out == t.c) {
                    if (t.arr[i] < t.arr[j]) {
                        if (t.arr[j] < out) {
                            t.count++;
                        }
                    } 
                    }
                }
            }
            System.out.println("The count is : " + t.count);
        }
    }
