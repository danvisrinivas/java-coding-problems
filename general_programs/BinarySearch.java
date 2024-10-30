package general_programs;

public class BinarySearch {

    // Method to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid;  // Target found, return its index
            }
            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // Target is not present in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 3;

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
