package companies_coding_problems;

import java.util.HashMap;
import java.util.Map;

public class PalindromeCheckAndCanBePalindrome {

    public static void main(String[] args) {
        //System.out.println(isPalindrome("Madam".toLowerCase()));
        System.out.println(canBePalindrome("damam".toLowerCase()));
    }

    public static boolean isPalindrome(String s){
        int right = s.length() -1;
        int left = 0;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean canBePalindrome(String s){
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for(char c : s.toCharArray()){
            characterCountMap.put(c, characterCountMap.getOrDefault(c, 0)+1);
        }
        int oddCount = 0;
        for(int count : characterCountMap.values()){
            if(count % 2 != 0){
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
