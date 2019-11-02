/**
 * A class for InsertionSort implementation.
 */
public class InsertionSort {

    /**
     * Sorting function implemenataion.
     * @param arr array that has to be sorted.
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (maxi(arr[j], arr[j - 1])) {
                    exch(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * maxi() method checks if the object is maxier or not.
     * @param v object
     * @param w oject
     * @return true if maxier, false if not.
     */
    private static boolean maxi(final Comparable v, final Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * exch method swaps the two objects.
     *
     * @param arr array
     * @param i   first location
     * @param j   next location.
     */
    private static void exch(Comparable[] arr, final int i, final int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
