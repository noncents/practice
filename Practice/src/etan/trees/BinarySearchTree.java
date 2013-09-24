package etan.trees;

public class BinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node One = new Node();
		One.data = 1;
		Node Four = new Node();
		Four.data = 4;
		Node Seven = new Node();
		Seven.data = 7;
		Node Twelve = new Node();
		Twelve.data = 12;
		Node Three = new Node(One, Four, 3);
		Node Ten = new Node(Seven, Twelve, 10);
		Node Five = new Node(Three, Ten, 5);
		
		
		Node node = FindNode(Five, 3);
		
		if (node != null) {
			System.out.println(node.data);	
		}
		else {
			System.out.println("Not Found");
		}
		
	}
	
	public static Node FindNode(Node node, int Value) {
		while (node != null) {
			int currVal = node.data;
			if (currVal == Value) {
				break;
			}
			if (currVal < Value) {
				node = node.right;
			}
			else {
				node = node.left;
			}
		}
		return node;
	}

}

