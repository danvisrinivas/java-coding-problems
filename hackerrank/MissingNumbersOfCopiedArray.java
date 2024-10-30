package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * import java.util.Arrays;
 *
 * public class MissingNumbersOfCopiedArray {
 *     public static void main(String[] args) {
 *         int originalArray[] = {7, 2, 5, 4, 6, 3, 5, 3};
 *         int copiedArray[] = {7, 2, 5, 3, 5, 3};
 *
 *         findMissingNumbers(originalArray, copiedArray);
 *     }
 *
 *     private static void findMissingNumbers(int[] originalArray, int[] copiedArray) {
 *         // Sort both arrays
 *         Arrays.sort(originalArray);
 *         Arrays.sort(copiedArray);
 *
 *         int i = 0, j = 0;
 *
 *         // Traverse both arrays
 *         while (i < originalArray.length && j < copiedArray.length) {
 *             if (originalArray[i] != copiedArray[j]) {
 *                 // If they are different, print the missing number
 *                 System.out.print(originalArray[i] + " ");
 *                 i++;
 *             } else {
 *                 // If they are equal, move both pointers
 *                 i++;
 *                 j++;
 *             }
 *         }
 *
 *         // Print the remaining elements in the original array (if any)
 *         while (i < originalArray.length) {
 *             System.out.print(originalArray[i] + " ");
 *             i++;
 *         }
 *     }
 * }
 */

public class MissingNumbersOfCopiedArray {
    public static void main(String[] args) {
        int originalArray[] = {7,2,5,4,6,3,5,3};
        int copiedArray[] = {7,2,5,3,5,3};

        findMissingNumbers(originalArray, copiedArray);

    }

    private static void findMissingNumbers(int[] originalArray, int[] copiedArray) {
        Map<Integer,Integer> numbersCountMap = new HashMap<>();

        for(int number : originalArray){
            numbersCountMap.put(number, numbersCountMap.getOrDefault(number,0)+1);
        }

        for(int copiedNumber : copiedArray){
            Integer count = numbersCountMap.get(copiedNumber);
            count--;
            if(count == 0){
                numbersCountMap.remove(copiedNumber);
            }else{
                numbersCountMap.put(copiedNumber, count);
            }
        }

        Arrays.stream(numbersCountMap.keySet().toArray()).forEach(n -> System.out.print(n + " "));
    }
}
