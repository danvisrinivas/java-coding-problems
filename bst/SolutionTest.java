package bst;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
	public static void main(String args[]) {
		int A = 10, B= 20;
		int value = 0;
		Boolean identity = false;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=A;i<=B;i++) {
			int number = (int)Math.sqrt(i);
			if(number*number == i) {
				identity = true;
			}
			if(identity) {
				list.add(i);
				break;
			}
		}
		do {
			value = (int)Math.sqrt(list.get(0));
			value = (int)Math.sqrt(value);
		}while(value == 0);
		
		System.out.println(value+":::");
	}
	
	
}