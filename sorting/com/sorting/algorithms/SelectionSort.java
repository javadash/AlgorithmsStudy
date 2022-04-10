package com.sorting.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	/** The method for sorting the numbers */
	/** Worst Case: O(n^2) */

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// Runs n times
			// Find the minimum in the arr[i..arr.length-1]
			// Get each element in the array for comparisons
			// specifically get the smallest element in the array
			int currentMin = arr[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < arr.length; j++) { // Run n* (n-1) times
				if (currentMin > arr[j]) { // n * (n-2) times
					currentMin = arr[j];
					currentMinIndex = j;
				}
			}
			// Swap arr[i] with arr[currentMinIndex] if necessary;
			if (currentMinIndex != i) { // Run n* (n-1) times
				arr[currentMinIndex] = arr[i];
				arr[i] = currentMin;
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter no of terms");
		int n = sc.nextInt();

		System.out.println("Enter the terms");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println("The unsorted array is:");
		System.out.println(Arrays.toString(arr));

		selectionSort(arr);

		System.out.println("The sorted array is:");
		System.out.println(Arrays.toString(arr));
	}
}