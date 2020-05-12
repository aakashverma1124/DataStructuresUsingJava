/*
*
*   @author
*   Aakash Verma
*	
* 	Count of Number Of Nodes Recursively.
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
class LL6_LengthOfLinkedListRecursively {
	static Node head;

	LL6_LengthOfLinkedListRecursively() {
		head = null;
	}

	/* Method for counting for number of nodes present in the list recursively. */
	int countNodesRecursively(Node current) {
		if(current == null) {
			return 0;
		}
		else {
			System.out.print(current.data + " ");
			return 1 + countNodesRecursively(current.next);
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
		LL6_LengthOfLinkedListRecursively list = new LL6_LengthOfLinkedListRecursively();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		Node h = head;
		System.out.print("Nodes in the Linked List: ");
		int count = list.countNodesRecursively(h);
		System.out.println("\nCount Of Nodes: " + count);
	}
}