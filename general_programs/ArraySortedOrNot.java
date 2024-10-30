package general_programs;

public class ArraySortedOrNot {
    public static void main(String[] args) {
        int arr[] = {1,2, 4, 9};
        System.out.println(sorted(arr));
    }

    private static boolean sorted(int[] arr) {
        for(int i=1;i<arr.length;i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
