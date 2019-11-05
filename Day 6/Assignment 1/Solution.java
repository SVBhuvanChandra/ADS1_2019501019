/**
 * Solution class for finding the elements are in min heap or not..
 * @author Bhuvan
 */
class Solution{
	/**
	 * this method is used to find whether the array is following 
	 * min heap condition or not.
	 * @param arr input parameters.
	 * @return true if minaheap, else false.
	 */
	public static boolean isMinHeap(double[] arr){
		/**
		 * flag element to update in every condition.
		 */
		int flag = 1;
		// Order id time complexity is O(1)
		if (arr.length > 0) {
			// Time complexity id O(n).
			for (int k = arr.length-1; k > 1; k--) {
				if (arr[k/2] <= arr[k]) flag = 1;
				else flag = 0;
			}
		} else return false;
		// Time complexity O(1)
		if (flag == 1) return true;
		else return false;
	}
}