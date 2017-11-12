package main.java.tree;

/**
 * Algo: do pre order traversal and maintain an array when a leaf occur print
 * array
 * 
 * @author rdixi7
 *
 */
public class RootToLeafPaths {

	private static int PATH_SUM = 0;

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

	public static void sumRootToLeafPathsValues(TreeNode<Integer> root, int[] path, int pathLen) {
		if (root == null) {
			return;
		} else {
			path[pathLen++] = root.getData();
			if (root.getLeft() == null && root.getRight() == null) {
				for (int count = 0; count < pathLen; count++) {
					PATH_SUM = PATH_SUM + path[count];
				}
			}
			sumRootToLeafPathsValues(root.getLeft(), path, pathLen);
			sumRootToLeafPathsValues(root.getRight(), path, pathLen);
		}

	}

	public static void sumRootToLeafPaths(TreeNode<Integer> node) {
		int[] path = new int[1000];
		sumRootToLeafPathsValues(node, path, 0);
		System.out.println(PATH_SUM);
	}

	public static int sumRootToLeafPathsValuesSecond(TreeNode<Integer> root, int val) {
		if (root == null) {
			return 0;
		} else {
			val = val * 10 + root.getData();
			if (root.getLeft() == null && root.getRight() == null) {
				return val;
			}
			return sumRootToLeafPathsValuesSecond(root.getLeft(), val)
					+ sumRootToLeafPathsValuesSecond(root.getRight(), val);
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

	public static void kDistantFromLeafUtil(TreeNode<Integer> node, int path[], boolean visited[], int pathLen, int k) {
		// Base case
		if (node == null)
			return;

		/* append this Node to the path array */
		path[pathLen] = node.getData();
		visited[pathLen] = false;
		pathLen++;

		/*
		 * it's a leaf, so print the ancestor at distance k only if the ancestor
		 * is not already printed
		 */
		if (node.getLeft() == null && node.getRight() == null && pathLen - k - 1 >= 0
				&& visited[pathLen - k - 1] == false) {
			System.out.print(path[pathLen - k - 1] + " ");
			visited[pathLen - k - 1] = true;
			return;
		}

		/* If not leaf node, recur for left and right subtrees */
		kDistantFromLeafUtil(node.getLeft(), path, visited, pathLen, k);
		kDistantFromLeafUtil(node.getRight(), path, visited, pathLen, k);
	}

	public static void printKDistantfromLeaf(TreeNode<Integer> node, int k) {
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		kDistantFromLeafUtil(node, path, visited, 0, k);
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
		root.getRight().setLeft(new TreeNode<Integer>(6));
		root.getRight().setRight(new TreeNode<Integer>(7));
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);

		System.out.println(tree);
		// printRootToLeafPaths(tree.getRoot());
		// printMaxSumPath(tree.getRoot());
		//sumRootToLeafPaths(tree.getRoot());
		//System.out.println(sumRootToLeafPathsValuesSecond(tree.getRoot(), 0));
		printKDistantfromLeaf(tree.getRoot(),0);

	}

}
