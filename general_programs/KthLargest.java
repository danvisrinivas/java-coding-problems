package general_programs;

import java.util.PriorityQueue;

public class KthLargest {
	
	public static void main(String[] args) {
		int nums[] = {2, 45, 78,9};
		getNthLargestElement(nums, 2);
	}

	private static void getNthLargestElement(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	    System.out.println(q.peek());
	}
}