package main.java.tree;

public class BinaryTree<E> {

	private TreeNode<E> root;

	public BinaryTree() {
		this.root = null;
	}
	public BinaryTree(final TreeNode<E> root) {
		this.root = root;
	}
	
	
	public TreeNode<E> getRoot() {
		return root;
	}
	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}
	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
	
	

}
