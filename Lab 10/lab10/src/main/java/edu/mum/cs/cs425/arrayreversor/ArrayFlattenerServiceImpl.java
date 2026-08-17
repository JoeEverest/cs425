package edu.mum.cs.cs425.arrayreversor;

public class ArrayFlattenerServiceImpl implements ArrayFlattenerService {

	@Override
	public int[] flattenArray(int[][] nestedArray) {
		if (nestedArray == null) {
			return null;
		}
		int total = 0;
		for (int[] row : nestedArray) {
			if (row != null) {
				total += row.length;
			}
		}
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
}
