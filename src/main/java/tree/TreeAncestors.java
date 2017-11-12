package main.java.tree;

public class TreeAncestors {

	public static boolean printAncestorsOfNode(final TreeNode<Integer> root, int nodeData) {
		if (root == null)
			return false;
		if (root.getData() == nodeData)
			return true;
		// ancestor if node found either in left or in right subtree
		if (printAncestorsOfNode(root.getLeft(), nodeData) || printAncestorsOfNode(root.getRight(), nodeData)) {
			System.out.print(root.getData()+"-->");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		root.getLeft().getLeft().setLeft(new TreeNode<Integer>(7));
		root.getLeft().getLeft().getLeft().setRight(new TreeNode<Integer>(8));
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);
		printAncestorsOfNode(tree.getRoot(), 8);
	}

}
