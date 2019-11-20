import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
/**.
 * Class randomized queue.
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    /**.
     * Field to store item array.
     */
    private Item[] arr;
    /**.
     * Field to store the size.
     */
    private int siz;
    /**.
     * Constructor.
     */
    public RandomizedQueue() {
        arr = (Item[]) new Object[10];
        siz = 0;
    }
    /**.
     * Checks the queue is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return siz == 0;
    }
    /**.
     * returns the size.
     * @return size.
     */
    public int size() {
        return siz;
    }
    // add the item
    /**.
     * Method to insert the item.
     * @param item item.
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (siz >= 0.5 * (arr.length)) {
            resize();
        }
        arr[siz++] = item;
        // siz++;
    }

    // remove and return a random item
    /**
     * Method to delete the element.
     * @return item.
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // Random r = new Random();
        int r = StdRandom.uniform(siz);
        // int a = r.nextInt(siz);
        Item b = arr[r];
        arr[r] = null;
        int w = r;
        while (w < siz) {
            arr[w] = arr[w + 1];
            w++;
        }
        // for (int w = r; w < siz; w++) {
        //     arr[w] = arr[w + 1];
        // }
        siz--;
        return b;
    }
    /**.
     * Method resize.
     */
    private void resize() {
        if (siz >= 0.5 * (arr.length)) {
            arr = Arrays.copyOf(arr, 2 * arr.length);
        } else if (siz <= 0.25 * (arr.length)) {
            arr = Arrays.copyOf(arr, (1/2) * arr.length);
        }
    }

    // return a random item (but do not remove it)
    /**
     * Method to show the sample of the queue.
     * @return item.
     */
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // Random r1 = new Random();
        int ind = StdRandom.uniform(siz);
        return arr[ind];
    }

    // return an independent iterator over items in random order
    /**.
     * Method iterator.
     */
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }
    private class RandomIterator implements Iterator<Item> {
        int j;
        public boolean hasNext() {
            return j < siz;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) {
                return null;
            }
            Item e = arr[j];
            j++;
            return e;
        }
    }

    // unit testing (required)
    /**.
     * Main method. 
     * @param args
     */
    public static void main(String[] args) {
        // RandomizedQueue<String> str = new RandomizedQueue();
        // str.enqueue("Hello!!");
        // str.enqueue("World");
        // System.out.println(str.size());  
        // System.out.println(str.isEmpty());
        // System.out.println(str.sample());
        // System.out.println(str.dequeue());
    }
}