package plt.lists;


public class SLList {

	public static void main(String[] args) {

		Node sll = convertArrToList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		traverseList(sll);

		traverseList(reverseList(convertArrToList(new int[] { 1 })));
		traverseList(reverseList(convertArrToList(new int[] { 1, 2 })));
		traverseList(reverseList(convertArrToList(new int[] { 1, 2, 3, 4, 5 })));
		traverseList(reverseList(convertArrToList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })));

		traverseList(removeMidElement(convertArrToList(new int[] { 1 })));
		traverseList(removeMidElement(convertArrToList(new int[] { 1, 2 })));
		traverseList(removeMidElement(convertArrToList(new int[] { 1, 2, 3 })));
		traverseList(removeMidElement(convertArrToList(new int[] { 1, 2, 3, 4 })));
		traverseList(removeMidElement(convertArrToList(new int[] { 1, 2, 3, 4, 5 })));
		traverseList(removeMidElement(convertArrToList(new int[] { 1, 2, 3, 4, 5, 6 })));
		traverseList(removeMidElement(convertArrToList(new int[] { 1, 2, 3, 4, 5, 6, 7 })));

	}

	public static Node reverseList(Node node) {

		// Node head = null;

		if (node != null) {
			// head = node;
			Node prev = node;
			Node temp = node.next;
			prev.next = null;

			while (temp != null) {

				node = temp;

				if (node.next == null) {
					node.next = prev;
					temp = null;
				}
				else {
					temp = node.next;	// save next
					node.next = prev;
					prev = node;
					node = temp;
				}
			}

		}

		return node;
	}

	public static Node removeMidElement(Node node) {

		if (node == null) {
			return null;
		}

		Node head = node;
		Node prevNode = null;
		Node fastNode = node;

		while (fastNode.next != null && fastNode.next.next != null) {

			prevNode = node;
			node = node.next;

			// if (fastNode.next != null && fastNode.next.next != null) {
			fastNode = fastNode.next.next;
			// }
		}

		if (prevNode != null) {
			prevNode.next = node.next;
		}

		return head;

	}

	public static Node convertArrToList(int arr[]) {

		Node node = null;
		Node prevNode = null;

		Node firstNode = null;

		boolean isFirst = true;

		for (int i = 0; i < arr.length; i++) {

			node = new Node(arr[i]);

			if (prevNode != null) {
				prevNode.next = node;
			}

			if (isFirst) {
				firstNode = node;
				isFirst = false;
			}

			prevNode = node;
		}

		return firstNode;

	}

	public static void traverseList(Node node) {

		if (node == null) {
			System.out.print("\nContents of SLL are: NULL !!!");
		}

		Node head = node;

		System.out.print("\nContents of SLL are: ");

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

}
