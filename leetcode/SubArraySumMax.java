package leetcode;

class SubArraySumMax {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = 0;
        int start = 0; // Start index of max subarray
        int end = 0;   // End index of max subarray
        int tempStart = 0; // Temporary start index for current subarray

        // Start iterating from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current sum is negative, reset it to the current element
            if (sum < 0) {
                sum = nums[i];
                tempStart = i; // Update temporary start index
            } else {
                sum += nums[i];
            }

            // Update max sum if the current sum is greater
            if (sum > max) {
                max = sum;
                start = tempStart; // Update start index of max subarray
                end = i;           // Update end index of max subarray
            }
        }

        // Print out the pairs that contribute to the maximum subarray sum
        System.out.print("Pairs in the maximum subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(); // Print a new line

        return max;
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
