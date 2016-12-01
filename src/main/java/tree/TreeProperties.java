package main.java.tree;

public class TreeProperties {

	public static int size(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return size(node.getLeft()) + 1 + size(node.getRight());
	}

	public static int height(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
	}

	public static void mirror(TreeNode<Integer> node) {
		if (node == null)
			return;
		mirror(node.getLeft());
		mirror(node.getRight());
		TreeNode<Integer> temp = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(temp);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);

		System.out.println(tree);

		System.out.println("height =" + height(tree.getRoot()));
		System.out.println("size =" + size(tree.getRoot()));
	}

}
