/*
*
*   @author
*   Aakash Verma
*	
* 	Simple Creation, Insertion, and Traversal of a Doubly Linked List.
*
*	Output: 
*
*	List is: 1 2 3 4 
* 	Backward List is: 4 3 2 1
*
*
*
*/


/* Below is the structute of a node which is used to create a new node every time. */
class Node {
	int data;
	Node prev;
	Node next;


	public Node(int key) {
		data = key;
	}
}

/* Creating a class for implementing the code for Doubly Linked List. */
class DLL01_Insertion {

	/* Declaring a head node. */
	static Node head;


	/* Defining a constructor which sets head node as null initially. */
	DLL01_Insertion() {
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

	/* Iterating backward over the list */
	void printListBackward() {
		Node h = head;
		while(h.next != null) {
			h = h.next;
		}
		Node last = h;

		while(last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}

	}

	/* Inserting at the beginning of a doubly linked list */
	public void insertAtBeginning(int data) { 

		Node h = head;

		if(h == null) {
			Node temp = new Node(data); 
			temp.next = null;
			temp.prev = null;
			head = temp;	
		}
		else {
			Node temp = new Node(data); 
			temp.next = h;
			temp.prev = null;
			h.prev = temp;
			head = temp;
		}
    } 

	/* Main method. */
	public static void main(String args[]) {

		DLL01_Insertion list = new DLL01_Insertion();
		list.insertAtBeginning(4);
		list.insertAtBeginning(3);
		list.insertAtBeginning(2);
		list.insertAtBeginning(1);
		System.out.print("List is: ");
		list.printList();
		System.out.println();
		System.out.print("Backward List is: ");
		list.printListBackward();
		System.out.println();
	}
}
