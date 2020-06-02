/*
*
*   @author
*   Aakash Verma
*	
* 	Searching an element in the Linked List Recursively.
*
*	Output: 
*
*	Nodes in the Linked List.1 2 3 4 5 
*	5 element is found.
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

/* Creating a class for implementing the code for searching an element in a Linked List Recursively. */
class LL008_SearchElementInLinkedList {
	static Node head;

	LL008_SearchElementInLinkedList() {
		head = null;
	}

	/* Method for searching an element in the list recursively. */
	boolean searchElement(Node current, int keyToBeSearched) {
		if(current == null) {
			return false;
		}
		if(current.data == keyToBeSearched) {
			return true;
		}
		return searchElement(current.next, keyToBeSearched);
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
		LL008_SearchElementInLinkedList list = new LL008_SearchElementInLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		Node h = head;
		System.out.print("Nodes in the Linked List.");
		list.printList();
		int keyToBeSearched = 5;
		boolean isFound = list.searchElement(h, keyToBeSearched);
		if(isFound) {
			System.out.println("\n" + keyToBeSearched +  " element is found.");
		} else {
			System.out.println("\n" + keyToBeSearched +  " element is not found.");
		}
	}
}
