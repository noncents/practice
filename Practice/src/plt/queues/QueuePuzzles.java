package plt.queues;

import java.util.Stack;

public class QueuePuzzles {

	public static void main(String[] args) {

		queueWith2Stacks();
	}

	public static void queueWith2Stacks() {

		Q2Stacks myQ = new Q2Stacks();

		myQ.enqueue(1);
		myQ.enqueue(2);
		myQ.enqueue(3);

		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());

		myQ.enqueue(1);
		myQ.enqueue(2);

		System.out.println(myQ.dequeue());	// 1

		myQ.enqueue(3);
		System.out.println(myQ.dequeue());	// 2
		System.out.println(myQ.dequeue());	// 3
	}

	private static class Q2Stacks {

		Stack<Integer> _stack1 = new Stack<Integer>();
		Stack<Integer> _stack2 = new Stack<Integer>();

		public void Q2Stacks() {

		}

		public void enqueue(Integer i) {

			_stack1.push(i);
		}

		public Integer dequeue() {

			if (_stack2.isEmpty()) {
				while (!_stack1.isEmpty()) {
					_stack2.push(_stack1.pop());
				}
			}

			if (_stack2.isEmpty()) {
				return null;
			}

			return _stack2.pop();

		}

	}
}
