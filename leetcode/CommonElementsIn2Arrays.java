package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElementsIn2Arrays {

    public static void main(String args[])
    {
        int ar1[] = {1, 2, 3, 90, 91};
        int ar2[] = {3, 4, 78, 90};

        System.out.println(Arrays.toString(findCommon(ar1,ar2)));

    }

    public static int[] findCommon(int[] ar1, int[] ar2) {
        int i = 0, j = 0;
        List<Integer> commonElements = new ArrayList<>();
        while (i < ar1.length && j < ar2.length) {
            if (ar1[i] == ar2[j]) {
                commonElements.add(ar1[i]);
                i++;
                j++;
            } else if (ar1[i] < ar2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return commonElements.stream().mapToInt(Integer::intValue).toArray();
    }
}
