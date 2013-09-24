package etan.lists.singlyLinkedList;

public class Stack {
	Node header = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stk = new Stack();
		
		stk.pop();
		stk.push(1);
		//stk.pop();
		stk.push(5);
		//stk.pop();
		stk.push(6);
		System.out.println("Popping:" + stk.pop());
		stk.push(3);
		
		stk.printList();

	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		
		if (header == null) {
			header = newNode;
		}
		else {
			newNode.next = header;
			header = newNode;
		}
	}
	
	public int pop() {
		Node currNode = header;
		
		if (header == null) {
			return 0;
		}
//		else {
//			header = currNode.next;
//		}
		header = header.next;
		return currNode.data;
	}
	
	public void printList() {
		Node currNode = header;
		
		while(currNode.next != null) {
			System.out.println(currNode.data);
			currNode = currNode.next;
		}
		System.out.println(currNode.data);
	}

}
