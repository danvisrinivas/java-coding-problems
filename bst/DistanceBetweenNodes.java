package bst;

public class DistanceBetweenNodes {

	public static void main(String[] args) {
		Node root = null;
		int keys[] = { 15, 10, 20, 8, 12, 16, 25 };
		for (int key : keys) {
			root = BSTInsertion.iterativeInsertionIntoBST(root, key);
		}

		System.out.println(findDistance(root, 12, 25));
	}

	public static int findDistance(Node root, int n1, int n2) {
		int x = Pathlength(root, n1) - 1;
		int y = Pathlength(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).data;
		System.out.println(lcaData);
		int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public static int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public static Node findLCA(Node root, int n1, int n2) {
		if (root != null) {
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node left = findLCA(root.left, n1, n2);
			Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}

}
