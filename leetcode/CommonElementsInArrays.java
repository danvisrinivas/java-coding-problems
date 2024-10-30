package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElementsInArrays {

    public static void main(String args[])
    {
        int ar1[] = {1, 2, 3, 90, 91};
        int ar2[] = {3, 4, 78, 90};
        int ar3[] = {3, 90};

        System.out.println(Arrays.toString(findCommon(ar1,ar2,ar3)));

    }

    public static int[] findCommon(int[] ar1, int[] ar2, int[] ar3) {
        int i = 0, j = 0, k = 0;
        List<Integer> commonElements = new ArrayList<>();
        while (i < ar1.length && j < ar2.length && k < ar3.length) {
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                commonElements.add(ar1[i]);
                i++;
                j++;
                k++;
            } else if (ar1[i] < ar2[j]) {
                i++;
            } else if (ar2[j] < ar3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return commonElements.stream().mapToInt(Integer::intValue).toArray();
    }
}
