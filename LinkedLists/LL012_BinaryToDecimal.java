/*
*
*   @author
*   Aakash Verma
*	
* 	Given a Linked List which represents a Binary of a Number.
*	Task: Convert a linked list to a decimal number.
*
*	Example:
*	
*	Input: 1 -> 0 -> 1
*
*	Output: 5 
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

class LL012_BinaryToDecimal {
	/* Declaring a head node. */
	static Node head;

	/* Defining a constructor which sets head node as null initially. */
	LL012_BinaryToDecimal() {
		head = null;
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

	public int convertBinaryToDecimal(Node head) {
		/* create an empty string to store binary representation */
		StringBuilder s = new StringBuilder("");
		while(head != null) {
			/* head.data is an integer, so convert it into a string and append it to the s */
			s.append(Integer.toString(head.data));
			head = head.next;
		}
		int decimal = Integer.parseInt(s.toString(), 2);
		return decimal;
	}

	/* Main method */
	public static void main(String[] args) {
		LL012_BinaryToDecimal list = new LL012_BinaryToDecimal();
		list.push(1);
		list.push(0);
		list.push(1);
		int decimal = list.convertBinaryToDecimal(head);
		System.out.println(decimal);
	}
}