import java.util.Random;
/**
 * Class to benchmark sorting times for arrays of various sizes.
 */
public class runtime {
	/**
	 * Tests the merge sort implementation times for arrays of size 250000, 500000, 1000000, and 2500000
	 */
	private static void testSort() {
		System.out.println("Test 1 - Array size 250,000");
		int[] arr = new int[250000];
		sort(arr);
		
		System.out.println("\nTest 2 - Array size 500,000");
		arr = new int[500000];
		sort(arr);
		
		System.out.println("\nTest 3 - Array size 1,000,000");
		arr = new int[1000000];
		sort(arr);
		
		System.out.println("\nTest 4 - Array size 2,500,000");
		arr = new int[2500000];
		sort(arr);
	}
	
	/**
	 * Sorts the array and measures the time elapsed for each, repeating the process thrice
	 */
	private static void sort(int[] array) {
		Random gen = new Random();
		long[] times = new long[3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < array.length; j++) {
				array[j] = gen.nextInt();
			}
			long startTime = System.nanoTime();
			Sorting.mergeSort(array);
			long timeElapsed = (System.nanoTime() - startTime) / 1000000;
			System.out.println("Time elapsed: " + timeElapsed + "ms");
			
			times[i] = timeElapsed;
		}
		
		System.out.println("Median: " + Math.max(Math.min(times[0], times[1]), Math.min(Math.max(times[0], times[1]), times[2])) + "ms"); // funky way of getting the median of three values :)
	}
	
	public static void main(String[] args) {
		testSort();
	}
}
