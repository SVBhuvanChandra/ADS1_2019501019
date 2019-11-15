import java.util.*;
import java.io.*;
/**
 * Class circular linked list implementation.
 * @@author Bhuvan
 */
public class CircularLL {
    /**
     * Field to store the size of the queue.
     */
    int size = 0;
    Node last = null;
    /**
     * Class node to create a linked list.
     */
    public class Node {
        /**
         * Field to store Node item.
         */
        int item;
        /**
         * Field to store Node reference.
         */
        Node next;
}   
    /**
     * method to check queue is empty or not.
     * @return true or false.
     * 
     * Order of complexity is O(1) = constant
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Method return size of queue.
     * @return size
     * 
     * Order of complexity is O(1) = constant
     */
    public int sizeof() {
        return size;
    }
    /**
     * Method to inser elements in the queue.
     * @param item
     * 
     * Order of complexity is O(1) = constant
     */
    public void enqueue(int item) {
        if (size == 0) {
            last = new Node();
            last.item = item;
            last.next = last;
        } else {
            Node temp = new Node();
            temp.item = item;
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        size++;
    }
    /**
     * Method to delete element in the queue.
     * @return integer deleted from the queue.
     * 
     * Order of complexity is O(1) = constant
     */
    public int dequeue() {
        if (size == 0) {
            // System.out.println("size is 0");
            return -1;
        } else {
            int val = last.next.item;
            last.next = last.next.next;
            size--;
            return val;
        }
    }
    /**
     * Main method to check the Circular linked list operations.
     * @param args input arguments.
     */
    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        cll.enqueue(10);
        cll.enqueue(20);
        cll.enqueue(30);
        System.out.println(cll.sizeof());
        System.out.println(cll.isEmpty());
        System.out.println(cll.dequeue());
        System.out.println(cll.dequeue());
        System.out.println(cll.dequeue());
        System.out.println(cll.dequeue());

    }
}