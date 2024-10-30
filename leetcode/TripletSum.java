package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletSum {
    public static void main(String[] args) {
//        int[] arr = {-4,-1,-1,0,1,2};
        int[] arr = {1,4,6,8,10,45,0};
        findTripletSum(arr, arr.length);

    }

    static void findTripletSum(int[] arr, int n)
    {
        Set<String> triplets = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 11) {
//                if (x + arr[l] + arr[r] == 0) {
//              add elements if it's sum is zero
                    triplets.add(x+" "+arr[l]+" "+arr[r]);
                    l++;
                    r--;
                }
                // If sum of three elements is less than zero then increment in left
                else if (x + arr[l] + arr[r] < 11)
                    l++;
                else
                    r--;
            }
        }
        System.out.println(triplets);
    }
}