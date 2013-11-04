package plt.trees;

public class TreeNode {

	public TreeNode right;
	public TreeNode left;
	public int value;

	public TreeNode() {

	}

	public String toString() {

		return String.valueOf(value);
	}

	public TreeNode(int value, TreeNode left, TreeNode right) {

		this.value = value;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int value) {

		this.value = value;
	}
}
