package main.java.tree;

/**
 * Algo: do pre order traversal and maintain an array when a leaf occur print
 * array
 * 
 * @author rdixi7
 *
 */
public class RootToLeafPaths {

	public static void printRootToLeafPaths(TreeNode<Integer> node) {
		int[] path = new int[1000];
		printPaths(node, path, 0);
	}

	private static void printArray(int[] paths, int len) {
		for (int i = 0; i < len; i++)
			System.out.print(paths[i]);
	}

	public static void printPaths(TreeNode<Integer> root, int[] path, int pathLen) {
		if (root == null) {
			return;
		} else {
			path[pathLen++] = root.getData();
			if (root.getLeft() == null && root.getRight() == null) {
				printArray(path, pathLen);
				System.out.println(" ");
			}
			printPaths(root.getLeft(), path, pathLen);
			printPaths(root.getRight(), path, pathLen);
		}

	}

	/**
	 * Finding the path from root to leaf which contains the given sum(return
	 * true if exists)
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean rootToLeafPathSum(TreeNode<Integer> root, int sum) {
		if (root == null) {
			return (sum == 0);
		} else {
			int subSum = sum - root.getData();
			if (subSum == 0 && root.getLeft() == null && root.getRight() == null) {
				return true;
			} else {
				return rootToLeafPathSum(root.getLeft(), subSum) || rootToLeafPathSum(root.getRight(), subSum);
			}
		}

	}

	// now root to leaf path with max sum algo is find the leaf for the desired
	// path and then print the path

	public static TreeNode<Integer> findTargetLeaf(TreeNode<Integer> root, int currentSum, CustomInteger maxSum,
			TreeNode<Integer> referNode) {
		if (root == null)
			return null;
		currentSum = currentSum + root.getData();
		if (root.getLeft() == null && root.getRight() == null) {
			if (currentSum > maxSum.getValue()) {
				maxSum.setValue(currentSum);
				return root;
			} else {
				return referNode;
			}
		}
		TreeNode<Integer> targetLeaf = findTargetLeaf(root.getLeft(), currentSum, maxSum, referNode);
		targetLeaf = findTargetLeaf(root.getRight(), currentSum, maxSum, targetLeaf);
		return targetLeaf;

	}

	public static boolean printPath(TreeNode<Integer> root, TreeNode<Integer> targetLeaf) {
		if (root == null)
			return false;

		if ((root == targetLeaf) || printPath(root.getLeft(), targetLeaf) || printPath(root.getRight(), targetLeaf)) {
			System.out.println(root.getData() + " ");
			return true;
		}
		return false;

	}

	public static void printMaxSumPath(TreeNode<Integer> root) {
		TreeNode<Integer> referenceNode = null;
		CustomInteger cs = new CustomInteger(-1);
		referenceNode = findTargetLeaf(root, 0, cs, null);
		printPath(root, referenceNode);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);

		System.out.println(tree);
		// printRootToLeafPaths(tree.getRoot());
		printMaxSumPath(tree.getRoot());

	}

}
