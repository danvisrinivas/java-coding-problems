package leetcode;

public class FirstRepeatingCharacter {
    public static void main(String[] args) {
        String s = "loveleetcode"; // Example input
        int index = firstRepeatingChar(s);
        System.out.println("Index of the first repeating character: " + index);
    }

    public static int firstRepeatingChar(String s) {
        int[] freq = new int[256]; // Array to store frequency of each character (only lowercase letters)

        // First pass: Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        // Second pass: Find the first character that has a frequency greater than 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] > 1) {
                System.out.println(s.charAt(i));
                return i; // Return the index of the first repeating character
            }
        }

        // If no repeating character is found, return -1
        return -1;
    }
}
