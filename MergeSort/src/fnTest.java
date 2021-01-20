import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Testing class for the merge sort implemented in the Sorting class.
 */
public class fnTest {
	/**
	 * Reads in an input file, measures the sorting time, and writes the results to the output file
	 */
	private static void testSort(String inputFile, String outputFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// reads the contents of the input file into an ArrayList
		String str = br.readLine();
		while(str != null) {
			list.add(Integer.parseInt(str));
			str = br.readLine();
		}
		br.close();
		
		// conversion from ArrayList to array using a stream
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		
		// sorts the array and measures the time elapsed
		long startTime = System.nanoTime();
		Sorting.mergeSort(arr);
		long timeElapsed = System.nanoTime() - startTime; // time elapsed in ns
		
		PrintStream ps = new PrintStream(outputFile);
		for(int i = 0; i < arr.length; i++) {
			ps.println(arr[i]);
		}
		ps.print("Time elapsed: " + timeElapsed + "ns");
		ps.flush();
		ps.close();
	}
	
	/**
	 * Takes in the first two arguments from the console; the first String is the input file and the second is the output file
	 */
	public static void main(String[] args) {
		try {
			testSort(args[0], args[1]);
			System.out.println("Success!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
