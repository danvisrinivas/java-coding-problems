package general_programs;

public class ReverseStringSpecialCharacters {

    public static void main(String[] args) {
        String input = "ep@m engin$eer";
        String reversed = reverseWithSpecialCharacters(input);
        m1(input);
    }

    public static String reverseWithSpecialCharacters(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void m1(String input){
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left<right){
            if(!Character.isLetter(chars[left])){
                left++;
            }else if(!Character.isLetter(chars[right])){
                right--;
            }else{
                char temp = chars[left];
                chars[left]= chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(new String(chars));
    }
}
