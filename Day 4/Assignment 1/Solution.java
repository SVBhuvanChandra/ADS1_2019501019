/**
 * This is the solution class for Quick sorting.
 * @author Bhuvan
 */
class Solution {
	/**
	 * quickSort() method method takes the array and sorts the array.
	 * @param arr array to be sorted
	 * @return the array thats sorted
	 */
	public static int[] quickSort(final int[] arr) {
		Integer[] arr1 = new Integer[arr.length];
		int i = 0;
		for (int value : arr) {
			arr1[i++] = Integer.valueOf(value);
		}
		QuickSort.sort(arr1);
		int j = 0;
		for (Integer integer : arr1) {
			arr[j++] = integer;
		}
		return arr;
	}
}
