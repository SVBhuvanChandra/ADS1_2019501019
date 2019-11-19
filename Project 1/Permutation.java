import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;
/**.
 * Class permutataion. 
 */
public class Permutation {
    /**.
     * Main method.
     * @param args input arguments.
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        try {
            while (!StdIn.isEmpty()) {
                if ((StdIn.readString()) != null && (StdIn.readString()).length() > 0) {
                    rq.enqueue(StdIn.readString());
                }
            }
            for (int i = 0; i < k; i++) {
                StdOut.println(rq.dequeue());
            }
        } catch (NoSuchElementException e) {
            // This is expected
        }
        
    }
}