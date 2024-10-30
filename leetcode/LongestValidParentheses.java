package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for valid substring calculation
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Push index of '(' onto the stack
            } else {
                stack.pop(); // Pop the last '(' index
                if (stack.isEmpty()) {
                    stack.push(i); // No matching '(', push the index of ')'
                } else {
                    // Calculate the length of the current valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";

        System.out.println("Input: \"" + s1 + "\" Output: " + longestValidParentheses(s1)); // Output: 2
        System.out.println("Input: \"" + s2 + "\" Output: " + longestValidParentheses(s2)); // Output: 4
        System.out.println("Input: \"" + s3 + "\" Output: " + longestValidParentheses(s3)); // Output: 0
    }
}
