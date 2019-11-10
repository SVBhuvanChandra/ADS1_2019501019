import java.util.*;
/**
 * Class BST is extending the properties of comparable.
 * @author Bhuvan
 */
public class BST<Key extends Comparable<Key>,
Value extends Comparable<Value>> {
	/**
	 * root node.
	 */
	private Node root;

	/**
	 * This class describes a node
	 */
	private class Node {
		/**
		 * Stores the key
		 */
		private Key key;

		/**
		 * field stores the value
		 */
		private Value value;

		/**
		 * Left node reference.
		 */
		private Node left;

		/**
		 * right node reference.
		 */
		private Node right;

		/**
		 * filed holds the size of the node.
		 */
		private int counter;

		/**
		 * Constructs a new instance.
		 * @param key key
		 * @param value value
		 */
		Node(final Key key, final Value value) {
			this.key = key;
			this.value = value;
			this.counter = 0;
			this.left = null;
			this.right = null;
		}

		/**
		 * Constructs a new instance
		 * @param key key
		 * @param value value
		 * @param size size
		 */
		Node(final Key key, final Value value, final int counter) {
			this.key = key;
			this.value = value;
			this.counter = counter;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * Constructs a new instance.
	 */
	public BST() {
		this.root = null;
	}

	/**
	 * This method returns the size of the BST
	 * @return size
	 */
	public int size() {
		int count = size(root);
		return count;
	}

	/**
	 * This method is a helper method
	 * gives the size of the node that
	 * is passed as an argument.
	 *
	 * @param      node  The node
	 *
	 * @return     { size of the passed node }
	 */
	private int size(final Node node) {
		if (node == null) {
			return 0;
		}
		return node.counter;
	}

	/**.
	 * This method add the data to the
	 * BST.
	 *
	 * @param      key    The key
	 * @param      value  The value
	 */
	public void put(final Key key, final Value value) {
		if (key == null) {
			return;
		}
		root = put(root, key, value);
	}

	/**.
	 * This is a helper method
	 * that implements the insertion into
	 * the BST using recursion.
	 *
	 * @param      node   The node
	 * @param      key    The key
	 * @param      value  The value
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Node put(final Node node, final Key key, final Value value) {
		if (node == null) {
			Node newNode = new Node(key, value, 1);
			return newNode;
		}
		int compValue = key.compareTo(node.key);
		if (compValue < 0) {
			node.left = put(node.left, key, value);
		} else if (compValue > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		node.counter = 1 + size(node.left) + size(node.right);
		return node;
	}
	/**
	 * This method implements the non recurive version of the insert method
	 * @param  key key
	 * @param value value
	 */
	public void myPut(final Key key, final Value value) {
		if (root == null) {
			Node newNode = new Node(key, value, 1);
			root = newNode;
			return;
		}
		Node current = root;
		Node previous = null;
		boolean foundFlag = false;
		while (current != null) {
			previous = current;
			int compValue = key.compareTo(current.key);
			if (compValue < 0) {
				current = current.left;
			} else if (compValue > 0) {
				current = current.right;
			} else {
				current.value = value;
				foundFlag = true;
				break;
			}
		}
		if (foundFlag) {
			return;
		}		
		Node newNode = new Node(key, value, 1);
		if (key.compareTo(previous.key) < 0) {
			previous.left = newNode;
		} else if (key.compareTo(previous.key) > 0) {
			previous.right = newNode;
		}
		previous.counter = 1 + size(previous.left) + size(previous.right);
	}

	/**
	 * method to perform delete operation.
	 */
	public void delete(final Key key) {
		if (key == null) {
			return;
		}
		root = delete(root, key);
	}

	/**
	 * This method is a helper method that deletes the node
	 * @param node node
	 * @param key key
	 * @return Node
	 */
	private Node delete(final Node node, final Key key) {
		if (node == null) {
			return null;
		}
		int compValue = key.compareTo(node.key);
		if (compValue < 0) {
			node.left = delete(node.left, key);
		} else if (compValue > 0) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			node.key = min(node.right);
			node.right = delete(node.right, node.key);
		}
		return node;
	}
	/**
	 * This method deletes the minimum element
	 */
	public void deleteMin() {
		root = deleteMin(root);
		return;
	}
	/**
	 * Deletes the minimum node in that
	 *
	 * @param node node
	 * @return node.
	 */
	private Node deleteMin(final Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.counter = size(node.left) + size(node.right) + 1;
		return node;
	}
	/**
	 * deletes the maximum node
	 */
	public void deleteMax() {
		root = deleteMax(root);
		return;
	}

	/**
	 * Helper method to delete the node
	 * @param node node
	 * @return returns the updated subtree.
	 */
	private Node deleteMax(final Node node) {
		if (node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.counter = size(node.left) + size(node.right) + 1;
		return node;
	}
	/**.
	 * This is a helper method that returns the minimum node
     * in that part of the sub tree
	 * @param node  The node
	 * @return min node in that sub tree.
	 */
	private Key min(final Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current.key;
	}
	/**
	 * Gets the value associated with the specified key.
	 * @param key key
	 * @return value
	 */
	public Value get(final Key key) {
		if (key == null) {
			return null;
		}
		Value result = get(root, key);
		return result;
	}
	/**
	 * This method is a helper methods that traverses 
     * through the tree to find the key
	 * @param node node
	 * @param key key
	 * @return value of the key.
	 */
	private Value get(final Node node, final Key key) {
		Value result = null;
		if (node != null) {
			int compValue = key.compareTo(node.key);
			if (compValue < 0) {
				result = get(node.left, key);
			} else if (compValue > 0) {
				result = get(node.right, key);
			} else {
				result = node.value;
				return result;
			}
		}
		return result;
	}
	/**
	 * This method returns the minimum key in BST
	 * @return min key.
	 */
	public Key min() {
		Node current = root;
		if (current == null) {
			return null;
		}
		while (current.left != null) {
			current = current.left;
		}
		return current.key;
    }
	/**
	 * This method returns the max key in BST
	 * @return max key.
	 */
	public Key max() {
		Node current = root;
		if (current == null) {
			return null;
		}
		while (current.right != null) {
			current = current.right;
		}
		return current.key;
	}

	/**
	 * This method returns the key less than or equals
     * to the key in the argument.
	 * @param key key
	 * @return keys <= given key.
	 */
	public Key floor(final Key key) {
		if (key == null || size() == 0) {
			return null;
		}
		Node result = floor(root, key);
		if (result == null) {
			return null;
		}
		return result.key;
	}
	/**
	 * This method is a helper method to compute the floor of the node.
	 * @param node node
	 * @param key key
	 * @return floor
	 */
	private Node floor(final Node node, final Key key) {
		if (node == null) {
			return null;
		}
		int compValue = key.compareTo(node.key);
		if (compValue == 0) {
			return node;
		} else if (compValue < 0) {
			return floor(node.left, key);
		} else {
			Node temp = floor(node.right, key);
			if (temp != null) {
				return temp;
			} else {
				return node;
			}
		}
	}

	/**
	 * This method computes the ceiling of the key provided.
	 * @param key key
	 * @return returns keys >= key
	 */
	public Key ceiling(final Key key) {
		if (key == null) {
			return null;
		}
		Node result = ceiling(root, key);
		if (result == null) {
			return null;
		}
		return result.key;
	}
	/**
	 * This is helper method to compute the ceiling
	 * @param node node
	 * @param key key
	 * @return returns keys >= key
	 */
	private Node ceiling(final Node node, final Key key) {
		// base case
		if (node == null) {
			return null;
		}
		int compValue = key.compareTo(node.key);
		if (compValue == 0) {
			return node;
		} else if (compValue < 0) {
			Node temp = ceiling(node.left, key);
			if (temp != null) {
				return temp;
			} else {
				return node;
			}
		} else {
			return ceiling(node.right, key);
		}
	}

	/**
	 * This method gives the smallest key of the index.
	 * @param index
	 * @return value
	 */
	public Key select(final int index) {
		if (index < 0 || index > size()) {
			return null;
		}
		Node node = select(root, index);
		if (node == null) {
			return null;
		}
		return node.key;
	}

	/**
	 * This is the helper method for select
	 * @param node node
	 * @param index index
	 * @return value
	 */
	private Node select(final Node node, final int index) {
		if (node == null) {
			return null;
		}
		int temp = size(node.left);
		if (temp > index) {
			return select(node.left, index);
		} else if (temp < index) {
			return select(node.right, index - temp - 1);
		} else {
			return node;
		}
	}

	/**
	 * This method computes the rank of the given key
	 * @param key key
	 * @return count of keys less than the key.
	 */
	public int rank(final Key key) {
		int rank = 0;
		Node current = root;
		while (current != null) {
			int compValue = key.compareTo(current.key);
			if (compValue < 0) {
				current = current.left;
			} else if (compValue > 0) {
				// 1 - itself && size(current.left) - count of 
				// left subtree
				rank += 1 + size(current.left);
				current = current.right;
			} else if (compValue == 0) {
				rank += size(current.left);
			}
		}
		return rank;
	}

	/**
     * This method returns a queue with the data in BST
	 * @return queue
	 */
	public Iterable<Key> displayData() {
		Queue<Key> queue = new Queue<Key>();
		inorder(root, queue);
		return queue;
	}
	/**
	 * This method implements the inorder traversal to get the
	 * elements from the data.
	 * @param node node
	 * @param queue queue
	 */
	private void inorder(final Node node, final Queue queue) {
		if (node == null) {
			return;
		}
		inorder(node.left, queue);
		queue.enqueue(node.key);
		inorder(node.right, queue);
	}
}
