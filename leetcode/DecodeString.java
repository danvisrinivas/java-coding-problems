package leetcode;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
//        String input = "3[a2[c]]";
        String input = "100[a]";
        System.out.println(decodeString(input));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int count = 0;
        String curr = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(curr);
                count = 0;
                curr = "";
            } else if (c == ']') {
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decodedString.append(curr);
                }
                curr = decodedString.toString();
            } else {
                curr += c;
            }
        }
        return curr;
    }
    /*
    The time complexity of the given algorithm is O(n), where n is the length of the input string.
    This is because we iterate through each character of the string once.

    The space complexity of the algorithm is O(n) as well.
    This is because in the worst case scenario, all characters of the input string can be part of the decoded string
     */
}
