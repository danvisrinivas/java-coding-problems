package general_programs;


public class MissingNumber {

    public static void main(String[] args) {
        int[] elements = {3, 8};
        int j = 0;
        for (int i = elements[0]; i <= elements[elements.length - 1]; i++) {
            if (j < elements.length && i == elements[j]) {
                j++;
            } else {
                System.out.println(i + " ");
            }
        }
    }

}