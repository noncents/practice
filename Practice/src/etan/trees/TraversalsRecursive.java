package etan.trees;

public class TraversalsRecursive {

  public static void InOrder(Node node) {
    if (node == null) return;
    InOrder(node.left);
    System.out.print(node.data + " ");
    InOrder(node.right);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
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

    System.out.println("PreOrder is as follows:");
    PreOrder(Five);
    System.out.println("\n\nInOder is as follows:");
    InOrder(Five);
    System.out.println("\n\nPostOrder is as follows:");
    PostOrder(Five);
  }

  public static void PostOrder(Node node) {
    if (node == null) return;
    PostOrder(node.left);
    PostOrder(node.right);
    System.out.print(node.data + " ");
  }

  public static void PreOrder(Node node) {
    if (node == null) return;
    System.out.print(node.data + " ");
    PreOrder(node.left);
    PreOrder(node.right);
  }
}
