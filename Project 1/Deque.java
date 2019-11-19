import java.util.NoSuchElementException;
import java.util.Iterator;
/**.
 * Class Dequeue.
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
// public class Deque<Item> {
    /**.
     * Field for first.
     */
    private Node first;
    /**.
     * Field for last.
     */
    private Node last;
    /**.
     * Field for size.
     */
    private int siz;
    /**.
     * Class Node.
     * @param <Item> item.
     */
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
    // construct an empty deque
    /**.
     * Constructor Dequeue.
     */
    public Deque() {
        first = null;
        last = null;
        siz = 0;
    }

    // is the deque empty?
    /**.
     * Method to check queue is empty.
     * @return true of false.
     */
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    /**.
     * Method to check size.
     * @return size.
     */
    public int size() {
        return siz;
    }

    // add the item to the front
    /**.
     * Insert element in the queue.
     * @param item item.
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (siz == 0) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node temp = first;
            first = new Node();
            first.item = item;
            first.next = temp;
            temp.prev = first;
        }
        siz++;
    }
    // add the item to the back
    /**.
     * Method to insert element in the last.
     * @param item item.
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node temp = new Node();
        temp.item = item;
        if (last != null) {
            temp.prev = last;
            last.next = temp; 
        }
        last = temp;
        if (first == null) {
            first = last;
        }
        siz++;
    }
    // remove and return the item from the front
    /**.
     * Method to remove element form the first.
     * @return item.
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
            if (siz == 1) {
                last = null;
                first = null;
                // siz--;
                // return item;
        } else {
            first.next.prev = null;
            first = first.next;
            // siz--;
            // return item;
        }
        siz--;
        return item;
    }

    // remove and return the item from the back
    /**.
     * Method to rmeove the element form the last.
     * @return item.
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } 
        Item item = last.item;
        if (siz == 1) {
            last = null;
            first = null;
            // siz--;
            // return item;
        } else {
            last.prev.next = null;
            last = last.prev;
            // siz--;
            // return item;
        }
        siz--;
        return item;
    }
    // private void showList() {
    //     for (Node i = first; i != null; i = i.next){
    //         System.out.println(i.item);
    //     }
    // }

    // return an iterator over items in order from front to back
    /**.
     * class iterator.
     */
    public Iterator<Item> iterator() {
        return new LinkedListIterator(first);
    }
    /**.
     * Class linked list.
     * @param <Item> item.
     */
    private class LinkedListIterator implements Iterator<Item> {
        private Node current;
        /**.
         * Constructor.
         * @param first first.
         */
        public LinkedListIterator(Node first) {
            current = first;
        }
        /**.
         * Method has Next.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**.
         * Method remove.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**.
         * Method next.
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    /**
     * Main method.
     * @param args input args.
     */
    public static void main(String[] args) {
        // Deque dq = new Deque();
        // dq.addFirst("to");
        // dq.addFirst("Welcome");
        // dq.addLast("ADS");
        // Iterator<String> it = dq.iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println(dq.size());
        // System.out.println(dq.isEmpty());
        // System.out.println(dq.removeFirst());

        // for(Node i = dq.first; i != null; i=i.next)
        // System.out.println(dq.i.item);
        // dq.showList();

    }

}