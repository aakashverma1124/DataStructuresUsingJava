/*
*
* Binary Search Tree is a node-based binary tree data structure which has the following properties:
*
* The left subtree of a node contains only nodes with keys lesser than the node’s key.
* The right subtree of a node contains only nodes with keys greater than the node’s key.
* The left and right subtree each must also be a binary search tree.
*
* Problem: Given a Binary Search Tree, chech whether a given key exists or not.
*
* @author
*
* Aakash Verma
*				
* Given BST:						10
*								  /    \	
*								 5		20
*							    / \	   /  \
* 							   2   7  15   25
*
* Input: 25
* Output: True
*
* Input: 36
* Output: False
*
*
*/


/* Creating a structure for the node.
   Initializing the nodes data upon calling its constructor. */

class Node {
	int data;
	Node left;
	Node right;

	public Node(int key) {
		data = key;
		left = null;
		right = null;
	}
}

/* Defining class for the Binary Search Tree */
class BST1_Search {

	/* Creating a root node for the Tree. */
	static Node root;


	/* Assigning root as null initially. */
	BST1_Search() {

		root = null;
	}

	/* Utility Function for searching into a BST */
	public Node searchKey(Node currentNode, int key) {
		if(currentNode == null || currentNode.data == key) {
			return currentNode;
		}
		else if (currentNode.data < key) {
			return searchKey(currentNode.right, key);
		}
		else {
			return searchKey(currentNode.left, key);
		}
	}

	/* main method */
	public static void main(String[] args) {
		BST1_Search tree = new BST1_Search();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(20);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(25);
		int key = 25;
		Node resultNode = tree.searchKey(root, key);
		if(resultNode != null) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}

		
	}

}



