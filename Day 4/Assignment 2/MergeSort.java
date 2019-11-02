/**
 *  Class implementation for MergeSort.
 */
public class MergeSort {

    /**
     * . merge sort method takes in the arrays and the boundaries
     *
     * @param a   original array
     * @param aux copied array
     * @param lo  low boundary
     * @param mid mid value
     * @param hi  high boundary
     */
    private static void merge(final Comparable[] a, final Comparable[] aux, final int lo, final int mid, final int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    /**
     * . sort method takes in the arrrays and boundaries
     *
     * @param a   original array
     * @param aux copied array
     * @param lo  low boundary
     * @param hi  high boundary
     */
    private static void sort(final Comparable[] a, final Comparable[] aux, final int lo, final int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * . overloaded sort method takes array to be sorted
     *
     * @param a array to be sorted
     */
    public static void sort(final Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    /**
     * . less method compares values
     *
     * @param v value1
     * @param w value2
     * @return true if less and false if not
     */
    private static boolean less(final Comparable v, final Comparable w) {
        return v.compareTo(w) < 0;
    }
}
