package etan.arrays;

import java.util.Arrays;

public class Stack {
	int[] arr = new int[5];
	private int top = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack stk = new Stack();
		stk.push(1);
		stk.push(6);
		//System.out.println(stk.pop());
		stk.push(7);
		stk.push(4);
		stk.printList();

	}
	
	public void push(int data) {

		top ++;
		
		if (top >= arr.length) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		arr[top] = data;
	}
	
	public int pop() {
		return arr[top--];
	}
	
	public void printList() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
