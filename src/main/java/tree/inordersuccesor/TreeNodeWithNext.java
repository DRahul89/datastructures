package main.java.tree.inordersuccesor;

/**
 * A generic node for tree data structure
 * 
 * @author rdixi7
 *
 * @param <E>
 */
public class TreeNodeWithNext<E> {

	private E data;

	private TreeNodeWithNext<E> left;

	private TreeNodeWithNext<E> right;
	
	private TreeNodeWithNext<E> next;

	public TreeNodeWithNext(E data) {
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

	public TreeNodeWithNext<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNodeWithNext<E> left) {
		this.left = left;
	}

	public TreeNodeWithNext<E> getRight() {
		return right;
	}

	public void setRight(TreeNodeWithNext<E> right) {
		this.right = right;
	}
	

	public TreeNodeWithNext<E> getNext() {
		return next;
	}

	public void setNext(TreeNodeWithNext<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + ", next=" + next + "]";
	}

	
	
}
