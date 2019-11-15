import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Random;
public class RandomizedQueue<Item> implements Iterable<Item> {
    Item[] arr;
    int siz;
    int i = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[1000];
        siz = 0;
    }
    // is the randomized queue empty?
    public boolean isEmpty() {
        return siz == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return siz;
    }
    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        arr[i++] = item;
        siz++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Random r = new Random();
        int a = r.nextInt(siz);
        Item b = arr[a];
        for (int i = a; i < siz; i++) {
            arr[i] = arr[i + 1];
        }
        siz--;
        return b;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Random r1 = new Random();
        int ind = r1.nextInt(siz);
        return arr[ind];
    }

    // return an independent iterator over items in random order
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
            if(!hasNext()) {
                return null;
            }
            Item e = arr[j];
            j++;
            return e;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> str = new RandomizedQueue();
        str.enqueue("Hello!!");
        str.enqueue("World");
        System.out.println(str.size()); 
        System.out.println(str.isEmpty());
        System.out.println(str.sample());
        System.out.println(str.dequeue());
    }

}