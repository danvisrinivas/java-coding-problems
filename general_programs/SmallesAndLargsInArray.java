package general_programs;

import java.util.Arrays;
import java.util.Comparator;

class SmallesAndLargsInArray {
    public static void main(String[] args) {
    	
    	findFirstSecondThirdLargestElements();
    	findFirstSecondThirdSmallestElements();
    }

	private static void findFirstSecondThirdSmallestElements() {
		
		int smalest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int thirdSmallest = Integer.MAX_VALUE;
        
        
        int arr[] = new int[]{5,4,90,89,0};
//		System.out.println(Arrays.stream(arr).boxed().sorted(Comparator.comparing(Integer::intValue).reversed()).limit(3).skip(2).findFirst().get()+ ".");
        for (int i = 0; i < arr.length; i++) {
        	if (smalest > arr[i]) {
        	    thirdSmallest = secondSmallest;
        	    secondSmallest = smalest;
        	    smalest = arr[i];
        	} else if (secondSmallest > arr[i]) {
        	    thirdSmallest = secondSmallest;
        	    secondSmallest = arr[i];
        	} else if (thirdSmallest > arr[i]) {
        	    thirdSmallest = arr[i];
        	}
        }
        System.out.println("Smalls:");
        System.out.println("smallest:"+smalest +" secondSmallest: " + secondSmallest
                + " thirdSmallest:" + thirdSmallest);
	}

	private static void findFirstSecondThirdLargestElements() {

		int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        int thirdlargest = Integer.MIN_VALUE;
        
        int arr[] = new int[]{5,4,90,89,0};
        for (int i = 0; i < arr.length; i++) {
        	if (largest < arr[i]) {
        	    thirdlargest = secondlargest;
        	    secondlargest = largest;
        	    largest = arr[i];
        	} else if (secondlargest < arr[i]) {
        	    thirdlargest = secondlargest;
        	    secondlargest = arr[i];
        	} else if (thirdlargest < arr[i]) {
        	    thirdlargest = arr[i];
        	}
        }
        System.out.println("largest:"+largest +" secondLargest:" + secondlargest
                + " thirdLargest:" + thirdlargest);
	}
}
