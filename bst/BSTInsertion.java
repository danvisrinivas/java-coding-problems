package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

public class BSTInsertion {
	public static void main(String[] args) {
		Node root = insertBSTSmall();

		// System.out.print("inorder:" + "\n"

		//System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		//System.out.println(inorderTraversal(deleteNode(root, 25)));

		//System.out.println(inorderTraversal(createMirrorWithoutRecursion(root)));

		System.out.print("preorder:" + "\n" +preorderTraversal(root));

		//System.out.print("postorder:" + "\n" +postorderTraversal(root));

		// printTreeLevelOrder(root);

		// createMirrorWithoutRecursion(root);
		// System.out.print("inorder:" + "\n" +inorderTraversal(root));
		// System.out.print("inorder:" + "\n" +kthSmallest(root,1));

		// Node lca = findLca(root, 12,25);
		// System.out.println(lca.data);
	}

	public static Node insertBST() {
		Node root = null;
		int keys[] = { 15, 10, 20, 8, 12, 16, 25 };
		for (int key : keys) {
			root = iterativeInsertionIntoBST(root, key);
		}
		return root;
	}

	public static Node insertBSTSmall() {
		Node root = null;
		int keys[] = { 15, 10, 20, 25 };
		for (int key : keys) {
			root = iterativeInsertionIntoBST(root, key);
		}
		return root;
	}

	public static List<Integer> inorderTraversal(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node top = stack.peek();
			if (top.left != null) {
				stack.push(top.left);
				top.left = null;
			} else {
				result.add(top.data);
				stack.pop();
				if (top.right != null) {
					stack.push(top.right);
				}
			}
		}
		return result;
	}

	public static ArrayList<Integer> preorderTraversal(Node root) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if (root == null)
			return returnList;
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty()) {
			Node n = stack.pop();
			returnList.add(n.data);

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
		return returnList;
	}

	public static List<Integer> postorderTraversal(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node temp = stack.peek();
			if (temp.left == null && temp.right == null) {
				Node pop = stack.pop();
				res.add(pop.data);
			} else {
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}
				if (temp.left != null) {
					stack.push(temp.left);
					temp.left = null;
				}
			}
		}
		return res;
	}

	public static Node iterativeInsertionIntoBST(Node root, int key) {
		Node current = root;
		Node parent = null;
		if (current == null) {
			return new Node(key);
		}
		while (current != null) {
			parent = current;
			if (key < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (key < parent.data) {
			parent.left = new Node(key);
		} else {
			parent.right = new Node(key);
		}
		return root;
	}

	public static Node createMirrorWithoutRecursion(Node rootNode) {
		if (rootNode == null) {
			return null;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(rootNode);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			Node swapTemp = temp.getLeft();
			temp.setLeft(temp.getRight());
			temp.setRight(swapTemp);
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return rootNode;
	}

	public static void printTreeLevelOrder(Node rootNode) {
		if (rootNode == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			Node obj = queue.poll();
			System.out.print(obj.getData() + " ");
			if (obj.getLeft() != null)
				queue.add(obj.getLeft());

			if (obj.getRight() != null)
				queue.add(obj.getRight());
		}
	}

	public static int kthSmallest(Node root, int k) {
		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		int result = 0;

		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.right;
			} else {
				Node t = stack.pop();
				k--;
				if (k == 0)
					result = t.data;
				p = t.left;
			}
		}
		return result;
	}

	public static boolean isBST(Node node, int minKey, int maxKey) {
		// base case
		if (node == null) {
			return true;
		}

		// if node's value fall outside valid range
		if (node.data < minKey || node.data > maxKey) {
			return false;
		}

		// recursively check left and right subtrees with updated range
		return isBST(node.left, minKey, node.data) && isBST(node.right, node.data, maxKey);
	}

	public static void isBST(Node root) {
		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("This is a BST.");
		} else {
			System.out.println("This is NOT a BST!");
		}
	}

	// Get minimum element in binary search tree
	public static Node minimumElement(Node root) {
		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}

	public static Node deleteNode(Node root, int value) {
		if (root == null)
			return null;
		if (root.data > value) {
			root.left = deleteNode(root.left, value);
		} else if (root.data < value) {
			root.right = deleteNode(root.right, value);

		} else {
			// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
				Node temp = root;
				// Finding minimum element from right
				Node minNodeForRight = minimumElement(temp.right);
				// Replacing current node with minimum node from right subtree
				root.data = minNodeForRight.data;
				// Deleting minimum node from right now
				deleteNode(root.right, minNodeForRight.data);

			}
			// if nodeToBeDeleted has only left child
			else if (root.left != null) {
				root = root.left;
			}
			// if nodeToBeDeleted has only right child
			else if (root.right != null) {
				root = root.right;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				root = null;
		}
		return root;
	}
}
/**
 * Pre-order (Root, Left, Right)
 * In-order (Left, Root, Right)
 * Post-order (Left, Right, Root)
 * // Example in Java:
 * void inOrder(TreeNode node) {
 *     if (node != null) {
 *         inOrder(node.left);
 *         System.out.print(node.value + " ");
 *         inOrder(node.right);
 *     }
 * }
 *
 * void preOrder(TreeNode node) {
 *     if (node != null) {
 *         System.out.print(node.value + " ");
 *         preOrder(node.left);
 *         preOrder(node.right);
 *     }
 * }
 *
 * void postOrder(TreeNode node) {
 *     if (node != null) {
 *         postOrder(node.left);
 *         postOrder(node.right);
 *         System.out.print(node.value + " ");
 *     }
 * }
 */
