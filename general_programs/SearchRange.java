package general_programs;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result; // Return [-1, -1] if the array is empty.
        }

        // Find the starting position of the target.
        result[0] = findPosition(nums, target, true);
        // Find the ending position of the target.
        result[1] = findPosition(nums, target, false);

        return result;
    }

    private static int findPosition(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1; // To track the position of target.

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                pos = mid; // Update position if target is found.
                if (isFirst) {
                    right = mid - 1; // Search in the left half for the first occurrence.
                } else {
                    left = mid + 1; // Search in the right half for the last occurrence.
                }
            } else if (nums[mid] < target) {
                left = mid + 1; // Move to the right half.
            } else {
                right = mid - 1; // Move to the left half.
            }
        }

        return pos; // Return the found position or -1 if not found.
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = searchRange(nums1, target1);
        System.out.println("Input: " + java.util.Arrays.toString(nums1) + ", Target: " + target1 + " Output: " + java.util.Arrays.toString(result1)); // Output: [3,4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("Input: " + java.util.Arrays.toString(nums2) + ", Target: " + target2 + " Output: " + java.util.Arrays.toString(result2)); // Output: [-1,-1]

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = searchRange(nums3, target3);
        System.out.println("Input: " + java.util.Arrays.toString(nums3) + ", Target: " + target3 + " Output: " + java.util.Arrays.toString(result3)); // Output: [-1,-1]
    }
}
/**
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

