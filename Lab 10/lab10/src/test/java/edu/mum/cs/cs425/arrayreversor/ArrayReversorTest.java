package edu.mum.cs.cs425.arrayreversor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ArrayReversorTest {

	@Mock
	private ArrayFlattenerService arrayFlattenerService;

	@InjectMocks
	private ArrayReversor arrayReversor;

	// Test-case 1: input is a legit 2-D nested array.
	@Test
	@DisplayName("reverseArray of a legit 2-D array returns the flattened-and-reversed array")
	void testReverseArray_withLegit2dArray() {
		int[][] input = { { 1, 3 }, { 0 }, { 4, 5, 9 } };
		int[] flattened = { 1, 3, 0, 4, 5, 9 };
		int[] expected = { 9, 5, 4, 0, 3, 1 };

		when(arrayFlattenerService.flattenArray(input)).thenReturn(flattened);

		int[] actual = arrayReversor.reverseArray(input);

		assertArrayEquals(expected, actual);

		verify(arrayFlattenerService, times(1)).flattenArray(input);
	}

	// Test-case 2: input is null.
	@Test
	@DisplayName("reverseArray of null returns null and still invokes the service")
	void testReverseArray_withNullInput() {
		// The service is asked to flatten null and returns null.
		when(arrayFlattenerService.flattenArray(null)).thenReturn(null);

		int[] actual = arrayReversor.reverseArray(null);

		assertNull(actual);

		verify(arrayFlattenerService, times(1)).flattenArray(null);
	}
}
