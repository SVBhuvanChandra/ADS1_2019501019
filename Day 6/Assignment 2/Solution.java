import java.util.*;
/**
 * Class solution to perform the median calaculation dynamically.
 * @author Bhuvan
 */
class Solution{
	/**
	 * This method is used to calaculate the median by using the
	 * min and max PQ classes.
	 * @param arr input array
	 * @return array of median values.
	 */
	public static double[] dynamicMedian(double[] arr){
		MaxPQ maxi = new MaxPQ(arr.length + 1);
		MinPQ mini = new MinPQ(arr.length + 1);
		/**
		 * Field to store the median values.
		 */
		double[] temp = new double[arr.length];
		/**
		 * Varibale used as iterator.
		 */
		int i = 0;
		/**
		 * Filed to store the median value.
		 */
		double median = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] >= median) {
				mini.insert(arr[j]);
			} else {
				maxi.insert(arr[j]);
			}
			if (mini.N - maxi.N > 1) {
				maxi.insert(mini.delMin());
			} else if (maxi.N - mini.N > 1) {
				mini.insert(maxi.delMax());
			}
			if (mini.N == maxi.N) {
				median = (mini.pq[1] + maxi.pq[1])/2.0;
			} else if (mini.N - maxi.N == 1) {
				median = mini.pq[1];
			} else if (maxi.N - mini.N == 1) {
				median = maxi.pq[1];
			}
			temp[i++] = median;
		}
		return temp;
	}
}