package plt.trees;

public class Node {

	public Node right;
	public Node left;
	public int value;

	public Node() {

	}

	public String toString() {

		return String.valueOf(value);
	}

	public Node(int value, Node left, Node right) {

		this.value = value;
		this.left = left;
		this.right = right;
	}

	public Node(int value) {

		this.value = value;
	}
}
