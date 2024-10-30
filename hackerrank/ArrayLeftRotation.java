package hackerrank;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        rotateLeftUsingReverse(arr,2);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotateLeftUsingReverse(int[] arr, int k) {
        k %= arr.length;
        // Reverse all numbers
        reverse(arr, 0, arr.length - 1);
        // Reverse first arr.length-k numbers
        reverse(arr, 0, arr.length - k - 1);
        // Reverse last k numbers
        reverse(arr, arr.length - k, arr.length - 1);
    }
}
