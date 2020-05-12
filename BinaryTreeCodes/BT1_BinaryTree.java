/*
*
*   @author
*   Aakash Verma
*
*
*/


// Creating a structure for the node.
// Initializing the nodes datas upon calling its constructor.

class Node {
    int data;
    Node left, right;
    
    public Node(int key) {
        data = key;
        left = right = null;
    }
}


// Defining class for the Binary Tree
class BT1_BinaryTree {

    // Creating a root node for the Tree.
    static Node root;
    

    // Assigning root as null initially.
    BT1_BinaryTree() {
        root = null;
    }
    
    // Pre Order Traversal
    void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    // In Order Traversal
    void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Post Order Traversal
    void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    // main method
    public static void main (String[] args) {
        BT1_BinaryTree tree = new BT1_BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.print("Pre Order Traversal is: ");
        tree.preOrder(root);
        System.out.println();
        System.out.print("In Order Traversal is: ");
        tree.inOrder(root);
        System.out.println();
        System.out.print("Post Order Traversal is: ");
        tree.postOrder(root);
        System.out.println();
    }
}
