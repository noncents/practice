package plt.ms;

import plt.trees.TreeNode;

public class Mspractice {

	public static void main(String[] args) {

		// System.out.println(fibonacci(0));
		// System.out.println(fibonacci(1));
		// System.out.println(fibonacci(2));
		// System.out.println(fibonacci(3));
		// System.out.println(fibonacci(4));
		// System.out.println(fibonacci(5));

		// TreeNode node = createTree();
		// inOrder(node);
		// System.out.println(isTreeBST(node));
		//
		// TreeNode a = new TreeNode(25, null, null);
		// TreeNode b = new TreeNode(34, null, null);
		//
		// TreeNode lca = getLCA(node, a, b);
		// System.out.println("LCA of " + a.value + " and " + b.value + " = " + lca.value);

		brackets(3);

	}

	public static int fibonacci(int n) {

		int prevprev = 0;
		int prev = 1;
		int i = 2;
		int fib = 0;

		if (n == 0) {
			return prevprev;
		}

		while (i++ <= n) {

			fib = prev + prevprev;
			prevprev = prev;
			prev = fib;
		}

		return prev;

	}

	public static void inOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.println(node.value + " ");
		inOrder(node.right);
	}

	public static boolean isTreeBST(TreeNode node) {

		if (node == null || node.left == null && node.right == null) {
			return true;
		}

		boolean isLeftBST = false;
		boolean isRightBST = false;

		// drill down
		if (node.left != null && node.left.value <= node.value) {
			isLeftBST = isTreeBST(node.left);
		}

		if (node.right != null && node.right.value >= node.value) {
			isRightBST = isTreeBST(node.right);
		}

		return isLeftBST && isRightBST;
	}

	private static TreeNode createTree() {

		TreeNode root = new TreeNode(20, null, null);
		TreeNode left = new TreeNode(10, null, null);
		TreeNode right = new TreeNode(30, null, null);
		root.left = left;
		root.right = right;

		TreeNode left1 = new TreeNode(5, null, null);
		TreeNode right1 = new TreeNode(15, null, null);
		left.left = left1;
		left.right = right1;

		TreeNode left2 = new TreeNode(25, null, null);
		TreeNode right2 = new TreeNode(35, null, null);
		right.left = left2;
		right.right = right2;

		return root;
	}

	public static TreeNode getLCA(TreeNode root, TreeNode a, TreeNode b) {

		if (root == null) {
			return null;
		}

		if (root.value == a.value || root.value == b.value) {
			return root;
		}

		TreeNode x = getLCA(root.left, a, b);
		TreeNode y = getLCA(root.right, a, b);

		// found in separate subtrees, so this must be the root
		if (x != null && y != null) {
			return root;
		}

		return x != null ? x : y;
	}

	private static void brackets(String output, int open, int close, int pairs) {

		if (open == pairs && close == pairs) {
			System.out.println(output);
		}
		else {
			if (open < pairs) {
				brackets(output + "(", open + 1, close, pairs);
			}
			if (close < open) {
				brackets(output + ")", open, close + 1, pairs);
			}
		}
	}

	public static void brackets(int total) {

		brackets("", 0, 0, total);
	}

}
