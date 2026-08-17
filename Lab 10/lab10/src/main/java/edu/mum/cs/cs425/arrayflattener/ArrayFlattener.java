package edu.mum.cs.cs425.arrayflattener;

import java.util.Arrays;

public class ArrayFlattener {

	/**
	 * Flattens a 2-D nested array into a new 1-D array.
	 *
	 * @param nestedArray the 2-D input array
	 * @return the flattened 1-D array, or null if the input is null
	 */
	public int[] flattenArray(int[][] nestedArray) {
		if (nestedArray == null) {
			return null;
		}

		// Work out the total number of elements.
		int total = 0;
		for (int[] row : nestedArray) {
			if (row != null) {
				total += row.length;
			}
		}

		// Copy every element into the flattened array, in order.
		int[] flattened = new int[total];
		int index = 0;
		for (int[] row : nestedArray) {
			if (row != null) {
				for (int value : row) {
					flattened[index++] = value;
				}
			}
		}
		return flattened;
	}

	public static void main(String[] args) {
		int[][] input = { { 1, 3 }, { 0 }, { 4, 5, 9 } };
		ArrayFlattener flattener = new ArrayFlattener();
		int[] output = flattener.flattenArray(input);

		System.out.println("Input  : " + Arrays.deepToString(input));
		System.out.println("Output : " + Arrays.toString(output));
	}
}
