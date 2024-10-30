package leetcode;

public class ShiftAllOnesToLeft {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 4, 1, 1, 2, 1, 3, 1};
//        int arr[] = {1, 0, 1, 0, 0, 1};
        resultingArray(arr);
    }

    public static void resultingArray(int arr[]) {
        int j = 0;
        for(int i=0;i< arr.length;i++){
            if(arr[i]==1){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        for (int a:arr){
            System.out.print(a + " ");
        }
    }
}
