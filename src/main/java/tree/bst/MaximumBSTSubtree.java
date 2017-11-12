package main.java.tree.bst;

import main.java.tree.BinaryTree;
import main.java.tree.TreeNode;

/**
 * 
 * @author rdixi3
 *
 */
public class MaximumBSTSubtree {

	private static boolean isBST(BSTNode root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	private static boolean isBSTUtil(BSTNode node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.key < min || node.key > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.key - 1) && isBSTUtil(node.right, node.key + 1, max));
	}

	private static int sizeOfBST(BSTNode bstNode) {
		if (bstNode == null)
			return 0;
		return sizeOfBST(bstNode.getLeft()) + sizeOfBST(bstNode.getRight()) + 1;
	}

	/**
	 * order n2 algo
	 * 
	 * @param bstNode
	 * @return
	 */
	public static int maxBSTSubtree(final BSTNode bstNode) {
		if (isBST(bstNode))
			return sizeOfBST(bstNode);

		return Math.max(maxBSTSubtree(bstNode.getLeft()), maxBSTSubtree(bstNode.getRight()));
	}

	public static int maxBSTSubtreeUtil(final TreeNode<Integer> bstNode) {
		Value val = new Value();
		maxBSTSubtree(bstNode, val);
		return val.maxBSTSize;
	}

	/**
	 * bottom up approach to find is bst oreder n sol read algo from geks bottom
	 * up approach
	 * 
	 * @param bstNode
	 * @param value
	 * @return
	 */
	public static int maxBSTSubtree(final TreeNode<Integer> bstNode, Value value) {
		if (bstNode == null) {
			value.isBST = true;
			return 0;
		}

		int min = Integer.MAX_VALUE;
		boolean isLeftBST = Boolean.FALSE;
		boolean isRightBST = Boolean.FALSE;
		value.maxVal = Integer.MIN_VALUE;
		int ls = maxBSTSubtree(bstNode.getLeft(), value);
		if (value.isBST && bstNode.getData() > value.maxVal) {
			isLeftBST = Boolean.TRUE;
		}
		min = value.minVal;// think we need min of rigt but for parent we also
							// need min of this subtree for max we dont need to
							// store bcz max need finish at left subtree
		value.minVal = Integer.MAX_VALUE;
		int rs = maxBSTSubtree(bstNode.getRight(), value);
		if (value.isBST && bstNode.getData() < value.minVal) {
			isRightBST = Boolean.TRUE;
		}
		if (min < value.minVal) {
			value.minVal = min;
		}
		if (bstNode.getData() < value.minVal) {
			value.minVal = bstNode.getData();
		}
		if (bstNode.getData() > value.maxVal) {
			value.maxVal = bstNode.getData();
		}
		if (isLeftBST && isRightBST) {
			if (ls + rs + 1 > value.maxBSTSize) {
				value.maxBSTSize = ls + rs + 1;
			}
			value.isBST = Boolean.TRUE;
			return value.maxBSTSize;
		} else {
			value.isBST = Boolean.FALSE;
			return 0;
		}
	}

	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<Integer>(50);
		root.setLeft(new TreeNode<Integer>(30));
		root.setRight(new TreeNode<Integer>(60));
		root.getLeft().setLeft(new TreeNode<Integer>(5));
		root.getLeft().setRight(new TreeNode<Integer>(20));
		root.getRight().setLeft(new TreeNode<Integer>(45));
		root.getRight().setRight(new TreeNode<Integer>(70));
		root.getRight().getRight().setLeft(new TreeNode<Integer>(65));
		root.getRight().getRight().setRight(new TreeNode<Integer>(80));
		System.out.println(maxBSTSubtreeUtil(root));
	}
}
