package leetcode;

public class Anagrams {

	public static boolean areAnagrams(String first, String second) {
		// Check if lengths are different; if so, they can't be anagrams
		if (first.length() != second.length()) {
			return false;
		}
		// Array to keep track of character counts using ASCII values
		int[] checksum = new int[256]; // Supports all ASCII characters
		// Iterate over the characters of both strings
		for (int i = 0; i < first.length(); i++) {
			checksum[first.charAt(i)]++;  // Increment for the first string
			checksum[second.charAt(i)]--; // Decrement for the second string
		}
		// Check if all counts are zero
		for (int count : checksum) {
			if (count != 0) {
				return false;  // If any count is not zero, they aren't anagrams
			}
		}

		return true; // All counts are zero, so the strings are anagrams
	}

	public static void main(String[] args) {
		String first = "BB";
		String second = "BB";

		if (areAnagrams(first, second)) {
			System.out.println("Anagram");
		} else {
			System.out.println("Not an anagram");
		}
	}
}
