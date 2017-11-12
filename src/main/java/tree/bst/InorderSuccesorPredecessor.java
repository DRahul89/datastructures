package main.java.tree.bst;

/**
 * 
 * 1. If root is NULL then return 2. if key is found then a. If its left subtree
 * is not null Then predecessor will be the right most child of left subtree or
 * left child itself. b. If its right subtree is not null The successor will be
 * the left most child of right subtree or right child itself. return 3. If key
 * is smaller then root node set the successor as root search recursively into
 * left subtree else set the predecessor as root search recursively into right
 * subtree
 * 
 * @author rdixi3
 *
 */
public class InorderSuccesorPredecessor {

	public static int preSuccesorInTree(BSTNode root, BSTNode succesor, BSTNode predecessor, int key) {
		if (root == null)
			return -1;
		if (root.getKey() == key) {
			// for predecessor
			if (root.getLeft() != null) {
				BSTNode temp = root.getLeft();
				while (temp.getRight() != null)
					temp = temp.getRight();
				predecessor = temp;
			}
			// for successor
			if (root.getRight() != null) {
				BSTNode temp = root.getRight();
				while (temp.getLeft() != null)
					temp = temp.getLeft();
				succesor = temp;
			}
		}
		if (root.getKey() > key) {
			succesor = root;
			return preSuccesorInTree(root.getLeft(), succesor, predecessor, key);
		}
		if (root.getKey() < key) {
			predecessor = root;
			return preSuccesorInTree(root.getRight(), succesor, predecessor, key);
		}
		return succesor.getKey();
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root=bst.insertRec(bst.root,20);
		bst.root=bst.insertRec(bst.root,22);
		bst.root=bst.insertRec(bst.root,8);
		bst.root=bst.insertRec(bst.root,4);
		bst.root=bst.insertRec(bst.root,10);
		bst.root=bst.insertRec(bst.root,12);
		bst.root=bst.insertRec(bst.root,14);
		//System.out.println(bst);
		BSTNode pre = new BSTNode(-1);
		BSTNode succ = new BSTNode(-1);
		System.out.println(preSuccesorInTree(bst.root, succ, pre, 14));
	}

}
