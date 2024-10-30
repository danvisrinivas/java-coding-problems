package general_programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMinElementsInArray {
	public static void main(String[] args) {
		maxAndMinElementsInArray();
	}

	private static void maxAndMinElementsInArray() {
		List<Integer> list = Arrays.asList(1,10,0,99);
		Integer max = list.stream().max(Comparator.comparing(Integer::intValue)).get();
		System.out.println("Max:"+ max);
		Integer min = list.stream().min(Comparator.comparing(Integer::intValue)).get();
		System.out.println("Min:"+ min);
	}
}
