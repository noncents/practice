package etan.lists.singlyLinkedList;

public class SLinkedListLoop {
	 
    Node header = null;
		Node current = null;
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			SLinkedListLoop sll = new SLinkedListLoop();
			
			sll.insertSort(2);
			sll.insertSort(4);
			sll.insertSort(6);
			sll.insertSort(8);
			sll.insertSort(10);
			sll.insertSort(1);
			sll.insertSort(3);
			sll.insertSort(5);
			sll.insertSort(7);
			sll.insertSort(9);
			
			sll.printList();
			
			// make the tail point somewhere
			sll.getTailNode().next = sll.getAt(5);
			
			System.out.println("*********************************");
			//System.out.println("hasLoop = " + sll.hasLoop());
			
			System.out.println("hasLoop2 = " + sll.hasLoop2());
			
		}
		
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
				} else {
					newNode.next = currNode;
					header = newNode;
				}
			}
		}
		
		public void printList() {
			Node currNode = header;
			
			while(currNode.next != null) {
				System.out.println(currNode.data);
				currNode = currNode.next;
			}
			System.out.println(currNode.data);
		}
		
		public Node getTailNode() {
			Node currNode = header;
			
			while((currNode.next) != null) {
				currNode = currNode.next;
			}
			
			return currNode;
		}
		
		
		public Node getAt(int index) {
			
			Node currNode = header;
			
			for(int i=0; currNode.next != null; i++, currNode = currNode.next) {
				
				if (i == index) {
					return currNode;
				}
			}
			
			return null;
			
		}
		
		public boolean hasLoop() {
			
			if (header == null)
				return false;
			
			Node slowNode = header;
			
			if (slowNode.next == null)
				return false;
			
			Node fastNode = header.next;
			
			if (fastNode.next == null)
				return false;			
			
			Node fasterNode = fastNode.next;
			
			int i = 0;
			
			while(slowNode != fasterNode) {
				
				System.out.println("Slownode = " + slowNode.data + ", " + "Fastnode = " + fasterNode.data);
				
				slowNode = slowNode.next;
				
				
				if (fasterNode.next == null) {
					return false;
				}
				fastNode = fasterNode.next;
				
				if (fastNode.next == null) {
					return false;
				}
				
				fasterNode = fastNode.next;
				
				if (i++ == 1000) {
					return false;
				}
			}
			
			System.out.println("has loop. found in this many tries "+ i );
			return true;
 
			
		}
		
		public boolean hasLoop2() {
			
			boolean hasLoop = false;
			
			Node slowNode = header;
			Node fastNode = header;
			
			Node startNode = null;
			Node currNode = header;
			
//			int i = 0;
			
//			while(slowNode != null && (fastNode = fasterNode.next) != null && (fasterNode = fastNode.next) != null) {
//				
//				System.out.println(slowNode.data + " "  + fastNode.data + " " + fasterNode.data);
//				if (slowNode == fasterNode || slowNode == fastNode) {
//					startNode = slowNode;
//					hasLoop = true;
//					break;
//				}
//				
//				
//				slowNode = slowNode.next;
//				
//			}
			
			while (true) {
				if ((slowNode.next != null) && (fastNode.next != null) && (fastNode.next.next != null)) {
					fastNode = fastNode.next.next;
					slowNode = slowNode.next;
					if (fastNode == slowNode) {
						startNode = slowNode;
						hasLoop = true;
						break;
					}
				} else {
					break;
				}
				
			}
			
			if (hasLoop) {
				while (currNode != startNode) {
					currNode = currNode.next;
					startNode = startNode.next;
				}
				System.out.println(currNode.data + " is the intersecting point.");
			}
			
			return hasLoop;
		}
}