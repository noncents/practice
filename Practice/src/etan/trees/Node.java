package etan.trees;

public class Node {
	Node left;
	Node right;
	int data;
	
	public Node() {	}
	
	public Node(Node left, Node right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
}
