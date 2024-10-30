package companies_coding_problems;

import java.util.Arrays;

public class NumbersStartWith1Streams {
    public static void main(String[] args) {
        int[] arr = {10, 12, 50, 30, 18, 19};
        Arrays.stream(arr)
                .boxed()
                .map(n -> n + "")
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .filter(n -> containsDigitOne(n))
                .forEach(System.out::println);
    }

    private static boolean containsDigitOne(int n) {
        while (n > 0) {
            if (n % 10 == 1) {
                return true;  // Return true if any digit is 1
            }
            n /= 10;  // Remove the last digit
        }
        return false;
    }
}
