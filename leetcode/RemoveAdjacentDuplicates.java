package leetcode;

/**
 * StringBuilder stack = new StringBuilder();
 *
 *         for (char c : s.toCharArray()) {
 *             if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
 *                 // If the last character in the stack is equal to the current character, remove it
 *                 stack.deleteCharAt(stack.length() - 1);
 *             } else {
 *                 // Otherwise, add the current character to the stack
 *                 stack.append(c);
 *             }
 *         }
 */
public class RemoveAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        char[] arr = s.toCharArray(); // a b b a c a
        //                              i=5,j=1
        int j = 0; // Pointer to place the next character

        for (int i = 0; i < arr.length; i++) {
            if (j > 0 && arr[j - 1] == arr[i]) {
                j--; // Remove the previous character (pop the stack)
            } else {
                arr[j] = arr[i]; // Place the current character at the next position
                j++; // Move the pointer forward
            }
        }
        return new String(arr, 0, j);
    }

    public static void main(String[] args) {
//        String s = "abbaca";
        String str = "zzabbaxyzt";
        String result = removeDuplicates(str);
        System.out.println("Output: " + result); // Output: "ca"
    }
}

