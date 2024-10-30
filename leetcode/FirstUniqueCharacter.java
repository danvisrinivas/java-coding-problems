package leetcode;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        /*Example 2:
        Input: s = "loveleetcode"
        Output: 2
        Example 3:
        Input: s = "aabb"
        Output: -1*/
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] freq = new int[256]; // Array to store frequency of each character (only lowercase letters)

        // First pass: Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        // Second pass: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) {
                return i;
            }
        }

        // If no non-repeating character is found, return -1
        return -1;
    }
}
