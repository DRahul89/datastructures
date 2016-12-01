package main.java.tree;

/**
 * Number of nodes between the longest path between two nodes
 * max of
 * left subtree
 * right subtree
 * with root node(through height)
 * 
 * @author rdixi7
 *
 */
public class DiameterOfTree {

	public static int height(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
	}

	public static int diameter(TreeNode<Integer> root) {
		if(root == null)
			return 0;
		int leftHt = height(root.getLeft());
		int rightHt = height(root.getRight());
		
		int leftDmtr= diameter(root.getLeft());
		int rightDmtr = diameter(root.getRight());
		
		return Math.max(leftHt+rightHt+1, Math.max(leftDmtr, rightDmtr));

	}

}
