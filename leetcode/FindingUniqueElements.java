package leetcode;

import java.util.Arrays;

public class FindingUniqueElements {

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 30, 30, 40, 40, 10};
        findUniqueElements(arr);
    }

    public static void findUniqueElements(int[] arr) {
        // Sort the array first
        Arrays.sort(arr);

        // Traverse the sorted array to find unique elements
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is not equal to the previous and the next one
            if ((i == 0 || arr[i] != arr[i - 1]) && (i == arr.length - 1 || arr[i] != arr[i + 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
