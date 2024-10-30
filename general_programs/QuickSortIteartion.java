package general_programs;

import java.util.Arrays;
import java.util.Stack;

// Simple pair class in Java
record Pair(int x, int y){}
public class QuickSortIteartion{
	public static void main(String[] args)
    {
        int a[] = { 2,10,1,0 };
        iterativeQuickSort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void iterativeQuickSort(int[] a)
    {
        Stack<Pair> stack = new Stack<>();
        int start = 0;
        int end = a.length - 1;
        stack.push(new Pair(start, end));
        while (!stack.empty())
        {
            start = stack.peek().x();
            end = stack.peek().y();
            stack.pop();
            int pivot = Partition(a, start, end);
            if (pivot - 1 > start) {
                stack.push(new Pair(start, pivot - 1));
            }
            if (pivot + 1 < end) {
                stack.push(new Pair(pivot + 1, end));
            }
        }
    }
    public static int Partition(int a[], int start, int end)
    {
        int pivot = a[end];
        int pIndex = start;
        for (int i = start; i < end; i++)
        {
            if (a[i] <= pivot)
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
        swap (a, pIndex, end);
        return pIndex;
    }
	public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	/**
	 * 
	 * 

1)	
	start=0								end=4
	4			2		0		1		3
	
	partition:
	
	pIndex = 0							pivot
	4			2		0		1		3
	
	Loop from start to end
	i=0
	4<=3
	
	i=1
	2<=3
	pIndex = 0							pivot
	4			2		0		1		3
	====
				pIndex = 1				pivot
	2			4		0		1		3
	pIndex=1
	
	i=2
	0<=3
				pIndex = 1				pivot
	2			4		0		1		3
	=====
						pIndex = 2		pivot
	2			0		4		1		3
	pIndex=2
	
	i=3
	1<=3
						pIndex = 2		pivot
	2			0		4		1		3
	=====
								pIndex = 3	pivot
	2			0		1		4			 3
	pIndex=3
	
	swap pIndex with pivot
								pIndex = 3	pivot
	2			0		1		3			 4
	
	pivot = 3 
	
	if(3-1>start=0){
		stck.push(0,2);
	}
	if(3+1<end){
		stck.push(4,4);wrong
	}
	stck = 0,2
	
2)
	start = 0			end = 2					
	2			0		1		3			 4
	
	partition:
	pIndex=0    	   pivot						
	2			0		1		3			 4
	
	Loop from start to end
	i=0
	2<=1
	
	i=1
	0<=1
	pIndex=0    	   pivot						
	2			0		1		3			 4
	=====
				pIndex=1   pivot						
	0			2			1		3			 4
	
	swap pIndex with pivot
				pIndex=1   pivot						
	0			1			2		3			 4
	
	pivot = 1
	 * 
	 */
}