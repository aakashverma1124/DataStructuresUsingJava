/*
*
*   @author
*   Aakash Verma
* 	
*	Problem: Given a Binary Tree, find the count of Complete Nodes.
*
*	Complete Nodes: In a complete binary tree, every level, except possibly the last, is completely filled, 
*	and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes 
*	inclusive at the last level h.
*	
*		Input: 
*		    1
*		   / \
*		  2   3
*		 / \  /
*		4  5 6
*
*		Output: 6 
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
class BT7_CountCompleteTreeNodes {

	/* Creating a root node for the Tree. */
	static Node root;

	/* Assigning root as null initially. */
	BT7_CountCompleteTreeNodes() {
		root = null;
	}

	/* 
		So basically, In this question, if root is null, then obviously answer will be 0.
		otherwise, we check, if left is null for any root, then I'll directly return 1, 
		Here 1 is retured because of this node only and not for its left and right.
		Because if a node doesn't have left can't be counted as a complete node.
		Otherwise, we are recursively calling function for its left & right adding 1 because 
		of current node.
	*/
	public int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null) {
                return 1;
        }
        return (1 + countNodes(root.left) + countNodes(root.right));
        
    }

	/* main method */
	public static void main(String[] args) {
		BT7_CountCompleteTreeNodes tree = new BT7_CountCompleteTreeNodes();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        int count = tree.countNodes(root);
        System.out.println(count);
	}
}
