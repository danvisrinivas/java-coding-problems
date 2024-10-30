package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> pascalT = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalT.add(firstRow);

        for(int i=1;i<numRows;i++){
            List<Integer> prevRow = pascalT.get(i-1);
            List<Integer> currRow = new ArrayList<>();

            currRow.add(1);
            for(int j=1;j<i;j++){
                currRow.add(prevRow.get(j-1)+ prevRow.get(j));
            }
            currRow.add(1);

            pascalT.add(currRow);
        }

        return pascalT;
    }
}
