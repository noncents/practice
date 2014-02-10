package etan.trees;

public class BinarySearchTree {

  public static Node FindNode(Node node, int value) {
    Node currNode = node;
    while (currNode != null) {
      int currVal = currNode.data;
      if (currVal == value) {
        return currNode;
      }
      if (currVal < value) {
        currNode = currNode.right;
      }
      else {
        currNode = currNode.left;
      }
    }
    return null;
  }

  public static Node FindNodeRecrusive(Node node, int value) {
    Node temp = null;
    if (node != null) {
      if (node.data == value) {
        return node;
      }
      if (node.data > value) {
        temp = FindNodeRecrusive(node.left, value);
      }
      else {
        temp = FindNodeRecrusive(node.right, value);
      }
    }
    return temp;
  }

  public static boolean isBST(Node node) {
    boolean temp = true;

    if (node == null) {
      return true;
    }
    if (node.left != null && node.data < node.left.data) {
      return false;
    }
    if (node.right != null && node.data > node.right.data) {
      return false;
    }
    temp = isBST(node.left) && isBST(node.right);

    return temp;
  }

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

    Node node = FindNodeRecrusive(Five, 3);

    if (node != null) {
      System.out.println(node.data);
    }
    else {
      System.out.println("Not Found");
    }

    System.out.println(isBST(Five));
  }

}
