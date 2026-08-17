package edu.mum.cs.cs425.arrayreversor;

import java.util.Arrays;

public class ArrayReversor {

	private final ArrayFlattenerService arrayFlattenerService;

	public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
		this.arrayFlattenerService = arrayFlattenerService;
	}

	/**
	 * Flattens (via the service) and then reverses the given 2-D nested array.
	 *
	 * @param nestedArray the 2-D input array
	 * @return the flattened-and-reversed 1-D array, or null if the flattening
	 *         service returns null (e.g. for a null input)
	 */
	public int[] reverseArray(int[][] nestedArray) {
		// Always delegate the flattening to the (remote) service.
		int[] flattened = arrayFlattenerService.flattenArray(nestedArray);

		if (flattened == null) {
			return null;
		}

		// Reverse the flattened array into a new array.
		int n = flattened.length;
		int[] reversed = new int[n];
		for (int i = 0; i < n; i++) {
			reversed[i] = flattened[n - 1 - i];
		}
		return reversed;
	}

	public static void main(String[] args) {
		int[][] input = { { 1, 3 }, { 0 }, { 4, 5, 9 } };
		ArrayReversor reversor = new ArrayReversor(new ArrayFlattenerServiceImpl());
		int[] output = reversor.reverseArray(input);

		System.out.println("Input  : " + Arrays.deepToString(input));
		System.out.println("Output : " + Arrays.toString(output));
	}
}
