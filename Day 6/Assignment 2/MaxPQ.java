/**
 * Class implementation for MaxPQ.
 * @author Bhuvan
 */
class MaxPQ {
    /**
     * Field to store the values in a priority queue.
     */
    double[] pq;
    /**
     * Field to store the size of the queue.
     */
    int N;
    /**
     * A constructor for MaxPQ class.
     * @param capacity is the size of the queue.
     */
    MaxPQ(int capacity) {
        pq = new double[capacity];
        N = 0;
    }
    /**
     * Method to insert the elements in the queue.
     */
    public void insert(double item) {
        pq[++N] = item;
        swim(N);
    }
    /**
     * Method to delete the max item in the queue.
     */
    public double delMax() {
        double max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = 0d;
        return max;
    }
    /**
     * Performing swim action.
     * @param k key
     */
    public void swim(int k) {
        int index = k;
        while (index > 1 && pq[index] > pq[index / 2]) {
            exch(index, index / 2);
            index = index / 2;
        }
    }
    /**
     * Method to perform the sink.
     * @param k key.
     */
    public void sink(int k) {
        int index = k;
        while (2*index <= N) {
            int j = 2*index;
            if(j < N && pq[j] < pq[j+1]) {
                j++;
            }
            if (pq[index] > pq[j]) {
                break;
            }
            exch(index, j);
            index = j;
        }
    }
    /**
     * methpd to perform swapping.
     * @param a input1
     * @param b input2
     */
    public void exch(int a, int b) {
        double temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }
}