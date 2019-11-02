/**
 * Implementing stack by using linked list.
 * @author Bhuvan
 */

public class LinkedListStack {
    Node head;
    class Node {
        char item;
        Node next;

        Node(char item) {
            this.item = item;
        }
    }
    public boolean isEmpty() {
         return head == null;
    }
    public void push(char item) {
         Node oldHead = head;
         head = new Node(item);
         head.next = oldHead;
    }
    public char pop() {
         char item = head.item;
         head = head.next;
         return item;
    }
}