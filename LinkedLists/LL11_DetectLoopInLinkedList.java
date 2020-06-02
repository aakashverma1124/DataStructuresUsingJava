/*
*
*   @author
*   Aakash Verma
*	
* 	Detect a loop in a linked list.
*
*	Approach:
*	Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
*	If the fast pointer meets slow pointer then there is a loop otherwise not.
*
*	Output: Found Loop
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
class LL11_DetectLoopInLinkedList {
	static Node head;

	LL11_DetectLoopInLinkedList() {
		head = null;
	}

	public String detectLoop() {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = head;

		while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				return "Found Loop";	
			}
		}

		return "Loop does not exists.";

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
		LL11_DetectLoopInLinkedList list = new LL11_DetectLoopInLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.head.next.next.next.next = list.head.next;
		System.out.println(list.detectLoop());
		
	}
}
