package binarytree.ternarytree;

/*
 * Ternary tree drawn here - http://cs-people.bu.edu/behoppe/videos/rooted%20tree.jpg
 */
public class ReverseLeverOrderTraversalTernaryTree {
		
	/*
		 *  Get the height of the tree.
			Put a for loop for each level in tree.
			for each level in step 2, do pre order tra­ver­sal 
			and print only when height matches to the level.
		 */
		
		public void reverseLevelOrderNaiveApproach(Node root) {
			int h = getTreeHeight(root);
			//System.out.println("height: "+h);
			for (int i = h; i >= 1; i--) {
				System.out.print("Floor "+(h-i+1)+": ");
				printLevels(root, i);
				System.out.println("");
			}
		}
		
		public void printLevels(Node root, int h) {
			if (root == null)
				return;
			if (h == 1)
				System.out.print(" " + root.data);
			else {
				printLevels(root.left, h - 1);
				printLevels(root.mid, h - 1);
				printLevels(root.right, h - 1);
			}
		}
		
		public int getTreeHeight(Node root) {
			if (root == null)
				return 0;
			int maxLeftRight =  Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
			int max = Math.max(maxLeftRight, getTreeHeight(root.mid));
			return 1 + max;
		}
		
		public static void main(String[] args) throws java.lang.Exception {
			Node root = createTree();
			ReverseLeverOrderTraversalTernaryTree runner = new ReverseLeverOrderTraversalTernaryTree();
			runner.reverseLevelOrderNaiveApproach(root);
		}

		private static Node createTree() {
			
			//3-9-4
			Node root = new Node(3);
			root.left = new Node(9);
			root.right = new Node(4);
			
			//9-2
			root.left.left = new Node(2);
			
			//9-4
			root.right.left = new Node(10);
			root.right.mid = new Node(6);
			root.right.right = new Node(5);
			
			//2-8
			root.left.left.left = new Node(8);
			//8-1
			root.left.left.left.left = new Node(1);
			
			//6-7
			root.right.mid.left = new Node(7);
			
			return root;
		}
	}

	class Node {
		
		int data;
		Node left;
		Node right;
		Node mid;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.mid = null;
		}
	}
