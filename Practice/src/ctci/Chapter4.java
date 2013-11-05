package ctci;

import plt.trees.BSTrees;
import plt.trees.TreeNode;
import ctci.types.Graph;
import ctci.types.GraphNode;

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

		TreeNode root1 = new TreeNode(10, new TreeNode(9, new TreeNode(8, new TreeNode(7, null, null), null),
				null), null);
		System.out.println("root 1 Balanced = false? " + Q4_1_isBTreeBalanced(root1));

		TreeNode root2Left = new TreeNode(9, new TreeNode(8, new TreeNode(7), new TreeNode(6)), new TreeNode(
				5));
		TreeNode root2Right = new TreeNode(9, new TreeNode(8, new TreeNode(7, null, null), null), null);
		TreeNode root2 = new TreeNode(10, root2Left, root2Right);

		System.out.println("root 2 Balanced = false? " + Q4_1_isBTreeBalanced(root2));

		TreeNode root3Left = new TreeNode(9, new TreeNode(8, new TreeNode(7), new TreeNode(6)), new TreeNode(
				5));
		TreeNode root3Right = new TreeNode(9, new TreeNode(8, new TreeNode(7), new TreeNode(6)), null);
		TreeNode root3 = new TreeNode(10, root3Left, root3Right);

		System.out.println("root 3 Balanced = false? " + Q4_1_isBTreeBalanced(root3));

		TreeNode root4Left = new TreeNode(9, new TreeNode(8, new TreeNode(7), new TreeNode(6)), new TreeNode(
				5));
		TreeNode root4Right = new TreeNode(9, new TreeNode(8, new TreeNode(7), new TreeNode(6)),
				new TreeNode(5));
		TreeNode root4 = new TreeNode(10, root4Left, root4Right);

		System.out.println("root 4 Balanced = true? " + Q4_1_isBTreeBalanced(root4));

	}

	/**
	 * Checks if a given binary tree is balanced or not
	 * 
	 * @param n
	 * @return
	 */
	public static boolean Q4_1_isBTreeBalanced(TreeNode n) {

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

	private static int getHeight(TreeNode node) {

		if (node == null) {
			return 0;
		}

		int left = getHeight(node.left);
		int right = getHeight(node.right);

		return Math.max(left, right) + 1;

	}

	// TODO:
	/**
	 * Given a directed graph, design an algorithm to find out whether there is a
	 * route between 2 nodes
	 * 
	 * @param g
	 * @param a
	 * @param b
	 */
	public static <V> void Q4_2_routeBetween2Nodes(Graph<V> g, GraphNode<V> a, GraphNode<V> b) {

	}

	public static void testQ4_3_convertSortedArrToBST() {

		TreeNode node1 = Q4_3_convertSortedArrToBST(new int[] { 1 });
		System.out.println("");
		BSTrees.traverseInOrder(node1);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1));
		System.out.println("isBST ? " + Q4_5_isBST(node1));
		TreeNode node1_2 = Q4_3_convertSortedArrToBST(new int[] { 1, 2 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_2);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_2));
		System.out.println("isBST ? " + Q4_5_isBST(node1_2));
		TreeNode node1_3 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_3);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_3));
		System.out.println("isBST ? " + Q4_5_isBST(node1_3));
		TreeNode node1_4 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3, 4 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_4);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_4));
		System.out.println("isBST ? " + Q4_5_isBST(node1_4));
		TreeNode node1_5 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("");
		BSTrees.traverseInOrder(node1_5);
		System.out.println("Balanced? " + Q4_1_isBTreeBalanced(node1_5));
		System.out.println("isBST ? " + Q4_5_isBST(node1_5));
		TreeNode node1_10 = Q4_3_convertSortedArrToBST(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
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
	public static TreeNode Q4_3_convertSortedArrToBST(int arr[]) {

		if (arr.length == 0) {
			return null;
		}

		return convertSortedArrToBST(arr, 0, arr.length - 1);
	}

	private static TreeNode convertSortedArrToBST(int arr[], int start, int end) {

		if (start == end) {
			return new TreeNode(arr[start], null, null);
		}

		int len = (end - start) + 1;
		int mid = start + (len / 2);

		TreeNode node = new TreeNode(arr[mid], null, null);	// left could be in this line, but for readability
															// sake
		node.left = convertSortedArrToBST(arr, start, mid - 1);

		if (mid < end) {
			node.right = convertSortedArrToBST(arr, mid + 1, end);
		}

		return node;
	}

	// TODO:
	/**
	 * Given a binary tree, design an algorithm which creates a linked list of all
	 * the nodes at each depth (eg: if you have a tree with depth D, you will have D linked lists)
	 * 
	 * @param g
	 * @param a
	 * @param b
	 */
	public static void Q4_4_makeLinkedListPerTreeDepth(TreeNode node) {

	}

	public static boolean Q4_5_isBST(TreeNode node) {

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

	// TODO:
	/**
	 * Write an algorithm to find the "next" node (ie: in-order successor) of a
	 * given node in a BST. You may assume each node has a link to its parent
	 * 
	 * @param g
	 * @param a
	 * @param b
	 */
	public static void Q4_6_findNextNodeInOrder(TreeNode node) {

	}

	// TODO:
	/**
	 * Find LCA. Not a BST
	 * 
	 * @param g
	 * @param a
	 * @param b
	 */
	public static TreeNode Q4_7_findLCA(TreeNode node, TreeNode n1, TreeNode n2) {

		// this check is done in findNode()
		// if (node == null) {
		// return null;
		// }

		if (findNode(node.left, n1) && findNode(node.left, n2)) {
			return Q4_7_findLCA(node.left, n1, n2);
		}
		if (findNode(node.right, n1) && findNode(node.right, n2)) {
			return Q4_7_findLCA(node.right, n1, n2);
		}
		return node;
	}

	private static boolean findNode(TreeNode node, TreeNode n) {

		if (node == null) {
			return false;
		}
		if (node == n) {
			return true;
		}

		return findNode(node.left, n) || findNode(node.right, n);
	}

	// TODO:
	/**
	 * Check if 2nd tree is a subtree of the first tree.
	 * first tree has millions of nodes
	 * 
	 * @param g
	 * @param a
	 * @param b
	 */
	public static boolean Q4_8_containsSubtree(TreeNode node, TreeNode subTreeNode) {

		if (subTreeNode == null) {
			return false;	// null subtree will never match anything
		}

		return isSubtree(node, subTreeNode);

	}

	private static boolean isSubtree(TreeNode n1, TreeNode n2) {

		if (n1 == null) {
			return false;	// subtree will never be found in a null tree
		}

		if (n1.value == n2.value) {
			if (matchTree(n1, n2))
				return true;
		}
		// didnt match, need to drill down
		return isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
	}

	private static boolean matchTree(TreeNode n1, TreeNode n2) {

		if (n1 == null && n2 == null) {
			return true;
		}
		// only 1 is null, of course they dont match
		if (n1 == null || n2 == null) {
			return false;
		}

		if (n1.value != n2.value) {
			return false;
		}

		return matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right);

	}

	// TODO:
	/**
	 * You are given a binary tree in which each node contains a value.
	 * Design an algorithm to print all paths which sum to a given value.
	 * The path does not need to start or end at the root or a leaf.
	 * 
	 * @param g
	 * @param a
	 * @param b
	 */
	public static void Q4_9_printPathsSumToValue(TreeNode node, int value) {

	}

}
