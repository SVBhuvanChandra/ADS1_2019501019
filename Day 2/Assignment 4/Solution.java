import java.util.*;
/**
 * Solutuon for josephus problem.
 * @author Bhuvan..
 */
class Solution{
	/**
	 * Method josephus() will take inputs in the linked
	 * and performs queue operations.
	 * @param a input1
	 * @param b input2
	 * @return String 
	 */
	public static String Josephus(int a, int b){
		/**
		 * Field to hold output string.
		 */
		String s = "";
		/**
		 * Implementing the Queue using linked lists. 
		 */
		Queue<Integer> queue = new LinkedList<>();
		for (int t = 0; t < a; t++) {
			queue.add(t);
		}
		while (queue.size() > 1) {
			for (int k = 0; k < b-1; k++) {
				int a1 = queue.remove();
				queue.add(a1);
			}
			s = s + queue.remove() + " ";
		}
		s = s+queue.remove();
		return s;
	}
}
