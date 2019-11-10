import java.util.Arrays;
/**
 * Class ransom
 * @author Bhuvan
 */
public class Ransom {
    /**
     * Field to store objects
     */
    Node[] arr;
    /**
     * Constructor of the class.
     */
    public class Node {
        /**
         * Filed to store the key.
         */
        String key;
        /**
         * Filed to store the value.
         */
        int value;
        /**
         * Filed to store the next reference.
         */
        Node next;
        /**
         * Constructor Node.
         * @param k key
         */
        public Node(String k) {
            this.key = k;
            value = 1;
            next = null;
        }
    }
    /**
     * Constructor of the class
     */
    public Ransom(String[] s) {
        arr = new Node[2 * s.length];
        createDict(s);
    }
    /**
     * Method to find the hashcode.
     * @param k key
     * @return hash key
     */
    public int hash(String k) {
        return ((k.hashCode() & 0x7fffffff) % (arr.length)); 
     }
     /**
      * method to insert the key.
      * @param k key
      */
      // Time complexity O(n)
     public void put(String k) {
         if (k == null) {
             return;
         }
         int indx = hash(k); 
        if(arr[indx] == null) {
            arr[indx] = new Node(k);
            return;
        }
        for (Node x = arr[indx]; x != null; x = x.next) {
            if (x.key.equals(k)) {
                x.value = x.value + 1;
                return;
            }
        }
        Node head = new Node(k);
        head.next = arr[indx];
        arr[indx] = head;
     }
     /**
      * Method to find the value of the key.
      * @param k key
      * @return value.
      */
      // Time complexity O(n)
     public int get(String k) {
         int indx  = hash(k);
         for (Node x = arr[indx]; x != null; x = x.next) {
             if(x.key.equals(k)) {
                 return x.value;
             }
         }
         return 0;
     }
     /**
      * Method to create dictionary.
      * @param str string array.
      */
      // Time complexity O(n)
     public void createDict(String[] str) {
         for(int i = 0; i < str.length; i++) {
             put(str[i]);
         }    
     }
     /**
      * Method to check the key on the array.
      * @param that input.
      * @return true or false.
      */
      // Time complexity O(n)
     public boolean check(Ransom that) {
         for (int i = 0; i < this.arr.length; i++) {
            Node x = this.arr[i];
            while (x != null) {
                if (this.get(x.key) > that.get(x.key)) {
                    return false;
                }
                else {
                    x = x.next;
                }
            }
         }
         return true;
     }
     /**
      * Method to show the output string.
      */
      // Time complexity O(n)
     public void showString() {
         for (int i = 0; i < arr.length; i++) {
             Node x = arr[i];
             while(x != null) {
                 System.out.println(x.key + ", " + x.value);
                 x = x.next;
             }
         }
         System.out.println("==========");
     }
     /**
      * Main method()
      * @param args input arguments.
      */
     public static void main (String[] args) {
         String str = "I am kidnapper killoskar and I will kill your son";
         String[] xyz = str.split(" ");
         System.out.println(Arrays.toString(xyz));
         Ransom ransom = new Ransom(xyz);
         ransom.showString();
         String st1 = "killoskar is a kidnapper and he always says that he will kill your son if we dont give him money and he will say a dialogue that I am who I am and I am dangerous man";
         String[] magazine = st1.split(" ");
         Ransom maga = new Ransom(magazine);
         maga.showString();
         System.out.println(ransom.check(maga));
     }
}