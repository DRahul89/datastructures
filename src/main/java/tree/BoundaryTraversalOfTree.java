package main.java.tree;

/**
 * 
 * algo break the problem in three parts 1.print the left boundry top down
 * manner 2.print all leaf from left to right 3.print right boundary in bottom
 * up manner
 *
 */
public class BoundaryTraversalOfTree {

	public static void printLeaf(TreeNode<Integer> node) {
		if (null == node)
			return;
		printLeaf(node.getLeft());
		if (node.getLeft() == null && node.getRight() == null)
			System.out.print(node.getData());
		printLeaf(node.getRight());

	}

	/**
	 * top down manner
	 * 
	 * @param node
	 */
	public static void printLeftBoundry(TreeNode<Integer> node) {
		if (null != node) {
			System.out.print(node.getData());
			if (null != node.getLeft()) {

				printRightBoundry(node.getLeft());
			}
			else if (null != node.getRight()) {
				printRightBoundry(node.getRight());
			}
		}
	}

	/**
	 * bottom up manner
	 * 
	 * @param node
	 */
	public static void printRightBoundry(TreeNode<Integer> node) {
		if (null != node) {
			if (null != node.getRight()) {
				printRightBoundry(node.getRight());
				System.out.print(node.getData());
			}
			else if (null != node.getLeft()) {
				printRightBoundry(node.getLeft());
				System.out.print(node.getData());
			}
		}
	}

	public static void printBoundryData(TreeNode<Integer> root) {
		printLeftBoundry(root);
		printLeaf(root.getLeft());
		printLeaf(root.getRight());
		printRightBoundry(root);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		root.getRight().setLeft(new TreeNode<Integer>(6));
		root.getRight().setRight(new TreeNode<Integer>(7));

		printBoundryData(root);
	}
}
