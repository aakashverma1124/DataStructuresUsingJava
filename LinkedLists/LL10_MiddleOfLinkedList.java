/*
*
*   @author
*   Aakash Verma
*	
* 	Find the middle of a given linked list.
*
*	Method 1:
*	Traverse the whole linked list and count the no. of nodes. 
*	Now traverse the list again till count/2 and return the node at count/2.
*
*	Method 2:
*	Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
*	When the fast pointer reaches end slow pointer will reach middle of the linked list.
*
*	Output 1: 
*	Nodes in the Linked List: 1 2 3 4 5 
*	Middle of Node is: 3
*	
*	Output 2:
* 	Nodes in the Linked List: 1 2 3 4 5 6 
*	Middle of Node is: 4
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

/* Creating a class for implementing the code for getting Nth node in a Linked List. */
class LL10_MiddleOfLinkedList {
	static Node head;

	LL10_MiddleOfLinkedList() {
		head = null;
	}

	public Node middleOfLinkedList() {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = head;

		if(slowPointer == null || slowPointer.next == null) {
			return slowPointer;
		}

		while(fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		return slowPointer;

	}

	/* Iterating over the list. */
	void printList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

	}


	/* Utility code for inserting nodes into the linked list. */
	void push(int key) {
		Node current = head;
		if(current == null) {
			Node temp = new Node(key);
			head = temp;
		}
		else {
			while(current.next != null) {
				current = current.next;
			}
			Node temp = new Node(key);
			current.next = temp;
		}

	}


	/* Main method */
	public static void main(String[] args) {
		LL10_MiddleOfLinkedList list = new LL10_MiddleOfLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		System.out.print("Nodes in the Linked List: ");
		list.printList();
		Node answerNode = list.middleOfLinkedList();
		System.out.println("\nMiddle of Node is: " + answerNode.data);
		
	}
}
