package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* 
 * reverse-level-order-traversal-of-binary TREE
 * 
 * http://www.java2blog.com/2016/04/reverse-level-order-traversal-of-binary.html
 */
public class BinaryTree {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	// prints in reverse level order
	/*
	 * Steps for Reverse Level order traversal algorithm: 
	 * Create empty queue and push root node to it. 
	 * Do the following when queue is not empty
	 * 	1.Pop(poll/get) a node from queue and print it 
	 *  2.Push(add) right child of popped node to queue if not null 
	 *  3.Push(add) left child of popped node to queue if not null 
	 *  4.Push(add) current node to stack 
	 *  5.Pop node from stack and print it
	 *  
	 *  Reverse Level Order traversal of binary tree:
		10 30 50 70 20 60 40
	 */
	public static void reverseLevelOrderTraversal(TreeNode startNode) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		// 0.Create empty queue and push(add) root node to it.
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(startNode);

		while (!queue.isEmpty()) {
			// 1. Retrieves and removes the head of this queue, or returns null
			// if this queue is empty.
			TreeNode tempNode = queue.poll();
			// 2. Push(add) right child of popped node to queue if not null
			if (tempNode.right != null)
				queue.add(tempNode.right);
			// 3. Push(add) left child of popped node to queue if not null
			if (tempNode.left != null)
				queue.add(tempNode.left);
			// 4.Push(add) current node to stack
			stack.push(tempNode);
		}
		// 5.Pop node from stack and print it
		while (!stack.empty())
			System.out.print(stack.pop().data + " ");
		System.out.println("\n");
	}

	/* prints in level order
	 * We will use Queue for Level Order traversal.
	 * This algorithm is very similar to Breadth first search of graph.
		Steps for Level order traversal algorithm:
			Create empty queue and put root node to it.
			Do the following when queue is not empty
				1.Pop a node from queue and print it
				2.Push left child of popped node to queue if not null
				3.Push right child of popped node to queue if not null
		
		Level Order traversal of binary tree:
		40 20 60 10 30 50 70 
	 */

	public static void levelOrderTraversal(TreeNode startNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(startNode);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			System.out.printf("%d ", tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	public static void main(String[] args) {
		TreeNode rootNode = createBinaryTree();
		
		System.out.println("Reverse Level Order traversal of binary tree:");
		reverseLevelOrderTraversal(rootNode);
		
		System.out.println("Level Order traversal of binary tree:");
		levelOrderTraversal(rootNode);
	}

	public static TreeNode createBinaryTree() {
		//    40
		// 20 	  60
		//10 30	50 	70

		TreeNode rootNode = new TreeNode(40);

		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);

		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
