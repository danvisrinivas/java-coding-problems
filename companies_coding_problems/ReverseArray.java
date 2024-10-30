package companies_coding_problems;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
}
