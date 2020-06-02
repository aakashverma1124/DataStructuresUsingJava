/*
*
*   @author
*   Aakash Verma
*	
* 	Deleting a Linked List in java is easy just set point to null.
*
*	Output: 
*
*	List is: 1 2 3 	
*	The list is deleted.
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
class LL004_DeleteLinkedList {

	/* Declaring a head node. */
	static Node head;


	/* Defining a constructor which sets head node as null initially. */
	LL004_DeleteLinkedList() {
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

	void deleteList() {
		head = null;
		System.out.println("The list is deleted!");
	}

	/* Main method. */
	public static void main(String args[]) {

		LL004_DeleteLinkedList list = new LL004_DeleteLinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		System.out.print("List is: ");
		list.printList();
		System.out.println();
		list.deleteList();
		System.out.println();
	}
}
