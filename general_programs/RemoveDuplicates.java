package general_programs;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0;  // Pointer to place the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;            // Move the pointer to the next position
                nums[j] = nums[i];  // Place the unique element
            }
        }

        return j + 1;  // Return the number of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(nums);

        System.out.println("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

