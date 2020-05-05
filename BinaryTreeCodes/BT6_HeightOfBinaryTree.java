/*
*
*   @author
*   Aakash Verma
* 	
*	Problem: Given a Binary Tree, find the height of the Binary Tree.
*	
* 	Output: 
*	Traversal is: 1 2 4 5 3 6 7 
*	Number Of Leaf Nodes: 4
*
*/


/* Creating a structure for the node.
   Initializing the nodes datas upon calling its constructor. */

class Node {
	int data;
	Node left, right;

	public Node (int key) {
		data = key;
		right = left = null;
	}
}

/* Defining class for the Binary Tree */
class BT6_HeightOfBinaryTree {

	/* Creating a root node for the Tree. */
	static Node root;

	/* Assigning root as null initially. */
	BT6_HeightOfBinaryTree() {
		root = null;
	}

	/* utility function to get max of two values. */
	int max (int a, int b) {
		return (a > b) ? a : b;
	}

	/* finding height of binary tree. */
	int heightOfBT(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) { /* leaf Node */
			return 0;
		} 
		return 1 + max (heightOfBT(root.left), heightOfBT(root.right));
	}

	/* Pre Order Traversal */
	void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	/* main method */
	public static void main(String[] args) {
		BT6_HeightOfBinaryTree tree = new BT6_HeightOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.print("Traversal is: ");
        tree.preOrder(root);
        System.out.println();
        System.out.print("Height Of Binary Tree: " + tree.heightOfBT(root));
        System.out.println();
	}
}
