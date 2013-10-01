package plt.trees;

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

		root.left.left = new Node();
		root.left.left.value = 4;
		root.left.right = new Node();
		root.left.right.value = 5;

		root.right.left = new Node();
		root.right.left.value = 6;
		root.right.right = new Node();
		root.right.right.value = 7;

		Node node8 = new Node();
		root.left.left.left = node8;
		root.left.left.left.value = 8;
		root.left.left.right = new Node();
		root.left.left.right.value = 9;

		Node node10 = new Node();
		root.left.right.left = node10;
		root.left.right.left.value = 10;
		root.left.right.right = new Node();
		root.left.right.right.value = 11;

		System.out.println("LCA of 2 and 3 is: " + lowestCommonAncestor(root, node8, node10).value);

	}

	public static Node lowestCommonAncestor(Node root, Node a, Node b) {

		System.out.println(root == null ? "null" : root.value);

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
