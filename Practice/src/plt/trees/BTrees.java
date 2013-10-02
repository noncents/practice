package plt.trees;

import java.util.Stack;

public class BTrees {

	public static void main(String[] args) {

		Node root = new Node();
		root.value = 1;

		Node node2 = new Node();
		root.left = node2;
		root.left.value = 2;

		Node node3 = new Node();
		root.right = node3;
		root.right.value = 3;

		Node node4 = new Node();
		root.left.left = node4;
		root.left.left.value = 4;

		Node node5 = new Node();
		root.left.right = node5;
		root.left.right.value = 5;

		Node node6 = new Node();
		root.right.left = node6;
		root.right.left.value = 6;

		Node node7 = new Node();
		root.right.right = node7;
		root.right.right.value = 7;

		Node node8 = new Node();
		root.left.left.left = node8;
		root.left.left.left.value = 8;
		Node node9 = new Node();
		root.left.left.right = node9;
		root.left.left.right.value = 9;

		Node node10 = new Node();
		root.left.right.left = node10;
		root.left.right.left.value = 10;

		Node node11 = new Node();
		root.left.right.right = node11;
		root.left.right.right.value = 11;

		Node node12 = new Node();
		root.right.left.left = node12;
		root.right.left.left.value = 12;

		Node node13 = new Node();
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

	public static Stack<Node> getShortestPath(Node root, Node a, Node b) {

		Node lca = lca(root, a, b);

		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();

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

	private static Node getShortestPath(Node root, Node target, Stack<Node> stack) {

		if (root == null) {
			return null;
		}

		if (root.value == target.value) {
			return root;
		}
		stack.push(root);

		Node left = getShortestPath(root.left, target, stack);
		Node right = getShortestPath(root.right, target, stack);

		if (left == null && right == null) {
			if (!stack.isEmpty())
				stack.pop();
		}

		return left != null ? left : right;
	}

	public static Node lca(Node root, Node a, Node b) {

		if (root == null) {
			return null;
		}

		if (root.value == a.value || root.value == b.value) {
			return root;
		}

		Node left = lca(root.left, a, b);
		Node right = lca(root.right, a, b);

		if (left != null && right != null) {
			return root;
		}

		if (left != null)
			return left;

		return right;

	}

	public static Node lowestCommonAncestor(Node root, Node a, Node b) {

		System.out.println("root value = " + (root == null ? "null" : root.value));

		if (root == null) {
			System.out.println("return: null");
			return null;
		}
		if (root.value == a.value || root.value == b.value) {
			System.out.println("return: " + root.value);
			return root;
		}

		Node l = lowestCommonAncestor(root.left, a, b);
		Node r = lowestCommonAncestor(root.right, a, b);

		if (l != null && r != null) {
			System.out.println("return: " + root.value);
			return root;  // if p and q are on both sides
		}

		if (l != null) {
			System.out.println("return: " + l.value);
		}
		else {
			System.out.println("return: " + (r == null ? "null" : r.value));
		}
		return l != null ? l : r;  // either one of p,q is on one side OR p,q is not in L&R subtrees
	}
}
