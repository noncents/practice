// $Id$
package etan.trees;

/**
 * <br>
 * <br>
 * Copyright (c) 2013 MICROS Corporation
 * 
 * @author etan
 * @created Aug 13, 2013
 * @version $Revision$
 */
public class HeightCounter {
  public static int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    else {
      return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    Node Eight = new Node();
    Eight.data = 8;
    Node Eleven = new Node();
    Eleven.left = Eight;
    Eleven.data = 11;
    Node One = new Node();
    One.left = Eleven;
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

    int height = getHeight(Five);
    System.out.println("Height of tree is: " + height);
  }
}
