package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(length("abcabcbb"));
    }

    public static int length(String s) {
        int maxLength = 0;
        String longestSubstring = "";

        for (int right = 0, left = 0; right < s.length(); right++) {
            int indexOfFirstAppearanceInSubstring = s.indexOf(s.charAt(right), left);
            if (indexOfFirstAppearanceInSubstring != right) {
                left = indexOfFirstAppearanceInSubstring + 1;
            }

            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestSubstring = s.substring(left, right + 1);
            }

            System.out.println("Step " + (right + 1) + ": Current longest substring: \"" + s.substring(left, right + 1) + "\"");
        }

        System.out.println("Final longest substring: \"" + longestSubstring + "\"");
        return maxLength;
    }
}
