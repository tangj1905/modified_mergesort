/**
 * Implementation of a somewhat optimized merge sort, avoiding back copying.
 * @author jgt31
 */
public class Sorting {
	/**
	 * Main class of the merging algorithm - this will take in an integer array and sort it
	 */
	public static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length]; // creates temp array the same size as the original array
		int sortedRunSize = 1; // size of the sorted subunits
		boolean sortTempArr = true; // which array to sort
		
		while(sortedRunSize < arr.length) {
			for(int i = 0; i < arr.length; i += 2 * sortedRunSize) {
				if(sortTempArr) // the temp array is the array to sort
					merge(arr, temp, i, i + sortedRunSize);
				else // the original array is the array to sort
					merge(temp, arr, i, i + sortedRunSize);
			}
			
			sortedRunSize *= 2; // sorted run size doubles after every iteration
			sortTempArr = !sortTempArr; // switches the array that is sorted
		}
		
		if(!sortTempArr) // the temporary array is the completely sorted array; we need to copy it over to the original
			System.arraycopy(temp, 0, arr, 0, arr.length);
	}
	
	/**
	 * Merges two subunits from one array to another, given the left and right indices of each subunit
	 */
	private static void merge(int[] from, int[] to, int leftStart, int rightStart) {
		int rightEnd = Math.min(2 * rightStart - leftStart, from.length);
		int leftIndex = leftStart; // index of the left subarray
		int rightIndex = rightStart; // index of the right subarray
		
		// sequentially add the lowest value among the two subarrays to the target array
		for(int j = leftStart; j < rightEnd; j++) {
			if(rightIndex < rightEnd && (from[rightIndex] <= from[leftIndex] || leftIndex >= rightStart)) {
				to[j] = from[rightIndex];
				rightIndex++;
			} else {
				to[j] = from[leftIndex];
				leftIndex++;
			}
		}
	}
}