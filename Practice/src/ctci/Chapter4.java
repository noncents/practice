package ctci;

import plt.trees.BSTrees;
import plt.trees.Node;

/**
 * Trees and Graphs
 * 
 * @author Patrick Tan
 * 
 */
public class Chapter4 {

	public static void main(String[] args) {

		// testQ4_1_isBTreeBalanced();
		testQ4_3_convertSortedArrToBST();

	}

	public static void testQ4_1_isBTreeBalanced() {

		Node root1 = new Node(10, new Node(9, new Node(8, new Node(7, null, null), null), null), null);
		System.out.println("root 1 Balanced = false? " + Q4_1_isBTreeBalanced(root1));

		Node root2Left = new Node(9, new Node(8, new Node(7), new Node(6)), new Node(5));
		Node root2Right = new Node(9, new Node(8, new Node(7, null, null), null), null);
		Node root2 = new Node(10, root2Left, root2Right);

		System.out.println("root 2 Balanced = false? " + Q4_1_isBTreeBalanced(root2));

		Node root3Left = new Node(9, new Node(8, new Node(7), new Node(6)), new Node(5));
		Node root3Right = new Node(9, new Node(8, new Node(7), new Node(6)), null);
		Node root3 = new Node(10, root3Left, root3Right);

		System.out.println("root 3 Balanced = false? " + Q4_1_isBTreeBalanced(root3));

		Node root4Left = new Node(9, new Node(8, new Node(7), new Node(6)), new Node(5));
		Node root4Right = new Node(9, new Node(8, new Node(7), new Node(6)), new Node(5));
		Node root4 = new Node(10, root4Left, root4Right);

		System.out.println("root 4 Balanced = true? " + Q4_1_isBTreeBalanced(root4));

	}

	/**
	 * Checks if a given binary tree is balanced or not
	 * 
	 * @param n
	 * @return
	 */
	public static boolean Q4_1_isBTreeBalanced(Node n) {

		if (n == null) {
			return true;
		}

		// if height of both sides are balanced,
		// then need to recurse down to their individual subtrees
		if (Math.abs(getHeight(n.left) - getHeight(n.right)) > 1) {
			return false;
		}

		return Q4_1_isBTreeBalanced(n.left) && Q4_1_isBTreeBalanced(n.right);
	}

	private static int getHeight(Node node) {

		if (node == null) {
			return 0;
		}

		int left = getHeight(node.left);
		int right = getHeight(node.right);

		return Math.max(left, right) + 1;

	}

	public static void testQ4_3_convertSortedArrToBST() {

		Node node1 = Q4_3_convertSortedArrToBST(new int[] { 1 });
		System.out.println("");
		BSTrees.traverseInOrder(node1);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1));
		System.out.println("isBST ? " + Q4_5_isBST(node1));
		Node node1_2 = Q4_3_convertSortedArrToBST(new int[] { 1, 2 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_2);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_2));
		System.out.println("isBST ? " + Q4_5_isBST(node1_2));
		Node node1_3 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_3);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_3));
		System.out.println("isBST ? " + Q4_5_isBST(node1_3));
		Node node1_4 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3, 4 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_4);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_4));
		System.out.println("isBST ? " + Q4_5_isBST(node1_4));
		Node node1_5 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_5);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_5));
		System.out.println("isBST ? " + Q4_5_isBST(node1_5));
		Node node1_10 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_10);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_10));
		System.out.println("isBST ? " + Q4_5_isBST(node1_10));
	}

	/**
	 * Convert a given array with sorted unique values into a BST
	 * 
	 * @param arr
	 * @return
	 */
	public static Node Q4_3_convertSortedArrToBST(int arr[]) {

		if (arr.length == 0) {
			return null;
		}

		return convertSortedArrToBST(arr, 0, arr.length - 1);
	}

	private static Node convertSortedArrToBST(int arr[], int start, int end) {

		if (start == end) {
			return new Node(arr[start], null, null);
		}

		int len = (end - start) + 1;
		int mid = start + (len / 2);

		Node node = new Node(arr[mid], null, null);	// left could be in this line, but for readbility sake
		node.left = convertSortedArrToBST(arr, start, mid - 1);

		if (mid < end) {
			node.right = convertSortedArrToBST(arr, mid + 1, end);
		}

		return node;
	}

	public static boolean Q4_5_isBST(Node node) {

		if (node == null) {
			return true;
		}

		boolean left = false;
		boolean right = false;

		if (node.left == null || node.left != null && node.value > node.left.value) {
			left = Q4_5_isBST(node.left);
		}

		if (node.right == null || node.right != null && node.value < node.right.value) {
			right = Q4_5_isBST(node.right);
		}

		return left && right;

	}

}
