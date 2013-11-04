package plt.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import plt.Logger;

public class BSTrees {

	public static plt.Logger logger = new Logger(false);

	public static void main(String[] args) {

		int[] bstTree1 = new int[] { 1, 3, 4, 6, 7, 8, 10, 13, 14 };
		// int[] bstTree1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
		// };

		TreeNode node = createBSTree(bstTree1, 0, bstTree1.length - 1);

		// System.out.println("\nIn Order >> ");
		// traverseInOrder(node);
		System.out.println("\nPre Order >> ");
		traversePreOrder(node);
		System.out.println("\nPre Order Iterative >> ");
		traversePreOrder_Iterative(node);

		TreeNode mirrorNode = mirrorTree_Iterative(node);
		System.out.println("\nPre Order Iterative of Mirror >> ");
		traversePreOrder_Iterative(mirrorNode);

		// now try to restore it back -- mirror the mirrored tree
		TreeNode restoredNode = mirrorTree_Recurse(mirrorNode);
		System.out.println("\nPre Order Iterative of Mirrored Mirror >> ");
		traversePreOrder_Iterative(restoredNode);

		mirrorTree_BFS(restoredNode);
		System.out.println("\nPre Order Iterative of Mirrored BFS -- should be mirror >> ");
		traversePreOrder_Iterative(restoredNode);

		// System.out.println("\nPost Order >> ");
		// traversePostOrder(node);

		// System.out.println("\n" + searchAddends(node, 10));
		// System.out.println("\n" + searchAddends(node, 13));
		// System.out.println("\n" + searchAddends(node, 15));
		// System.out.println("\n" + searchAddends(node, 22));

	}

	public static TreeNode createBSTree(int[] values, int start, int end) {

		logger.log("S:" + start + " E:" + end);

		if (start == end) {
			logger.log("   value[" + end + "] = " + values[end]);
			return new TreeNode(values[end], null, null);
		}

		int mid = start + (end - start + 1) / 2;

		logger.log("S:" + start + " M:" + mid + " E:" + end);
		logger.log("   value[" + mid + "] = " + values[mid]);

		TreeNode node = new TreeNode();
		node.value = values[mid];
		node.left = createBSTree(values, start, mid - 1);
		if (mid < end) {
			node.right = createBSTree(values, mid + 1, end);
		}

		return node;
	}

	/* 	inorder(node)
	 *		if node == null then return
	 *		inorder(node.left)
	 *		visit(node)
	 *		inorder(node.right)
	 */

	public static void traverseInOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		traverseInOrder(node.left);
		System.out.print(node.value + " ");
		traverseInOrder(node.right);
	}

	/* 	preorder(node)
	 *		if node == null then return
	 *		visit(node)
	 *		preorder(node.left) 
	 *		preorder(node.right)
	 */
	public static void traversePreOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		System.out.print(node.value + " ");
		traversePreOrder(node.left);
		traversePreOrder(node.right);
	}

	public static void traversePreOrder_Iterative(TreeNode node) {

		if (node == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.isEmpty() || node != null) {

			if (node != null) {
				System.out.print(node.value + " ");

				if (node.right != null) {
					stack.push(node.right);
				}
				node = node.left;
			}
			else {
				node = stack.pop();
			}
		}

	}

	public static TreeNode mirrorTree_Iterative(TreeNode node) {

		if (node == null) {
			return null;
		}

		TreeNode mirrorNode = new TreeNode();
		TreeNode mNode = mirrorNode;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> mStack = new Stack<TreeNode>();

		while (!stack.isEmpty() || node != null) {

			if (node != null) {
				// System.out.print(node.value + " ");
				mNode.value = node.value;

				if (node.right != null) {
					stack.push(node.right);

					mNode.left = new TreeNode();
					mStack.push(mNode.left);
				}
				node = node.left;

				if (node != null) {
					mNode.right = new TreeNode();
					mNode = mNode.right;
				}
				else {
					mNode.right = null;

				}
			}
			else {
				node = stack.pop();
				mNode = mStack.pop();
			}
		}

		return mirrorNode;

	}

	public static TreeNode mirrorTree_Recurse(TreeNode node) {

		if (node == null) {
			return null;
		}

		TreeNode mirrorNode = new TreeNode();

		mirrorNode.value = node.value;
		mirrorNode.left = mirrorTree_Recurse(node.right);
		mirrorNode.right = mirrorTree_Recurse(node.left);

		return mirrorNode;

	}

	/**
	 * In-place mirroring of the tree
	 * 
	 * @param node
	 * @return
	 */
	public static TreeNode mirrorTree_BFS(TreeNode node) {

		if (node == null) {
			return null;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);

		while (!q.isEmpty()) {
			TreeNode qNode = q.remove();

			TreeNode temp = qNode.left;
			qNode.left = qNode.right;
			qNode.right = temp;

			if (qNode.left != null) {
				q.add(qNode.left);
			}

			if (qNode.right != null) {
				q.add(qNode.right);
			}
		}

		return node;

	}

	/*
	 * 	postorder(node)
			if node == null then return
			postorder(node.left)
			postorder(node.right)
			visit(node)
	 */
	public static void traversePostOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		traversePostOrder(node.left);
		traversePostOrder(node.right);
		System.out.print(node.value + " ");
	}

	/**
	 * Returns the nodes whose sum is equal to the argument
	 * 
	 * @param node
	 * @param sum
	 */
	public static String searchAddends(TreeNode node, int sum) {

		if (node == null) {
			return "Are you stooopid?";
		}

		Stack<TreeNode> leftStack = new Stack<TreeNode>();
		Stack<TreeNode> rightStack = new Stack<TreeNode>();

		TreeNode left = node;
		TreeNode right = node;

		// get the leftmost node
		while (left.left != null) {
			leftStack.push(left);
			left = left.left;
		}

		// get the rightmost node
		while (right.right != null) {
			rightStack.push(right);
			right = right.right;
		}

		// Stop if we found the addends, or
		// left and right is about to crisscross, which means not found
		while (left.value + right.value != sum && left.value < right.value) {

			System.out.println("left = " + left.value + ", right=" + right.value);

			if (left.value + right.value < sum) {

				if (left.right != null) {
					left = left.right;
					while (left.left != null) {
						leftStack.push(left);
						left = left.left;
					}
				}
				else {
					left = leftStack.pop();
				}
			}
			else { // (left.value + right.value > sum)

				if (right.left != null) {
					right = right.left;

					while (right.right != null) {
						rightStack.push(right);
						right = right.right;
					}
				}
				else {
					right = rightStack.pop();
				}
			}

		}

		if (left.value + right.value == sum) {
			return left.value + " + " + right.value + " = " + sum;
		}

		return "Addends not found!";

	}
}
