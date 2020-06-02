/*
*
*   @author
*   Aakash Verma
*	
* 	Count of Number Of Nodes.
*
*	Output: 
*
*	1 2 3 4 5 
*	Count Of Nodes: 5 
* 	
*
*
*
*/

/* Below is the structute of a node which is used to create a new node every time. */
class Node {
	int data;
	Node next;

	public Node(int key) {
		data = key;
		next = null;
	}
}

/* Creating a class for implementing the code for Count of Nodes in a Linked List. */
class LL005_LengthOfLinkedList {
	static Node head;

	LL005_LengthOfLinkedList() {
		head = null;
	}

	/* Method for counting for number of nodes present in the list. */
	int countNumberOfNodes() {
		int countOfNodes = 0;
		Node current = head;
		while(current != null) {
			countOfNodes++;
			System.out.print(current.data + " ");
			current = current.next;
		}
		return countOfNodes;
	}

	/* Utility code for inserting nodes into the linked list. */
	void push(int key) {
		Node current = head;
		if(current == null) {
			Node temp = new Node(key);
			temp.next = null;
			head = temp;
		} else {
			while(current.next != null) {
				current = current.next;
			}
			Node temp = new Node(key);
			temp.next = null;
			current.next = temp;
		}
	}

	/* Main method */
	public static void main(String[] args) {
		LL005_LengthOfLinkedList list = new LL005_LengthOfLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		int count = list.countNumberOfNodes();
		System.out.println("\nCount Of Nodes: " + count);
	}
}
