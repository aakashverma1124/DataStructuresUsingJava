/*
*
*   @author
*   Aakash Verma
*	
* 	Simple Creation and Traversal of a Linked List.
*
*	Output: 
*
*	List is: 1 2 3 	
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

/* Creating a class for implementing the code for Linked List. */
class LL001_LinkedList {

	/* Declaring a head node. */
	static Node head;


	/* Defining a constructor which sets head node as null initially. */
	LL001_LinkedList() {
		head = null;
	}

	/* Iterating over the list. */
	void printList() {
		Node h = head;
		while(h != null) {
			System.out.print(h.data + " ");
			h = h.next;
		}

	}

	/* Main method. */
	public static void main(String args[]) {

		LL001_LinkedList list = new LL001_LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		System.out.print("List is: ");
		list.printList();
		System.out.println();
	}
}
