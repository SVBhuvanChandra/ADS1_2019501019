/**
 * Class BSTCheck to find the given tree is satisfying BST property or not ?
 * @@author Bhuvan
 */
public class BSTCheck {
	/**
	 *Initializing a new Node x.
	 */
	Node x;
	/**
	 * Class Node.
	 */
	public class Node {
		/**
		 * Field to store the Node item.
		 */
		int item;
		/**
		 * Filed to store the left Node.
		 */
		Node left;
		/**
		 * Field to store the right node.
		 */
		Node right;
		/**
		 * Constructor to create a Node.
		 * @param item integer element.
		 */
		public Node(int item) {
			this.item = item;
			this.left = null;
			this.right = null;
		}
	}
	/**
	 * A general insertion method which inserts the elements in the tree.
	 * @param items element array.
	 */
	public void put(int[] items) {
		/**
		 * Iterating variable.
		 */
		int i = 0;
		x = new Node(items[i++]);
		x.left = new Node(items[i++]);
		x.right = new Node(items[i++]);
		x.left.left = new Node(items[i++]);
		x.left.right = new Node(items[i++]);
		x.right.left = new Node(items[i++]);
		x.right.right = new Node(items[i++]);
	}
	/**
	 * Method to check the tree is satisfying the BST property or not?
	 * 
	 * The Time complexity is O(N).
	 * @param n root node.
	 * @param min min node.
	 * @param max max node.
	 * @return true or false.
	 */
	public boolean isOrdered(Node n, Node min, Node max) {
		if (n == null) {
			return true;
		}
		min = n.left;
		max = n.right;
		if (min != null && min.item > n.item) {
			return false;
		}
		if (max != null && max.item < n.item) {
			return false;
		}
		return (isOrdered(n.left, min, max) && isOrdered(n.right, min, max));
	}
	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		BSTCheck bc = new BSTCheck();
		int[] input = {5, 3, 7, 2, 4, 6, 8};
		bc.put(input);
		System.out.println(bc.isOrdered(bc.x, bc.x.left, bc.x.right));

	}
}