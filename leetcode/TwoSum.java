package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {1, 4, 6, 8, 10, 45};
		int target = 14;
		findTwoSum(arr, arr.length, target);
	}

	static void findTwoSum(int[] arr, int n, int target) {
		Set<String> pairs = new HashSet<>();
		Arrays.sort(arr); // Sort the array to use the two-pointer approach
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int sum = arr[l] + arr[r];
			if (sum == target) {
				pairs.add(arr[l] + " " + arr[r]);
				l++;
				r--;
			} else if (sum < target) {
				l++; // Increase the left pointer if the sum is less than the target
			} else {
				r--; // Decrease the right pointer if the sum is greater than the target
			}
		}

		System.out.println(pairs);
	}
}
