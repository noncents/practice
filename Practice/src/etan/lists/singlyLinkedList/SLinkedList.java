package etan.lists.singlyLinkedList;

public class SLinkedList {

  /**
   * @param args
   */
  public static void main(String[] args) {

    SLinkedList sll = new SLinkedList();

    sll.insertSort(10);
    sll.insertSort(2);
    sll.insertSort(3);
    sll.insertSort(8);
    sll.insertSort(4);
    sll.insertSort(7);
    sll.insertSort(1);
    sll.insertSort(9);
    sll.insertSort(11);

    sll.deleteData(115);

    sll.printList();

  }

  Node header = null;
  Node current = null;

  public void deleteData(int data) {
    if (header == null) {
      return;
    }
    else {
      Node currNode = header;
      if (currNode.data == data) {
        header = currNode.next;
        return;
      }

      while (currNode.next != null && currNode.next.data != data) {
        currNode = currNode.next;
      }

      if (currNode.next != null) {
        currNode.next = currNode.next.next;
      }
      return;
    }
  }

  public void insertSort(int data) {

    Node newNode = new Node(data);

    if (header == null) {
      header = newNode;
    }
    else {
      Node currNode = header;

      while (currNode.next != null && currNode.next.data <= data) {
        currNode = currNode.next;
      }

      if (currNode.data <= data) {
        newNode.next = currNode.next;
        currNode.next = newNode;
      }
      else {
        newNode.next = currNode;
        header = newNode;
      }
    }
  }

  public void printList() {
    Node currNode = header;

    while (currNode.next != null) {
      System.out.println(currNode.data);
      currNode = currNode.next;
    }
    System.out.println(currNode.data);
  }

  //
}
