import java.util.NoSuchElementException;
import java.util.Iterator;
public class Deque<Item> implements Iterable<Item> {
// public class Deque<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int siz;

    public class Node<Item>{
        private Item item;
        private Node<Item> next;
        private Node<Item> prev; 
    }
    // construct an empty deque
    public Deque(){
        first = null;
        last = null;
        siz = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return siz;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException(); 
        }
        if (isEmpty()) {
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
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            first = last;
        } else {
            Node temp = last;
            last = new Node();
            last.item = item;
            last.prev = temp;
            temp.next = last;
        }
        siz++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (siz == 1) {
            Item item = first.item;
            first = null;
            siz--;
            return item;
        } else {
            Item item = first.item;
            first.next = first;
            first.prev = null;
            siz--;
            return item;
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (siz == 1) {
            Item item = last.item;
            last = null;
            siz--;
            return item;
        } else {
            Item item = last.item;
            last.prev = last;
            last.next = null;
            siz--;
            return item;
        }
    }
    // private void showList() {
    //     for (Node i = first; i != null; i = i.next){
    //         System.out.println(i.item);
    //     }
    // }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new LinkedListIterator<Item>(first);
    }
    private class LinkedListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public LinkedListIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
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
    public static void main(String[] args){
        Deque dq = new Deque();
        dq.addFirst("to");
        dq.addFirst("Welcome");
        dq.addLast("ADS");
        Iterator<String> it = dq.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(dq.size());
        System.out.println(dq.isEmpty());
        System.out.println(dq.removeFirst());

        // for(Node i = dq.first; i != null; i=i.next)
        // System.out.println(dq.i.item);
        // dq.showList();

    }

}