class Solution{
	public int[] sortInsertion(int[] arr) {
		// fill you code Here

		return null;
	}
	public int[] sortSelection(int[] arr) {
		// fill you code Here
		if (arr.length != 0) {
			int min = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if (min > arr[i]) {
					int temp = arr[i];
					arr[i] = min;
					min = temp;
				}
			}
		}
	}
}