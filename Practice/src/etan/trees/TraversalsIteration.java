// $Id$
package etan.trees;

import java.util.Stack;

/**
 * <br>
 * <br>
 * Copyright (c) 2013 MICROS Corporation
 * 
 * @author etan
 * @created Aug 19, 2013
 * @version $Revision$
 */
public class TraversalsIteration {

  public static void inOrder(Node node) {
    if (node == null) return;
    Stack<Node> nodeStack = new Stack<>();

    while (node != null) {
      nodeStack.push(node);
      node = node.left;
    }

    while (!nodeStack.isEmpty()) {
      node = nodeStack.pop();
      System.out.print(node.data + " ");
      node = node.right;

      while (node != null) {
        nodeStack.push(node);
        node = node.left;
      }
    }
  }

  public static void inOrder2(Node argRoot) {
    Stack<Node> stack = new Stack<>();
    while (!stack.isEmpty() || argRoot != null) {
      if (argRoot != null) {
        stack.push(argRoot);
        argRoot = argRoot.left;
      }
      else {
        argRoot = stack.pop();
        System.out.print(argRoot.data + " ");
        argRoot = argRoot.right;
      }
    }
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

    System.out.println("PreOder: ");
    preOrder(Five);
    System.out.println("\n\nInOder: ");
    inOrder(Five);
    System.out.println("\n\nInOder2: ");
    inOrder2(Five);
    System.out.println("\n\nPostOrder: ");
    postOrder(Five);
  }

  public static void postOrder(Node node) {
    Stack<Node> nodeStack = new Stack<>();
    if (node == null) return;
    nodeStack.push(node);
    Node prevNode = null;
    while (!nodeStack.isEmpty()) {
      Node currNode = nodeStack.peek();
      if (prevNode == null || prevNode.left == currNode || prevNode.right == currNode) {
        if (currNode.left != null) {
          nodeStack.push(currNode.left);
        }
        else if (currNode.right != null) {
          nodeStack.push(currNode.right);
        }
      }
      else if (currNode.left == prevNode) {
        if (currNode.right != null) {
          nodeStack.push(currNode.right);
        }

      }
      else {
        System.out.print(currNode.data + "  ");
        nodeStack.pop();

      }
      prevNode = currNode;
    }
  }

  public static void preOrder(Node node) {
    if (node == null) return;
    Stack<Node> nodeStack = new Stack<>();

    while (node != null) {
      System.out.print(node.data + " ");
      if (node.right != null) {
        nodeStack.push(node.right);
      }
      node = node.left;
      if (node == null && !nodeStack.isEmpty()) {
        node = nodeStack.pop();
      }
    }
  }
}
