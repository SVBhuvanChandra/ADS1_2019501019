/**
 * This is soultion class, the implementaions of Select and Insertion sorts.
 */
class Solution{
	/**
	 * Insertion sort implementation method and two two loops are
	 * iterating and hence the time complexity is O(n2) [n square].
	 * @param arr is the array to be sorted.
	 * @return a sorted array.
	 */
    public int[] sortInsertion(int[] arr){
		// Outer loop runnning array length times.
        for(int i = 0; i < arr.length; i++) {
			// inner loop running i times.
            for(int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j , j-1);
                } else {
                    break;
                }
            }
        }
        return arr;
	}
	/**
	 * Selection sort implementation and two loops are iterating
	 * and hence the time complexity is O(n2) [n square].
	 * @param arr is the array to be sorted.
	 * @return a sorted array.
	 */
    public int[] sortSelection(int[] arr){
        // Outer loop runnning array length times.
        for(int i =0; i < arr.length; i++) {
			int min = i;
			// inner loop running i to array length times.
            for(int j =i+1; j< arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            } swap(arr, min, i);
        }
        return arr;
	}
	/**
	 * This is swapping funtion.
	 * @param arr is the input array.
	 * @param i iterating variable from outer loop.
	 * @param j iterating variable from inner loop.
	 */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
