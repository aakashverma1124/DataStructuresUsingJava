/*
*
*   @author
*   Aakash Verma
*	
* 	Getting Nth node in a Linked List.
*
*	Output: 
*
*	Nodes in the Linked List: 1 2 3 4 5 
*	Test Case 1:
*	4th Node in Linked List: 4
*	Test Case 2:
*	The index 8 doesn't exist or list is null.
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

/* Creating a class for implementing the code for getting Nth node in a Linked List. */
class LL9_NthNodeOfLinkedList {
	static Node head;

	LL9_NthNodeOfLinkedList() {
		head = null;
	}

	/* Method for getting nth node present in the list. */
	Node getNthNode(int index) {
		int count = 0;
		Node current = head;
		if(current == null) {
			return null;
		}
		else {
			while(current != null) {
				if(++count == index) {
					return current;
				} else { 
					current = current.next;
				}
			}
		}
		return null;
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

	/* Iterating over the list. */
	void printList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

	}

	/* Main method */
	public static void main(String[] args) {
		LL9_NthNodeOfLinkedList list = new LL9_NthNodeOfLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		System.out.print("Nodes in the Linked List: ");
		list.printList();
		int index = 4;
		Node nthNode = list.getNthNode(index);
		if(nthNode != null) {
			System.out.println("\n" + index + "th Node in Linked List: " + nthNode.data);
		} else {
			System.out.println("\nThe index " + index + " doesn't exist or list is null.");
		}

		int index2 = 8;
		Node nthNode2 = list.getNthNode(index2);
		if(nthNode2 != null) {
			System.out.println("\n" + index2 + "th Node in Linked List: " + nthNode2.data);
		} else {
			System.out.println("\nThe index " + index2 + " doesn't exist or list is null.");
		}
	}
}