package general_programs;

import java.util.ArrayList;
import java.util.List;

public class PermutationPossibilities {
	
	public static void permutation(String str) {
	    permutation("", str);
	}
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	System.out.println(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++){
	        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));	        	
	        }
	    }
	}
		// Iterative program to generate all permutations of a String in Java
		public static void main(String[] args)
		{
			String s = "ab";
			permutation("", "abc" );
		}
		
		// Iterative function to generate all permutations of a String in Java
				// using Collections

}
