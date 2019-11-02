/**
 *  Class implementation for MergeSort.
 */
public class MergeSort {

    /**
     * merge() method takes arrays and positions as
     * input and all the boundary values are the parameters for it.
     *
     * @param a   Actual array
     * @param aux Duplicalte array
     * @param lo  lower boundary
     * @param mid mid value
     * @param hi  upper boundary
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
     * sort() method takes arrays and positions as
     * inputs and lower and upper boundary as parameters.
     * @param a   Actual array
     * @param aux Duplicate array
     * @param lo  lower boundary
     * @param hi  upper boundary
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
     * method overloading of sort() method.
     * @param a array to be sorted.
     */
    public static void sort(final Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    /**
     * less() method for comaparision.
     * @param v value1
     * @param w value2
     * @return true if less and false if not
     */
    private static boolean less(final Comparable v, final Comparable w) {
        return v.compareTo(w) < 0;
    }
}
