package general_programs;

import java.util.Arrays;

public class FindingDuplicates {

	public static void main(String[] args) {
		int arr[] = {10, 20, 30, 30, 30, 40, 40, 10, 30, 40};
		findDuplicates(arr);
	}

	public static void findDuplicates(int[] arr) {
		// Sort the array first
		Arrays.sort(arr);
		
		int temp = 0;

		// Traverse the sorted array and check for duplicates
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] && temp != arr[i]) {
				temp = arr[i];
				System.out.println(arr[i]);
			}
		}
	}
}
