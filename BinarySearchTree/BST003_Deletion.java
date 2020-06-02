/*
*
* Binary Search Tree is a node-based binary tree data structure which has the following properties:
*
* The left subtree of a node contains only nodes with keys lesser than the node’s key.
* The right subtree of a node contains only nodes with keys greater than the node’s key.
* The left and right subtree each must also be a binary search tree.
*
* Problem: Insert a new key at correct position, tree should not get affected.
* Note: We are assuming that keys are unique.
*
* @author
*
* Aakash Verma
*																				
*
* Given BST:
* 		 							10
*								  /    \	
*								 5		20
*							    / \	   /  \
* 							   2   7  15   25
*									   \
*										17	
*
* BST before insertion: 2 5 7 10 15 20 25 
* BST after insertion: 2 5 7 10 15 17 20 25 
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
class BST002_Insertion {

	/* Creating a root node for the Tree. */
	static Node root;


	/* Assigning root as null initially. */
	BST002_Insertion() {

		root = null;
	}

	/* Utility function to insert into a BST */
	public Node insert(Node root, int key) {
		if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        if (key < root.data) 
            root.left = insert(root.left, key); 
        else if (key > root.data) 
            root.right = insert(root.right, key); 
        return root; 
	}

	/* Utility function to traverse in BST */
	public void printInorder(Node rootNode) {
		if(rootNode == null) {
			return;
		}
		printInorder(rootNode.left);
		System.out.print(rootNode.data + " ");
		printInorder(rootNode.right);
	}

	/* main method */
	public static void main(String[] args) {
		BST002_Insertion tree = new BST002_Insertion();
		root = tree.insert(root, 10);
		root = tree.insert(root, 5);
		root = tree.insert(root, 20);
		root = tree.insert(root, 2);
		root = tree.insert(root, 7);
		root = tree.insert(root, 15);
		root = tree.insert(root, 25);
		root = tree.insert(root, 17);
		System.out.print("BST before deletion: ");
		tree.printInorder(root);
		tree.deletion();
		System.out.print("\nBST after insertion: ");
		tree.printInorder(root);
		System.out.println();


	}

}



