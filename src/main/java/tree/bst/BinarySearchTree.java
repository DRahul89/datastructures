package main.java.tree.bst;

public class BinarySearchTree {

	private BSTNode root;

	public BSTNode searchValue(BSTNode root, int key) {
		if (null == root || root.equals(key))
			return root;
		if (root.key > key)
			return searchValue(root.left, key);

		return searchValue(root.right, key);
	}

	public BSTNode insertRec(BSTNode root, int key) {
		if (null == root) {
			root = new BSTNode(key);
			return root;
		}
		if (root.key > key)
			root.left = insertRec(root.left, key);
		if (root.key > key)
			root.right = insertRec(root.right, key);

		return root;
	}

}
