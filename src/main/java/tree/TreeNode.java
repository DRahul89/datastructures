package main.java.tree;

/**
 * A generic node for tree data structure
 * 
 * @author rdixi7
 *
 * @param <E>
 */
public class TreeNode<E> {

	private E data;

	private TreeNode<E> left;

	private TreeNode<E> right;

	private int liss;

	public TreeNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public TreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	public TreeNode<E> getRight() {
		return right;
	}

	public void setRight(TreeNode<E> right) {
		this.right = right;
	}

	public int getLiss() {
		return liss;
	}

	public void setLiss(int liss) {
		this.liss = liss;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
