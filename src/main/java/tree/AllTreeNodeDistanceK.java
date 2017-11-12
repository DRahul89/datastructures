package main.java.tree;

/**
 * 
 * algo is finding of node in subtree at distance K is easy for other subtree
 * node we traverse for all ancestors and search in other subtrees supose
 * distance of ancestor is d from target then we search in other subtree with
 * k-d-1 distance nodes
 *
 */
public class AllTreeNodeDistanceK {

	public static int printAllKDistanceNodes(TreeNode<Integer> root, int targetNode, int k) {
		if (root == null)
			return -1;
		if (root.getData() == targetNode) {
			printDownNodeWithDistanceK(root, k);
			return 0;
		}
		// search target node in left subtree
		int dl = printAllKDistanceNodes(root.getLeft(), targetNode, k);
		// if target node found in left subtree
		if (dl != -1) {
			if (dl + 1 == k) {
				System.out.println(root.getData());
			} else {
				printDownNodeWithDistanceK(root.getRight(), k - dl - 2);
			}
			// return for parent node operations
			return dl + 1;
		}

		// search target node in left subtree
		int dr = printAllKDistanceNodes(root.getRight(), targetNode, k);
		// if target node found in left subtree
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.println(root.getData());
			} else {
				printDownNodeWithDistanceK(root.getLeft(), k - dr - 2);
			}
			// return for parent node operations
			return dr + 1;
		}
		// if neither in left subtree target found nor in right
		return -1;
	}

	private static void printDownNodeWithDistanceK(TreeNode<Integer> root, int k) {
		if (root == null || k < 0)
			return;
		if (k == 0) {
			System.out.print(root.getData() +" ");
			return;
		}
		printDownNodeWithDistanceK(root.getLeft(), k - 1);
		printDownNodeWithDistanceK(root.getRight(), k - 1);
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(20);
		root.setLeft(new TreeNode<Integer>(8));
		root.setRight(new TreeNode<Integer>(22));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(12));
		root.getLeft().getRight().setLeft(new TreeNode<Integer>(10));
		root.getLeft().getRight().setRight(new TreeNode<Integer>(14));
		printAllKDistanceNodes(root, 8, 2);
		System.out.println("");
		printAllKDistanceNodes(root, 14, 3);
	}
}
