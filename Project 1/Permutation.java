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
        int i = 0;
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        try {
            while (!StdIn.isEmpty()) {
                if (StdIn.readString() != null) {
                    rq.enqueue(StdIn.readString());
                }
            }
            while (i < Integer.parseInt(args[0])) {
                StdOut.println(rq.dequeue());
                i++;
            }
        } catch (NoSuchElementException e) {
            // This is expected
        }
        
    }
}