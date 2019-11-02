/**
 * . QuickSort implementation.
 */
public class QuickSort {
    /**
     *sort method takes the array to be sorted
     *
     * @param a array to be sorted
     */
    public static void sort(final Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    /**
     *sort method overloads the sort and takes the boundaries to be sorted
     * @param a  array to be soretd
     * @param lo low boundary
     * @param hi high boundary
     */
    private static void sort(final Comparable[] a, final int lo, final int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * partition method takes array and divides the array as per the pivot value
     * @param a  aray to be sorted
     * @param lo low boundary
     * @param hi high boundary
     * @return the position where the array id divided
     */
    private static int partition(final Comparable[] a, final int lo, final int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    /**
     * less method takes in the values to be cmpared.
     * @param v value1
     * @param w value2
     * @return true if less and false if not
     */
    private static boolean less(final Comparable v, final Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * exchanges the elements at positions passed
     * @param a array to be sorted
     * @param i first location.
     * @param j Second Location.
     */
    private static void exch(final Object[] a, final int i, final int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
