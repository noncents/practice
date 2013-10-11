// $Id$
package plt.trees;

/**
 * <br>
 * <br>
 * Copyright (c) 2013 MICROS Corporation
 * 
 * @author etan
 * @created Oct 5, 2013
 * @version $Revision$
 */
public class Nary {

  public static void main(String[] args) {

    testTraverseNaryTree();
  }

  public static void testTraverseNaryTree() {

    Node root = createNaryTree();

    System.out.println("\nNary Preorder");
    traverseNaryTree_Preorder(root);
    System.out.println("\nNary Postorder");
    traverseNaryTree_Postorder(root);

  }

  public static void traverseNaryTree_Postorder(Node root) {
    if (root == null) return;

    if (root.children != null) {
      for (int i = 0; i < root.children.length; i++ ) {
        traverseNaryTree_Postorder(root.children[i]);
      }
    }
    System.out.print(root.value + " ");
  }

  public static void traverseNaryTree_Preorder(Node root) {

    if (root == null) return;

    System.out.print(root.value + " ");

    if (root.children != null) {
      for (int i = 0; i < root.children.length; i++ ) {
        traverseNaryTree_Preorder(root.children[i]);
      }
    }
  }

  private static Node createNaryTree() {

    Node root = new Node(5);
    root.setChildArgs(6, 10);

    root.children[0].setChildArgs(7, 1, 2, 8);
    root.children[1].setChildArgs(11, 12);

    root.children[0].children[0].setChildArgs(3);
    root.children[0].children[1].setChildArgs(4, 13);

    root.children[1].children[0].setChildArgs(15);
    root.children[1].children[1].setChildArgs(16, 17, 18);

    return root;

  }

  private static class Node {

    public int value = 0;
    public Node[] children;

    public Node(int value) {
      this.value = value;

    }

    public void setChildArgs(int... argChildValues) {
      children = new Node[argChildValues.length];

      for (int i = 0; i < argChildValues.length; i++ ) {
        children[i] = new Node(argChildValues[i]);
      }

    }
  }

}
