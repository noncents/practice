package ctci;

import java.util.Stack;

public class Chapter3 {

	public static void main(String[] args) {

		// test_Q3_4_TowersOfHanoi(3);

		test_Q3_6_sortStack();
	}

	private static class Tower {

		Stack<Integer> stack = new Stack<Integer>();
		String name = null;

		public Tower(String name, int n) {

			this.name = name;

			for (int i = n; i > 0; i--) {

				stack.push(i);
			}
		}

		public Integer removeTop() {

			if (!stack.isEmpty()) {
				return stack.pop();
			}

			return null;
		}

		public void add(Integer value) {

			stack.push(value);
		}
	}

	public static void test_Q3_4_TowersOfHanoi(int n) {

		Tower left = new Tower("Left", n);
		Tower mid = new Tower("Mid", 0);
		Tower right = new Tower("Right", 0);

		Q3_4_TowersOfHanoi(n, left, mid, right);

		while (!right.stack.isEmpty()) {

			System.out.println(right.removeTop());
		}
	}

	/*
	 * 1. Move the top N - 1 disks from Src to Aux (using Dst as an intermediary peg)
	 * 2. Move the bottom disk from Src to Dst
	 * 3. Move N - 1 disks from Aux to Dst (using Src as an intermediary peg)
	 * 
	 * http://www.cut-the-knot.com/recurrence/hanoi.shtml
	 */
	public static void Q3_4_TowersOfHanoi(int n, Tower source, Tower aux, Tower dest) {

		if (n == 0) {
			return;
		}

		Q3_4_TowersOfHanoi(n - 1, source, dest, aux);

		moveDisk(source, dest);

		Q3_4_TowersOfHanoi(n - 1, aux, source, dest);
	}

	private static void moveDisk(Tower source, Tower dest) {

		Integer disk = source.removeTop();

		if (disk == null) {
			assert (false);
		}

		System.out.println(disk + ", " + source.name + " --> " + dest.name);

		dest.add(disk);
	}

	public static void test_Q3_6_sortStack() {

		Stack<Integer> stack = new Stack<>();

		stack.push(7);
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(1);
		stack.push(4);

		Q3_6_sortStack(stack);

		while (!stack.isEmpty()) {

			System.out.println(stack.pop());
		}
	}

	public static Stack<Integer> Q3_6_sortStack(Stack<Integer> stack) {

		Stack<Integer> aux = new Stack<Integer>();

		while (!stack.isEmpty()) {
			Integer value = stack.pop();

			while (!aux.isEmpty() && value < aux.peek()) {
				// if (value < aux.peek()) {
				stack.push(aux.pop());
				// }
				// else {
				// aux.push(value);
				// break;
				// }
			}

			// if (aux.isEmpty()) {
			aux.push(value);
			// }
		}

		while (!aux.isEmpty()) {
			stack.push(aux.pop());
		}

		return stack;

	}

}
