package plt.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTrees {

	public static TreeNode copyTree(TreeNode orig) {

		if (orig == null) {
			return null;
		}

		// Node copy = null;

		// return copyTree(orig, new Node());

		return copyTree2(orig);

	}

	public static Stack<TreeNode> getShortestPath(TreeNode root, TreeNode a, TreeNode b) {

		TreeNode lca = lca(root, a, b);

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		stack1.push(lca);

		getShortestPath(lca.left, a, stack1);

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		getShortestPath(lca.right, b, stack2);

		System.out.println("Shortest path is >>> ");

		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().value + "");
		}

		return stack1;
	}

	public static boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return false;
		}

		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(TreeNode left, TreeNode right) {

		if (left == null && right == null) {
			return true;
		}

		if (left != null && right != null && left.value == right.value) {
			return (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
		}

		return false;

	}

	public static TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {

		if (root == null) {
			return null;
		}

		// if we have a match, no need to continue further
		if (root.equals(a) || root.equals(b)) {
			return root;
		}

		TreeNode left = lca(root.left, a, b);
		TreeNode right = lca(root.right, a, b);

		// if both are not null, meaning we found them separately on each side
		// so this must be the LCA
		if (left != null && right != null) {
			return root;
		}

		// if only 1 side is not null, then they must have been found on that side only
		// or we could end up with both sides null, meaning not found on both sides.
		if (left != null)
			return left;

		return right;

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {

		System.out.println("root value = " + (root == null ? "null" : root.value));

		if (root == null) {
			System.out.println("return: null");
			return null;
		}
		if (root.value == a.value || root.value == b.value) {
			System.out.println("return: " + root.value);
			return root;
		}

		TreeNode l = lowestCommonAncestor(root.left, a, b);
		TreeNode r = lowestCommonAncestor(root.right, a, b);

		if (l != null && r != null) {
			System.out.println("return: " + root.value);
			return root; // if p and q are on both sides
		}

		if (l != null) {
			System.out.println("return: " + l.value);
		}
		else {
			System.out.println("return: " + (r == null ? "null" : r.value));
		}
		return l != null ? l : r; // either one of p,q is on one side OR p,q is not in L&R subtrees
	}

	public static void main(String[] args) {

		// testLCA();

		// testIsSymmetric();

		testBFS();

		// testCopyTree();

	}

	public static void testBFS() {

		TreeNode root = createTreeForTraversal();

		// traverseBFS(root);
		System.out.println("Test traverseTreeSpirally start >");
		traverseTreeSpirally(root);
		System.out.println("\nTest traverseTreeSpirally  end  <");

		System.out.println("Test traverseTreePerLevel start >");
		traverseTreePerLevel(root);
		System.out.println("\nTest traverseTreePerLevel  end  <");
	}

	public static void testCopyTree() {

		TreeNode node = createTreeForTraversal();
		traverseBFS(copyTree(node));

	}

	public static void testIsSymmetric() {

		TreeNode root = new TreeNode();
		root.value = 1;
		root.left = getNewNode(2);
		root.right = getNewNode(2);
		//
		// root.left.left = getNewNode(6);
		// root.left.right = getNewNode(4);
		//
		// root.right.left = getNewNode(4);
		// root.right.right = getNewNode(6);
		//
		// root.right.right.right = getNewNode(3);

		System.out.println("isSymmetric = " + isSymmetric(root));

	}

	public static void testLCA() {

		TreeNode root = new TreeNode();
		root.value = 1;

		TreeNode node2 = new TreeNode();
		root.left = node2;
		root.left.value = 2;

		TreeNode node3 = new TreeNode();
		root.right = node3;
		root.right.value = 3;

		TreeNode node4 = new TreeNode();
		root.left.left = node4;
		root.left.left.value = 4;

		TreeNode node5 = new TreeNode();
		root.left.right = node5;
		root.left.right.value = 5;

		TreeNode node6 = new TreeNode();
		root.right.left = node6;
		root.right.left.value = 6;

		TreeNode node7 = new TreeNode();
		root.right.right = node7;
		root.right.right.value = 7;

		TreeNode node8 = new TreeNode();
		root.left.left.left = node8;
		root.left.left.left.value = 8;
		TreeNode node9 = new TreeNode();
		root.left.left.right = node9;
		root.left.left.right.value = 9;

		TreeNode node10 = new TreeNode();
		root.left.right.left = node10;
		root.left.right.left.value = 10;

		TreeNode node11 = new TreeNode();
		root.left.right.right = node11;
		root.left.right.right.value = 11;

		TreeNode node12 = new TreeNode();
		root.right.left.left = node12;
		root.right.left.left.value = 12;

		TreeNode node13 = new TreeNode();
		root.right.left.right = node13;
		root.right.left.right.value = 13;

		// System.out.println("LCA is: " + lowestCommonAncestor(root, node9, node6).value);
		getShortestPath(root, node2, node3);
		getShortestPath(root, node5, node6);
		getShortestPath(root, node8, node12);

		// System.out.println("LCA 2/3 is: " + lca(root, node2, node3).value);
		// System.out.println("LCA 4/5 is: " + lca(root, node4, node5).value);
		// System.out.println("LCA 8/6 is: " + lca(root, node8, node6).value);
		// System.out.println("LCA 8/7 is: " + lca(root, node8, node7).value);
		// System.out.println("LCA 8/9 is: " + lca(root, node8, node9).value);
		// System.out.println("LCA 10/11 is: " + lca(root, node10, node11).value);
	}

	public static void traverseBFS(TreeNode node) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);

		while (!q.isEmpty()) {

			TreeNode n = q.remove();

			if (n != null) {
				System.out.print(n.value + " ");
				q.add(n.left);
				q.add(n.right);
			}
		}

	}

	public static void traverseTreePerLevel(TreeNode root) {

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		boolean oddLevel = true;

		q1.add(root);

		Queue<TreeNode> qPtr1 = null;
		Queue<TreeNode> qPtr2 = null;

		int level = 1;

		while (!q1.isEmpty() || !q2.isEmpty()) {
			System.out.println("\nLevel " + level++ + ":");

			if (oddLevel) {
				qPtr1 = q1;
				qPtr2 = q2;
			}
			else {
				qPtr1 = q2;
				qPtr2 = q1;
			}

			while (!qPtr1.isEmpty()) {
				TreeNode node = qPtr1.remove();
				if (node.left != null) {
					qPtr2.add(node.left);
				}
				if (node.right != null) {
					qPtr2.add(node.right);
				}
				System.out.print(node.value + " ");
			}

			// we're done traversing this level, time to print next level
			oddLevel = !oddLevel;

		}

	}

	public static void traverseTreeSpirally(TreeNode root) {

		if (root == null) {
			return;
		}

		boolean goRight = true;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();

		s1.push(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {

			TreeNode node = null;

			if (goRight) {
				node = s1.pop();
				if (node.left != null) {
					s2.push(node.left);
				}
				if (node.right != null) {
					s2.push(node.right);
				}
			}
			else {
				node = s2.pop();
				if (node.right != null) {
					s1.push(node.right);
				}
				if (node.left != null) {
					s1.push(node.left);
				}
			}

			System.out.print(node.value + " ");

			if (s1.isEmpty()) {
				goRight = false;
			}
			else if (s2.isEmpty()) {
				goRight = true;
			}
		}

	}

	private static TreeNode copyTree(TreeNode orig, TreeNode copy) {

		if (orig == null) {
			return null;
		}

		copy.value = orig.value;

		if (orig.left != null) {
			copy.left = new TreeNode();
			copyTree(orig.left, copy.left);
		}

		if (orig.right != null) {
			copy.right = new TreeNode();
			copyTree(orig.right, copy.right);
		}

		return copy;

	}

	private static TreeNode copyTree2(TreeNode orig) {

		if (orig == null) {
			return null;
		}

		TreeNode copy = new TreeNode();
		copy.value = orig.value;

		copy.left = copyTree2(orig.left);
		copy.right = copyTree2(orig.right);

		return copy;

	}

	private static TreeNode createTreeForTraversal() {

		TreeNode root = new TreeNode();
		root.value = 1;

		TreeNode node2 = new TreeNode();
		root.left = node2;
		root.left.value = 2;

		TreeNode node3 = new TreeNode();
		root.right = node3;
		root.right.value = 3;

		TreeNode node4 = new TreeNode();
		root.left.left = node4;
		root.left.left.value = 4;

		TreeNode node5 = new TreeNode();
		root.left.right = node5;
		root.left.right.value = 5;

		TreeNode node6 = new TreeNode();
		root.right.left = node6;
		root.right.left.value = 6;

		TreeNode node7 = new TreeNode();
		root.right.right = node7;
		root.right.right.value = 7;

		TreeNode node8 = new TreeNode();
		root.left.left.left = node8;
		root.left.left.left.value = 8;
		TreeNode node9 = new TreeNode();
		root.left.left.right = node9;
		root.left.left.right.value = 9;

		TreeNode node10 = new TreeNode();
		root.left.right.left = node10;
		root.left.right.left.value = 10;

		TreeNode node11 = new TreeNode();
		root.left.right.right = node11;
		root.left.right.right.value = 11;

		TreeNode node12 = new TreeNode();
		root.right.left.left = node12;
		root.right.left.left.value = 12;

		TreeNode node13 = new TreeNode();
		root.right.left.right = node13;
		root.right.left.right.value = 13;

		return root;
	}

	private static TreeNode getNewNode(int value) {

		TreeNode node = new TreeNode();
		node.value = value;
		return node;
	}

	private static TreeNode getShortestPath(TreeNode root, TreeNode target, Stack<TreeNode> stack) {

		if (root == null) {
			return null;
		}

		if (root.value == target.value) {
			return root;
		}
		stack.push(root);

		TreeNode left = getShortestPath(root.left, target, stack);
		TreeNode right = getShortestPath(root.right, target, stack);

		if (left == null && right == null) {
			if (!stack.isEmpty())
				stack.pop();
		}

		return left != null ? left : right;
	}
}
