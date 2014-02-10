package plt.ms;

import java.util.Stack;

import plt.lists.Node;
import plt.trees.TreeNode;

public class Mspractice {

	public static void main(String[] args) {

		// System.out.println(fibonacci(0));
		// System.out.println(fibonacci(1));
		// System.out.println(fibonacci(2));
		// System.out.println(fibonacci(3));
		// System.out.println(fibonacci(4));
		// System.out.println(fibonacci(5));

		TreeNode node = createTree();
		inOrder(node);
		System.out.println(isTreeBST(node));

		TreeNode a = new TreeNode(25, null, null);
		TreeNode b = new TreeNode(34, null, null);

		TreeNode lca = getLCA(node, a, b);
		System.out.println("LCA of " + a.value + " and " + b.value + " = " + lca.value);

		// brackets(3);
		/*
				String test = "-123 456 789. 0";
				char[] testArr = test.toCharArray();
				System.out.println("Reversing position of words within a string...");
				System.out.println("Before : " + String.valueOf(testArr));
				reverseString(testArr);
				System.out.println("After : " + String.valueOf(testArr));

				testArr = test.toCharArray();
				System.out.println("Reversing string...");
				System.out.println("Before : " + String.valueOf(testArr));
				reverseString(testArr, 0, testArr.length - 1);
				System.out.println("Afte : " + String.valueOf(testArr));
		*/
		/*
				try {
					System.out.println("blank >> " + convertStrToInt(""));
					System.out.println("-0 >> " + convertStrToInt("-0"));
					System.out.println("1 >> " + convertStrToInt("1"));
					System.out.println("-1 >> " + convertStrToInt("-1"));
					System.out.println("12345 >> " + convertStrToInt("12345"));
					System.out.println("-12345 >> " + convertStrToInt("-12345"));
					System.out.println("12.345 >> " + convertStrToInt("12.345"));
					System.out.println("99999 >> " + convertStrToInt("99999"));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
		*/
		/*		
				try {
					String input = "0x1A2B3C4D";
					System.out.println(input);
					System.out.println(convertHexStrToIntStr(input));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				try {
					String input = "00x1A2B3C4D";
					System.out.println(input);
					System.out.println(convertHexStrToIntStr(input));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				try {
					String input = "1x1A2B3C4D";
					System.out.println(input);
					System.out.println(convertHexStrToIntStr(input));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				try {
					String input = "-0x1A2B3C4D";
					System.out.println(input);
					System.out.println(convertHexStrToIntStr(input));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				try {
					String input = "0x1A2B3C4G";
					System.out.println(input);
					System.out.println(convertHexStrToIntStr(input));
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
		*/
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
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

	/**
	 * 
	 * @param node
	 */
	public static void traversePreOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		System.out.print(node.value + " ");
		traversePreOrder(node.left);
		traversePreOrder(node.right);
	}

	/**
	 * 
	 * @param node
	 */
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

	/**
	 * 
	 * @param node
	 */
	public static void inOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.println(node.value + " ");
		inOrder(node.right);
	}

	/**
	 * 
	 * @param node
	 */
	public static void traversePostOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		traversePostOrder(node.left);
		traversePostOrder(node.right);
		System.out.println(node.value + " ");
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
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

	/**
	 * 
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
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

	/**
	 * 
	 * @param total
	 */
	public static void brackets(int total) {

		brackets("", 0, 0, total);
	}

	// "123 456 789." --> ".987 654 321"
	/**
	 * 
	 * @param input
	 */
	public static void reverseString(char[] input) {

		reverseString(input, 0, input.length - 1);

		int length = input.length;

		int start = 0;

		for (int left = 0; left < length; left++) {

			if (input[left] == 32) {// space
				// reverse word
				reverseString(input, start, left - 1);
				start = left + 1;	// start index of next word
			}
		}

		if (start != length - 1) {
			reverseString(input, start, length - 1);
		}
	}

	/**
	 * 
	 * @param input
	 * @param start
	 * @param end
	 */
	public static void reverseString(char[] input, int start, int end) {

		int length = (end - start) + 1;

		if (length < 2)
			return;

		for (int left = 0; left < length / 2; left++) {

			swap(input, start + left, start + length - 1 - left);
		}
	}

	public static void swap(char[] input, int left, int right) {

		char temp = input[right];
		input[right] = input[left];
		input[left] = temp;
	}

	// Convert String to Integer
	/**
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static int convertStrToInt(String input) throws Exception {

		// remove leading/trailing whitespaces
		input = input.trim();

		if (input.isEmpty()) {
			throw new Exception("Nothing to convert");
		}

		int length = input.length();

		// get lowest number, and move to the next by multiplying by 10
		int multiplier = 1;
		int value = 0;

		for (int i = length - 1; i >= 0; i--) {

			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {

				value += multiplier * (input.charAt(i) - '0');
				multiplier *= 10;

			}
			else if (i == 0) {
				if (input.charAt(i) == '-' || input.charAt(i) == '+') {
					if (input.charAt(i) == '-' && value > 0) {
						value = -value;
					}
				}
			}
			else {
				throw new Exception("Invalid input exception");
			}
		}

		return value;

	}

	// 0x1A2B 3C4D = 439041101
	/**
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static int convertHexStrToIntStr(String input) throws Exception {

		if (input == null)
			throw new Exception("Nothing to convert");

		input = input.trim();
		input = input.toUpperCase();

		int length = input.length();

		int multiplier = 1;
		int value = 0;
		int hexSignIdx = 0;

		for (int i = length - 1; i >= 0; i--) {

			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {

				if (hexSignIdx > 0) {
					if ((input.charAt(i) == '0' && (hexSignIdx - i > 1)) || input.charAt(i) != '0') {
						throw new Exception("Invalid input");
					}
					continue;	// no need to calculate this
				}
				value += multiplier * (input.charAt(i) - '0');
			}
			else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'F') {
				value += multiplier * (9 + input.charAt(i) - 64);
			}
			else if (input.charAt(i) == 'X') {
				hexSignIdx = i;
				continue;
			}
			else if (i == 0 && (input.charAt(i) == '-' || input.charAt(i) == '+')) {
				if (input.charAt(i) == '-') {
					value = -value;
				}
			}
			else {
				throw new Exception("Invalid input");
			}

			multiplier *= 16;
		}

		return value;
	}

	/**
	 * Reverse a SLL
	 * 
	 * @param node
	 * @return
	 */
	public static Node reverseList(Node node) {

		// Node head = null;

		if (node != null) {
			// head = node;
			Node prev = node;
			prev.next = null;
			Node next = node.next;

			while (next != null) {

				node = next;

				if (node.next == null) {
					node.next = prev;
					next = null;
				}
				else {
					next = node.next;	// save next
					node.next = prev;
					prev = node;
					node = next;
				}
			}
		}

		return node;
	}

}
