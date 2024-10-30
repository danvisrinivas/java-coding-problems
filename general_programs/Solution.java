package general_programs;

import java.util.Arrays;


class Solution {
    public static void main(String args[]) {
    	int a[] = {1,3,6,4,1,2}; 
    	Integer[] listOfIntegers = Arrays.stream(a).boxed().toArray(Integer[]::new);
    	Arrays.asList(listOfIntegers);
    	
    }
}
