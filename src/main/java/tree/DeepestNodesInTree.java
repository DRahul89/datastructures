package main.java.tree;

public class DeepestNodesInTree {

	public class Level {
		int level = 1;
	}

	private static int LEAF_LEVEL = -1;

	public static int maximumOddLeaf(TreeNode<Integer> root, int level) {
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null && (level % 2 != 0)) {
			return level;
		}

		return Math.max(maximumOddLeaf(root.getLeft(), level + 1), maximumOddLeaf(root.getRight(), level + 1));
	}

	public static boolean isAllLeafAtSameLevel(TreeNode<Integer> root, int level) {
		if (root == null)
			return Boolean.TRUE;
		if (root.getLeft() == null && root.getRight() == null) {
			if (LEAF_LEVEL == -1) {
				LEAF_LEVEL = level;
				return Boolean.TRUE;
			}

			return (LEAF_LEVEL == level);
		}
		return isAllLeafAtSameLevel(root.getLeft(), level + 1) && isAllLeafAtSameLevel(root.getRight(), level + 1);
	}

	public static void maximumLeftLeaf(TreeNode<Integer> root, int level, Level mxl, boolean isLeftNode) {
		if (root == null)
			return ;
		if (root.getLeft() == null && root.getRight() == null && isLeftNode) {
			if (level > mxl.level) {
				mxl.level = level;
			}
		}
		maximumLeftLeaf(root.getLeft(),level+1,mxl,Boolean.TRUE);
		maximumLeftLeaf(root.getRight(),level+1,mxl,Boolean.FALSE);
		
	}
	
	public static  int maxLeftLeafWrapper(TreeNode<Integer> root){
		DeepestNodesInTree d = new DeepestNodesInTree();
		DeepestNodesInTree.Level mxl= d.new Level();
		maximumLeftLeaf(root,1,mxl,Boolean.FALSE);
		return mxl.level;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		root.getRight().setLeft(new TreeNode<Integer>(6));
		root.getRight().setRight(new TreeNode<Integer>(7));
		root.getRight().getRight().setRight(new TreeNode<Integer>(8));
		root.getRight().getRight().getRight().setLeft(new TreeNode<Integer>(9));
		System.out.println(maximumOddLeaf(root, 1));
		System.out.println(isAllLeafAtSameLevel(root, 1));
		System.out.println(maxLeftLeafWrapper(root));

		TreeNode<Integer> root2 = new TreeNode<Integer>(1);
		root2.setLeft(new TreeNode<Integer>(2));
		root2.setRight(new TreeNode<Integer>(3));
		root2.getLeft().setLeft(new TreeNode<Integer>(4));
		root2.getLeft().setRight(new TreeNode<Integer>(5));
		root2.getRight().setLeft(new TreeNode<Integer>(6));
		root2.getRight().setRight(new TreeNode<Integer>(7));
		System.out.println(isAllLeafAtSameLevel(root2, 1));
		System.out.println(maxLeftLeafWrapper(root2));
	}
}
