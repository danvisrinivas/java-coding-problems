package bst;

import java.util.concurrent.atomic.AtomicInteger;

public class NthSmallestBST {
	
	public static void main(String[] args) {
		System.out.println(kthSmallest(BSTInsertion.insertBSTSmall(), 3));
	}
	
	public static int kthSmallest(Node root, AtomicInteger i, int k)
	{
		// base case
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		// search in left subtree
		int left = kthSmallest(root.left, i, k);

		// if k'th smallest is found in left subtree, return it
		if (left != Integer.MAX_VALUE) {
			return left;
		}

		// if current element is k'th smallest, return its value
		if (i.incrementAndGet() == k) {
			return root.data;
		}

		// else search in right subtree
		return kthSmallest(root.right, i, k);
	}
	
	public static int minimumElementFromRight(Node root, AtomicInteger i, int k)
	{
		// base case
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		// search in left subtree
		int left = kthSmallest(root.left, i, k);

		// if k'th smallest is found in left subtree, return it
		if (left != Integer.MAX_VALUE) {
			return left;
		}

		// if current element is k'th smallest, return its value
		if (i.incrementAndGet() == k) {
			return root.data;
		}

		// else search in right subtree
		return kthSmallest(root.right, i, k);
	}

	// Function to find k'th smallest element in BST
	public static int kthSmallest(Node root, int k)
	{
		// maintain index to count number of nodes processed so far
		AtomicInteger i = new AtomicInteger(0);

		// traverse the tree in in-order fashion and return k'th element
		return kthSmallest(root, i, k);
	}
	
	/*public static int kthLargest(Node root, AtomicInteger i, int k)
	{
		// base case
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		// search in right subtree
		int left = kthLargest(root.right, i, k);

		// if k'th largest is found in left subtree, return it
		if (left != Integer.MAX_VALUE) {
			return left;
		}

		// if current element is k'th largest, return its value
		if (i.incrementAndGet() == k) {
			return root.data;
		}

		// else search in left subtree
		return kthLargest(root.left, i, k);
	}*/

}
