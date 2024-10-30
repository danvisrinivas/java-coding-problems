package hackerrank;

import java.util.Stack;

public class StringReduction {
    public static void main(String[] args) {
        String str = "zzabbaxyzt";
        reduceString(str);
//        reduceStringWithEfficientSolution(str);
    }

    private static void reduceString(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else if(c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for(Character c: stack){
            result.append(c);
        }
        System.out.println(result);
    }

    private static void reduceStringWithEfficientSolution(String str) {
        char[] arr = str.toCharArray();
        int end = -1; // To keep track of the end of the resultant string

        for (char c : arr) {
            if (end == -1 || arr[end] != c) {
                arr[++end] = c;
            } else {
                end--;
            }
        }
        String result = new String(arr, 0, end + 1);
        System.out.println(result);
    }
}
