package general_programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RepeatedElementsInArray {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 10, 1, 2, 1, 10 };

		/**
		 * We can get exactly what type occurrence we want once, twice or thrice
		 * and number of occurrences.
		 */
		printRepeatedElements(arr);
	}

	private static void printRepeatedElements(int arr[]) {
		HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
		for (Integer a : arr) {
			Integer count = hashMap.get(a);
			if (count == null) {
				count = 1;
				hashMap.put(a, count);
			} else {
				hashMap.put(a, count + 1);
			}
		}
		System.out.println(getKeyFromValue(hashMap, 1));
		List<Object> listOfObjects = getKeyFromValue(hashMap, 1);
		// Getting all Non-Repeated elements by list
		System.out.println("First Non-Repeating value : "+ listOfObjects.get(0));
		System.out.println("Second Non-Repeating value : "+ listOfObjects.get(1));
		System.out.println("Third Non-Repeating value : "+ listOfObjects.get(2));
		
		List<Object> listOfRepeating = getKeyFromValueForRepeatingContext(hashMap);
		 
		System.out.println(listOfRepeating);
		System.out.println("First Repeating value : "+ listOfRepeating.get(0));
		System.out.println("Second Repeating value : "+ listOfRepeating.get(1));
	}

	public static List<Object> getKeyFromValue(Map<Integer,Integer> hm, Object value) {
		List<Object> listOfValues = new ArrayList<>();
		for (Object o : hm.keySet()) {
			if (hm.get(o).equals(value)) {
				listOfValues.add(o);
			}
		}
		return listOfValues;
	}
	
	public static List<Object> getKeyFromValueForRepeatingContext(Map<Integer,Integer> hm) {
		List<Object> listOfValues = new ArrayList<>();
		for(Integer o : hm.keySet()) {
				if(hm.get(o)>=2){
				listOfValues.add(o);
			}
		}
		return listOfValues;
	}
}