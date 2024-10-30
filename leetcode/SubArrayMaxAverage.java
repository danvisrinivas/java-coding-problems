package leetcode;

public class SubArrayMaxAverage {

    public static double contiguousSubArrayMaxAverage(int nums[], int k) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }
        return max * 1.0 / k;
    }

    public static void main(String[] args) {

        int arr[] = { 1,12,-5,-6,50,3 };
        double result = contiguousSubArrayMaxAverage(arr, 4);
        System.out.println(result);

    }
}
