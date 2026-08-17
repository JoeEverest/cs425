package edu.mum.cs.cs425.arrayflattener;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayFlattenerTest {

	private ArrayFlattener arrayFlattener;

	@BeforeEach
	void setUp() {
		arrayFlattener = new ArrayFlattener();
	}

	// Test-case 1: input is a legit 2-D nested array.
	@Test
	@DisplayName("flattenArray of a legit 2-D nested array returns the flattened array")
	void testFlattenArray_withLegit2dArray() {
		int[][] input = { { 1, 3 }, { 0 }, { 4, 5, 9 } };
		int[] expected = { 1, 3, 0, 4, 5, 9 };

		int[] actual = arrayFlattener.flattenArray(input);

		assertArrayEquals(expected, actual);
	}

	// Test-case 2: input is null.
	@Test
	@DisplayName("flattenArray of null returns null")
	void testFlattenArray_withNullInput() {
		int[] actual = arrayFlattener.flattenArray(null);

		assertNull(actual);
	}
}
