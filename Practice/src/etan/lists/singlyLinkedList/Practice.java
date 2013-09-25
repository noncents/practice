// $Id$
package etan.lists.singlyLinkedList;

/**
 * <br>
 * <br>
 * Copyright (c) 2013 MICROS Corporation
 * 
 * @author etan
 * @created Sep 22, 2013
 * @version $Revision$
 */
public class Practice {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Practice list = new Practice();
    Node rvsStart = null;

    list.insert(5);
    list.insert(4);
    list.insert(3);
    list.insert(2);
    list.insert(1);

    // list.deleteMidElement();

    list.printList(rvsStart);

    System.out.println("");

    rvsStart = list.reverseLinkedList();

    list.printList(rvsStart);

  }

  Node header = null;
  Node tail = null;

  // Delete middle of Singly-linked list
  @SuppressWarnings("javadoc")
  public void deleteMidElement() {
    Node slowNode = header;
    Node fastNode = header;
    Node temp = slowNode;

    if (temp == null) {
      return;
    }

    if (temp.next == null) {
      header = null;
      return;
    }

    while (slowNode.next != null && fastNode != null && fastNode.next != null) {
      temp = slowNode;
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }

    // At this point, temp is the middle. Delete the temp.
    temp.next = slowNode.next;
  }

  public void insert(int argData) {

    Node newNode = new Node(argData);

    if (header == null) {
      header = newNode;
    }
    else {
      Node currNode = header;
      header = newNode;
      newNode.next = currNode;
    }

  }

  public void printList(Node argNode) {
    Node currNode = header;

    if (argNode != null) {
      currNode = argNode;
    }

    while (currNode != null) {
      System.out.print(currNode.data + " ");
      currNode = currNode.next;
    }

  }

  // Reverse the order of linked list
  @SuppressWarnings("javadoc")
  public Node reverseLinkedList() {
    Node temp;
    Node reverseStart = null;
    Node currNode = header;

    while (currNode != null) {
      temp = currNode.next;
      currNode.next = reverseStart;
      reverseStart = currNode;
      currNode = temp;
    }

    return reverseStart;
  }
}
