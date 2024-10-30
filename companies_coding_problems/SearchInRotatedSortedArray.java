package companies_coding_problems;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 6};
        // To search for an element in a sorted rotated array efficiently,
        // you can use a modified binary search approach
        int target = 3;

        int index = searchInRotatedSortedArray(arr, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    public static int searchInRotatedSortedArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[left] <= arr[mid]) {
                // Check if target is within the left sorted half
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            } else { // Right half is sorted
                // Check if target is within the right sorted half
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        // Element not found
        return -1;
    }
}

