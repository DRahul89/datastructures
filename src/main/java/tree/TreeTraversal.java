package main.java.tree;

/**
 * worst case time o(n) avg case o(logn)
 * 
 * @author rdixi7
 *
 */
public class TreeTraversal {

	public static void preOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.getData());
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.getLeft());
		System.out.println(root.getData());
		inOrderTraversal(root.getRight());
	}

	public static void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		System.out.println(root.getData());
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);

		System.out.println(tree);
		
		System.out.println("Preorder traversal of binary tree is ");
		preOrderTraversal(tree.getRoot());

		/*System.out.println("inorder traversal of binary tree is ");
		inOrderTraversal(tree.getRoot());

		System.out.println("postorder traversal of binary tree is ");
		postOrderTraversal(tree.getRoot());*/
	}

}
