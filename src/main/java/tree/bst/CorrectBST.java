package main.java.tree.bst;

class BSTNodeWrapper {
	public BSTNode node;
}

/**
 * Two nodes swapped incorrect correct bst algo is we do the inorder traversal
 * and maintain the three pointers there can be only two cases (1) two noes are
 * not adjacent For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20
 * 25}. The inorder traversal of the given tree is 3 25 7 8 10 15 20 5 (2)two
 * nodes are adjacent For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15
 * 20 25}. The inorder traversal of the given tree is 3 5 8 7 10 15 20 25
 * 
 *
 */
public class CorrectBST {

	public static void correctBSTUtil(BSTNode root, BSTNodeWrapper first, BSTNodeWrapper middle, BSTNodeWrapper last,
			BSTNodeWrapper previous) {
		if (root == null)
			return;
		correctBSTUtil(root.getLeft(), first, middle, last, previous);
		if (previous.node != null && previous.node.getKey() > root.getKey()) {
			if (first.node == null) {
				first.node = previous.node;
				middle.node = root;
			} else {
				last.node = root;
			}
		}
		previous.node = root;
		correctBSTUtil(root.getRight(), first, middle, last, previous);

	}

	public static void swapBSTNODE(BSTNode first, BSTNode second) {
		int key = first.getKey();
		first.setKey(second.getKey());
		second.setKey(key);
	}

	public static BSTNode correctBST(BSTNode root) {
		BSTNodeWrapper first = new BSTNodeWrapper();
		BSTNodeWrapper middle = new BSTNodeWrapper();
		BSTNodeWrapper last = new BSTNodeWrapper();
		BSTNodeWrapper previous = new BSTNodeWrapper();
		correctBSTUtil(root, first, middle, last, previous);
		// for case 1
		if (last.node != null) {
			swapBSTNODE(first.node, last.node);
		} else {
			// second case
			swapBSTNODE(first.node, middle.node);
		}
		return root;
	}

	public static void inorderTraversal(BSTNode root) {
		if (root == null)
			return;
		inorderTraversal(root.getLeft());
		System.out.print(root.getKey() + " ");
		inorderTraversal(root.getRight());
	}

	public static void main(String[] args) {
		BSTNode root = new BSTNode(6);
		root.setLeft(new BSTNode(10));
		root.setRight(new BSTNode(2));
		root.getLeft().setLeft(new BSTNode(1));
		root.getLeft().setRight(new BSTNode(3));
		root.getRight().setLeft(new BSTNode(7));
		root.getRight().setRight(new BSTNode(12));
		inorderTraversal(root);
		System.out.println("");
		inorderTraversal(correctBST(root));
	}
}
