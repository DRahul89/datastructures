package main.java.tree;

public class LCAOfTreeNode {

	public class Distance {
		private int firstNodeDist;
		private int secondNodeDist;
		private int distBetweenNodes;
	}

	/**
	 * algo if any node is eoual to root then return now check for left and
	 * right subtree if both contains node then root will be the LCA otherwise
	 * both key exist only either in left or right so whatever will be null that
	 * will be the LCA this method works only if both key present in tree so
	 * extend it to for null keys by taking two boolean variables
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static TreeNode<Integer> findLCA(TreeNode<Integer> root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.getData() == n1 || root.getData() == n2) {
			return root;
		}
		TreeNode<Integer> leftLCA = findLCA(root.getLeft(), n1, n2);
		TreeNode<Integer> rightLCA = findLCA(root.getRight(), n1, n2);

		if (null != leftLCA && null != rightLCA) {
			return root;
		}

		return null != leftLCA ? leftLCA : rightLCA;
	}

	public static TreeNode<Integer> findDistanceUtil(TreeNode<Integer> root, int n1, int n2, Distance distance,
			int level) {
		if (root == null)
			return null;
		if (root.getData() == n1) {
			distance.firstNodeDist = level;
			return root;
		}
		if (root.getData() == n2) {
			distance.secondNodeDist = level;
			return root;
		}
		TreeNode<Integer> leftLCA = findDistanceUtil(root.getLeft(), n1, n2, distance, level + 1);
		TreeNode<Integer> rightLCA = findDistanceUtil(root.getRight(), n1, n2, distance, level + 1);
		if (null != leftLCA && null != rightLCA) {
			distance.distBetweenNodes = distance.firstNodeDist + distance.secondNodeDist - 2 * level;
			return root;
		}
		return null != leftLCA ? leftLCA : rightLCA;
	}

	public static int findLevel(TreeNode<Integer> root, int node, int level) {
		if (root == null)
			return 0;
		if (root.getData() == node) {
			return level;
		}
		int leftLev = findLevel(root.getLeft(), node, level + 1);
		return 0 != leftLev ? leftLev : findLevel(root.getRight(), node, level + 1);
	}

	public static int findDistance(TreeNode<Integer> root, int n1, int n2) {
		// Initialize d1 (distance of n1 from root), d2 (distance of n2
		// from root) and dist(distance between n1 and n2)
		LCAOfTreeNode.Distance distance = new LCAOfTreeNode().new Distance();
		distance.firstNodeDist = -1;
		distance.secondNodeDist = -1;
		distance.distBetweenNodes = -1;
		TreeNode<Integer> lca = findDistanceUtil(root, n1, n2, distance, 1);
		// If both n1 and n2 were present in Binary Tree, return dist
		if (distance.firstNodeDist != -1 && distance.secondNodeDist != -1)
			return distance.distBetweenNodes;
		// If n1 is ancestor of n2, consider n1 as root and find level
		// of n2 in subtree rooted with n1
		if (distance.firstNodeDist != -1) {
			int levelOfn2 = findLevel(lca, n2, 0);
			return levelOfn2;
		}
		// If n2 is ancestor of n1, consider n2 as root and find level
		// of n1 in subtree rooted with n2
		if (distance.secondNodeDist != -1) {
			int levelOfn1 = findLevel(lca, n1, 0);
			return levelOfn1;
		}
		return -1;

	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		root.getRight().setLeft(new TreeNode<Integer>(6));
		root.getRight().setRight(new TreeNode<Integer>(7));
		root.getRight().getLeft().setRight(new TreeNode<Integer>(8));
		//System.out.println(findLCA(root, 2, 4).getData());
		//System.out.println(findLCA(root, 4, 7).getData());
		System.out.println(findDistance(root,4,5));
		System.out.println(findDistance(root,4,6));
		System.out.println(findDistance(root,3,4));
		System.out.println(findDistance(root,5,8));
		System.out.println(findDistance(root,2,4));
	}
}
