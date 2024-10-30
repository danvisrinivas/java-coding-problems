package leetcode;

import java.util.Stack;

public class BracketsProblem {

	public static void main(String[] args) {
		System.out.println(balanced("[{}]")); // Output: true
		System.out.println(balanced("{[({})]}")); // Output: false
	}

	public static boolean balanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == '(' || curr == '[' || curr == '{') {
				// If it's an opening bracket, push it onto the stack
				stack.push(curr);
			} else if (curr == ')' || curr == ']' || curr == '}') {
				// If it's a closing bracket, check if it matches the top of the stack
				if (stack.isEmpty()) {
					return false; // No matching opening bracket
				}
				char top = stack.pop();
				if (!isMatchingPair(top, curr)) {
					return false; // Brackets don't match
				}
			}
		}
		// The stack should be empty if all brackets are matched
		return stack.isEmpty();
	}

	private static boolean isMatchingPair(char open, char close) {
		// Use the ASCII value differences to check for matching pairs
		return (open == '(' && close == ')') ||
				(open == '[' && close == ']') ||
				(open == '{' && close == '}');
	}
}
