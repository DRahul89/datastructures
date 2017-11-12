package main.java.tree.bst;

/**
 * lowest commont ancestor used to find distance between 2 nodes
 * 
 * @author rdixi3
 *
 */
public class LCA {

	public static BSTNode lca(final BSTNode root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.getKey() > n1 && root.getKey() > n2)
			return lca(root.getLeft(), n1, n2);
		if (root.getKey() < n1 && root.getKey() < n2)
			return lca(root.getRight(), n1, n2);
		return root;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.insertRec(bst.root, 50);
		bst.root = bst.insertRec(bst.root, 30);
		bst.root = bst.insertRec(bst.root, 20);
		bst.root = bst.insertRec(bst.root, 40);
		bst.root = bst.insertRec(bst.root, 70);
		bst.root = bst.insertRec(bst.root, 60);
		bst.root = bst.insertRec(bst.root, 80);
		System.out.println(lca(bst.root,20,80).getKey());
	}
}
