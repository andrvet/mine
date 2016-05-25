package binarytree.geeksforgeeks.levelordertreetraversal;

import java.util.LinkedList;
import java.util.Queue;

/* http://www.geeksforgeeks.org/level-order-tree-traversal/
 Level Order Tree Traversal AKA Breadth First Traversal (BFT)
 	1
   2    3
 4   5
 Level order traversal of the above tree is 1 2 3 4 5

 METHOD 1 (Use function to print a given level)

 Algorithm: Two functions: One is to print all nodes at a given level (printGivenLevel), 
 and other is to print level order traversal of the tree (printLevelorder). 
 printLevelorder makes use of printGivenLevel to print nodes at all levels one by one starting from root.

 //Function to print level order traversal of tree
 printLevelorder(tree) {
 for d = 1 to height(tree) {
 	printGivenLevel(tree, d);
 	}
}
 //Function to print all nodes at a given level
 printGivenLevel(tree, level) {
 if tree is NULL then return;
 if level is 1, then
 	print(tree->data);
 else if level greater than 1, then
 	printGivenLevel(tree->left, level-1);
 	printGivenLevel(tree->right, level-1);
}

METHOD 2 - using Queue
Algorithm: For each node, first the node is visited and then it’s child nodes are put in a FIFO queue.

printLevelorderWithQueue()
1) Create an empty queue q
2) temp_node = root //start from root
3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children (first left then right children) to q
    c) Dequeue a node from q and assign it’s value to temp_node
 */
public class BinaryTree {

	// Root of the Binary Tree
	Node root;

	public BinaryTree() {
		root = null;
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		for (int i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}
	
	/* Function to print REVERSE level order traversal a tree*/
    void reverseLevelOrder() {
        int h = height(root);
        for (int i = h; i >= 1; i--) 
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
        {
            printGivenLevel(root, i);
        }
    }

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	
    /* Given a binary tree. Print its nodes in level order
    using array for implementing queue  */
   void printLevelOrderWithQueue() 
   {
       Queue<Node> queue = new LinkedList<Node>();
       queue.add(root);
       while (!queue.isEmpty()) 
       {

           /* poll() removes the present head.
           For more information on poll() visit 
           http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
           Node tempNode = queue.poll();
           System.out.print(tempNode.data + " ");

           /*Enqueue left child */
           if (tempNode.left != null) {
               queue.add(tempNode.left);
           }

           /*Enqueue right child */
           if (tempNode.right != null) {
               queue.add(tempNode.right);
           }
       }
   }
	
	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree method 1 ");
		tree.printLevelOrder();
		
		System.out.println("\nLevel order traversal of binary tree method 2 (wth queue) ");
		tree.printLevelOrderWithQueue();
		
		System.out.println("\n REVERSE Level Order traversal of binary: ");
        tree.reverseLevelOrder();
	}
	
}

class Node {
	int data;
	Node left, right;
	
	public Node(int item) {
		data = item;
		left = right = null;
	}
}
