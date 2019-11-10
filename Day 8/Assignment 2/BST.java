import java.util.Arrays;
/**
 * Class BST extends comparable.
 * @author Bhuvan
 * @param <Value>
 */
public class BST<Value extends Comparable<Value>> {
	/**
	 * Field to store the data.
	 */
	private Value[] data;
	/**
	 * This array stores the index of the left child of the element.
	 */
	private int[] left;
	/**
	 * This array stores the index of the right child of the element.
	 */
	private int[] right;
	/**
	 * counter variable.
	 */
	private int counter;
	/**
	 * Left elements counter.
	 */
	private int leftCounter;

	/**
	 * Right elements counter.
	 */
	private int rightCounter;

	/**
	 * Field to store the size.
	 */
	private final int defaultSize = 50;

	/**
	 * Constructs a new instance.
	 */
	public BST() {
		this.data = (Value[]) new Comparable[defaultSize];
		this.left = new int[defaultSize];
		this.right = new int[defaultSize];
		this.counter = 0;
	}

	/**
	 * Constructs a new instance.
	 * @param capacity capacity
	 */
	public BST(final int capacity) {
		this.data = (Value[]) new Comparable[capacity];
		this.counter = 0;
	}
	/**
	 * This method inserts the element into the array
	 * @param value value
	 */
	public void put(final Value value) {
		int index = 0;
		if (counter == 0) {
			data[counter++] = value;
			return;
		}

		if (counter == data.length) {
			resize();
		}

		while (data[index] != null) {
			int compValue = value.compareTo(data[index]);
			if (compValue < 0) {
				index = (2 * index) + 1;
			} else if (compValue > 0) {
				index = (2 * index) + 2;
			} else {
				data[index] = value;
				return;
			}
		}
		data[index] = value;
		counter++;
	}
	/**
	 * This method updates the left array index and the right array index
	 */
	public void setChildIndexes() {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				continue;
			}
			int leftChildIndex = getLeftChildIndex(i);
			int rightChildIndex = getRightChildIndex(i);
			System.out.println("Parent: " + data[i]
				+ " Left: " + leftChildIndex
			 + " Right: " + rightChildIndex);
			left[leftCounter++] = leftChildIndex;
			right[rightCounter++] = rightChildIndex;
		}
	}
	/**
	 * Gets the left child index
	 * @param index index
	 * @return left child index.
	 */
	private int getLeftChildIndex(final int index) {
		int childIndex = (2 * index) + 1;
		if (data[childIndex] == null) {
			return -1;
		}
		return childIndex;
	}
	/**
	 * Gets the right child index.
	 * @param index index
	 * @return right child index.
	 */
	private int getRightChildIndex(final int index) {
		int childIndex = (2 * index) + 2;
		if (data[childIndex] == null) {
			return -1;
		}
		return childIndex;
	}
	/**
	 * Gets the specified value.
	 * @param value value
	 * @return value.
	 */
	public Value get(final Value value) {
		int index = 0;
		int compValue = value.compareTo(data[index]);
		while (compValue != 0) {
			if (compValue < 0) {
				index = (2 * index) + 1;
				if (data[index] == null) {
					break;
				}
			} else {
				index = (2 * index) + 2;
				if (data[index] == null) {
					break;
				}
			}
			compValue = value.compareTo(data[index]);
		}
		return data[index];
	}
	/**
	 * method displays the data
	 */
	public void displayData() {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				continue;
			}
			System.out.println("Index: " + i
				+ " Value: " + data[i]);
		}
		System.out.println("*****************************");
		System.out.println("The left child index array: ");
		int[] tempLeft = Arrays.copyOf(this.left, this.leftCounter);
		int[] tempRight = Arrays.copyOf(this.right, this.rightCounter);
		System.out.println(Arrays.toString(tempLeft));
		System.out.println("The Right child index array: ");
		System.out.println(Arrays.toString(tempRight));
	}

	/**
	 * This method performs the resize operation
	 */
	private void resize() {
		Value[] temp = Arrays.copyOf(this.data, this.data.length * 2);
		this.data = temp;
	}
	/**
	 * Main method
	 * @param args input arguments
	 */
	public static void main(final String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.put(5);
		bst.put(1);
		bst.put(6);
		bst.put(2);
		bst.put(7);
		System.out.println(bst.get(5));
		System.out.println(bst.get(7));
	}
}