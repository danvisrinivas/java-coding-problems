package companies_coding_problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {90, 9, 8, 2};
        System.out.println(largestNumber(arr));
    }

    public static String largestNumber(int[] nums) {
        // Convert numbers to strings and sort them using a custom comparator
        String strArr = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((str1, str2) -> (str2 + str1).compareTo(str1 + str2))
                .collect(Collectors.joining());

        // Handle the case where the largest number is "0"
        if (strArr.equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings
        return strArr;
    }
}
