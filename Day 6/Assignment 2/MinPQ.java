/**
 * Class implementation for MinPQ.
 * @author Bhuvan
 */
class MinPQ {
    /**
     * Field to store the values in a priority queue.
     */
    double[] pq;
    /**
     * Field to store the size of the queue.
     */
    int N;
    /**
     * A constructor for MinPQ class.
     * @param capacity is the size of the queue.
     */
    MinPQ(int capacity) {
        pq = new double[capacity];
        N = 0;
    }
    /**
     * method to insert the element in the queue.
     * @param item input.
     */
    // Time complelxity is O(nlogn)
    public void insert(double item) {
        pq[++N] = item;
        swim(N);
    }
    /**
     * Method to delete the element from the queue.
     * @return min element from the queue.
     */
    // Time complelxity is O(1)
    public double delMin() {
        double min = pq[1];
        exch(1, N--);
        pq[N + 1] = 0d;
        sink(1);
        return min;
    }
    /**
     * Method to perform the swim operation.
     * @param k key
     */
    // Time complelxity is O(nlogn)
    public void swim(final int k) {
        int index = k;
        while (index > 1 && pq[index] < pq[index / 2]) {
            exch(index, index / 2);
            index = index / 2;
        }
    }
    /**
     * Method to perform the sink operation.
     * @param k key
     */
    // Time complelxity is O(nlogn)
    public void sink(int k) {
        int index = k;
        while (2*index <= N) {
            int j = 2*index;
            if (j < N && pq[j] > pq[j+1]) {
                j++;
            }
            if (pq[index] < pq[j]) {
                break;
            }
            exch(index, j);
            index = j;
        }
    }
    /**
     * Method to perform swapping.
     * @param a input1
     * @param b input2
     */
    public void exch(int a, int b) {
        double temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }
}