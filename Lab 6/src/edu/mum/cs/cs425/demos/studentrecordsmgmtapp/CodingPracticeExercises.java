package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.util.Arrays;

/**
 * The "Further Coding Practice Exercise Problems" from the lab assignment.
 */
public class CodingPracticeExercises {

	public static void main(String[] args) {

		// Exercise 1: printHelloWorld
		int[] numbers = {5, 7, 10, 14, 35, 3, 70, 21};
		System.out.println("printHelloWorld(" + Arrays.toString(numbers) + "):");
		printHelloWorld(numbers);

		// Exercise 2: findSecondBiggest
		int[] example1 = {1, 2, 3, 4, 5};
		int[] example2 = {19, 9, 11, 0, 12};
		System.out.println();
		System.out.println("findSecondBiggest(" + Arrays.toString(example1) + ") = "
				+ findSecondBiggest(example1));
		System.out.println("findSecondBiggest(" + Arrays.toString(example2) + ") = "
				+ findSecondBiggest(example2));
	}

	/**
	 * Iterates through the integers and prints "Hello" for a multiple of 5,
	 * "World" for a multiple of 7, and "HelloWorld" for a multiple of both.
	 */
	public static void printHelloWorld(int[] numbers) {
		for (int number : numbers) {
			boolean multipleOf5 = number % 5 == 0;
			boolean multipleOf7 = number % 7 == 0;

			if (multipleOf5 && multipleOf7) {
				System.out.println(number + " -> HelloWorld");
			} else if (multipleOf5) {
				System.out.println(number + " -> Hello");
			} else if (multipleOf7) {
				System.out.println(number + " -> World");
			} else {
				System.out.println(number + " -> (no match)");
			}
		}
	}

	/**
	 * Finds and returns the second biggest of the integers, without sorting.
	 * Uses a single pass and tracks the biggest and second biggest values.
	 */
	public static int findSecondBiggest(int[] numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException(
					"The array must contain at least 2 integers.");
		}

		int biggest = Integer.MIN_VALUE;
		int secondBiggest = Integer.MIN_VALUE;

		for (int number : numbers) {
			if (number > biggest) {
				secondBiggest = biggest;
				biggest = number;
			} else if (number > secondBiggest && number != biggest) {
				secondBiggest = number;
			}
		}
		return secondBiggest;
	}
}
