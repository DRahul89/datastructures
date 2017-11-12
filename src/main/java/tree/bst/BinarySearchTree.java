package main.java.tree.bst;

import main.java.tree.TreeNode;

public class BinarySearchTree {

	public BSTNode root;

	@Override
	public String toString() {
		return "BinarySearchTree [root=" + root + "]";
	}

	public static BSTNode searchValue(BSTNode root, int key) {
		if (null == root || root.equals(key))
			return root;
		if (root.key > key)
			return searchValue(root.left, key);

		return searchValue(root.right, key);
	}

	public static BSTNode insertRec(BSTNode root, int key) {
		if (null == root) {
			root = new BSTNode(key);
			return root;
		}
		if (root.key > key)
			root.setLeft(insertRec(root.left, key));
		if (root.key < key)
			root.setRight(insertRec(root.right, key));

		return root;
	}

	public static BSTNode deleteRec(BSTNode root, int key) {
		if (null == root) {
			return null;
		}
		if (root.key > key)
			root.left = deleteRec(root.left, key);
		else if (root.key < key)
			root.right = deleteRec(root.right, key);

		else {
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			}
			// case node has both children
			root.setKey(getInorderSuccesor(root.getRight()));
			root.setRight(deleteRec(root.getRight(), root.getKey()));
		}

		return root;
	}

	private static int getInorderSuccesor(BSTNode right) {
		if (right.getLeft() == null)
			return right.getKey();
		return getInorderSuccesor(right.getLeft());
	}

	
	 boolean isBST()  {
	        return isBSTUtil(root, Integer.MIN_VALUE,
	                               Integer.MAX_VALUE);
	    }
	 
	    /* Returns true if the given tree is a BST and its
	      values are >= min and <= max. */
	    boolean isBSTUtil(BSTNode node, int min, int max)
	    {
	        /* an empty tree is BST */
	        if (node == null)
	            return true;
	 
	        /* false if this node violates the min/max constraints */
	        if (node.key < min || node.key > max)
	            return false;
	 
	        /* otherwise check the subtrees recursively
	        tightening the min/max constraints */
	        // Allow only distinct values
	        return (isBSTUtil(node.left, min, node.key-1) &&
	                isBSTUtil(node.right, node.key+1, max));
	    }
	public static boolean isBST(TreeNode<Integer> root) {
		if (root == null)
			return true;
		int maxOfLeft = leftMax(root);
		int minOfRight = rightMin(root);
		if (root.getData() < maxOfLeft || root.getData() > minOfRight) {
			return false;
		} 

		return isBST(root.getLeft()) && isBST(root.getRight());
	}

	private static int rightMin(TreeNode<Integer> node) {
		TreeNode<Integer> temp = node.getRight();
		if (temp == null)
			return Integer.MAX_VALUE;
		while (temp.getLeft() != null)
			temp = temp.getLeft();
		return temp.getData();
	}

	private static int leftMax(TreeNode<Integer> node) {
		TreeNode<Integer> temp = node.getLeft();
		if (temp == null)
			return -1;
		while (temp.getRight() != null)
			temp = temp.getRight();
		return temp.getData();
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = insertRec(bst.root, 50);
		bst.root = insertRec(bst.root, 30);
		bst.root = insertRec(bst.root, 20);
		bst.root = insertRec(bst.root, 40);
		bst.root = insertRec(bst.root, 70);
		bst.root = insertRec(bst.root, 60);
		bst.root = insertRec(bst.root, 80);
		//System.out.println(bst);
		//System.out.println(deleteRec(bst.root, 50));
		//System.out.println(isBST(bst.root));
		
		TreeNode<Integer> root = new TreeNode<Integer>(3);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(5));
		root.getLeft().setLeft(new TreeNode<Integer>(1));
		root.getLeft().setRight(new TreeNode<Integer>(4));
		
		
		System.out.println(isBST(root));

	}

}
