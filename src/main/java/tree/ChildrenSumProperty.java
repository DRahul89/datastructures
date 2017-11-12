package main.java.tree;

/**
 * Algo post order traverse find diff between subtrees and node if its positive
 * then add to node if its nehgative then increment the left subtree if not null
 * otherwise right sub tree
 * 
 * @author rdixi7
 *
 */
public class ChildrenSumProperty {

	public static void convertToChildrenSum(TreeNode<Integer> node) {
		if (node == null || (node.getLeft() == null && node.getRight() == null)) {
			return;
		} else {
			convertToChildrenSum(node.getLeft());
			convertToChildrenSum(node.getRight());
			int leftVal = node.getLeft() != null ? node.getLeft().getData() : 0;
			int rightVal = node.getRight() != null ? node.getRight().getData() : 0;
			int diff = (leftVal + rightVal) - node.getData();
			if (diff > 0) {
				node.setData(node.getData() + diff);
			} else {
				increment(node, -diff);
			}
		}
	}

	private static void increment(TreeNode<Integer> node, int diff) {
		if (node.getLeft() != null) {
			node.getLeft().setData(node.getLeft().getData() + diff);
			increment(node.getLeft(), diff);
		} else if (node.getRight() != null) {
			node.getRight().setData(node.getRight().getData() + diff);
			increment(node.getRight(), diff);
		}

	}

	private static boolean isLeaf(TreeNode<Integer> node) {
		if (node == null)
			return false;
		if (node.getLeft() == null && node.getRight() == null)
			return true;

		return false;
	}

	/**
	 * algo is if a node leaf then sum vale will be its node value but if its
	 * not leaf and its left and right node are also sumTree then its sum will
	 * be 2*nodevalue
	 */
	public static boolean checkTreeIsSumTree(TreeNode<Integer> root) {
		if (root == null)
			return true;
		if (isLeaf(root))
			return true;
		if (checkTreeIsSumTree(root.getLeft()) && checkTreeIsSumTree(root.getRight())) {
			int leftSum = -1;
			int rightSum = -1;
			if (null == root.getLeft()) {
				leftSum = 0;
			} else if (isLeaf(root.getLeft())) {
				leftSum = root.getLeft().getData();
			} else {
				leftSum = 2 * root.getLeft().getData();
			}

			if (null == root.getRight()) {
				rightSum = 0;
			} else if (isLeaf(root.getRight())) {
				rightSum = root.getRight().getData();
			} else {
				rightSum = 2 * root.getRight().getData();
			}
			if (root.getData() == (leftSum + rightSum)) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	private static boolean isIdentical(TreeNode<Integer> root, TreeNode<Integer> subTree) {

		if (root == null && subTree == null)
			return true;

		if (root == null || subTree == null)
			return false;
		return (root.getData() == subTree.getData() && isIdentical(root.getLeft(), subTree.getLeft())
				&& isIdentical(root.getRight(), subTree.getRight()));
	}

	/**
	 * algo is traverse tree in preorder fashion and check identical
	 * 
	 * @param root
	 * @param subTree
	 * @return
	 */
	public static boolean isSubTree(TreeNode<Integer> root, TreeNode<Integer> subTree) {
		if (subTree == null)
			return true;
		if (root == null)
			return false;
		if (isIdentical(root, subTree))
			return true;

		return (isSubTree(root.getLeft(), subTree) || isSubTree(root.getRight(), subTree));
	}

	public static int sumTreeWithLeafZero(TreeNode<Integer> root) {
		if (root.getLeft() == null && root.getRight() == null) {
			int leafVal = root.getData();
			root.setData(0);
			return leafVal;
		}

		int leftSum = sumTreeWithLeafZero(root.getLeft());
		int rightSum = sumTreeWithLeafZero(root.getRight());
		int nodeSum = root.getData() + leftSum + rightSum;
		root.setData(leftSum + rightSum);
		return nodeSum;

	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(26);
		root.setLeft(new TreeNode<Integer>(10));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(6));
		root.getRight().setLeft(new TreeNode<Integer>(3));

		TreeNode<Integer> root2 = new TreeNode<Integer>(10);
		root2.setLeft(new TreeNode<Integer>(4));
		root2.setRight(new TreeNode<Integer>(6));

		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);
		//System.out.println(checkTreeIsSumTree(tree.getRoot()));
		//System.out.println(isSubTree(root, root2));
		
		TreeNode<Integer> root3 = new TreeNode<Integer>(10);
		root3.setLeft(new TreeNode<Integer>(-2));
		root3.setRight(new TreeNode<Integer>(6));
		root3.getLeft().setLeft(new TreeNode<Integer>(8));
		root3.getLeft().setRight(new TreeNode<Integer>(-4));
		root3.getRight().setLeft(new TreeNode<Integer>(7));
		root3.getRight().setRight(new TreeNode<Integer>(5));
		sumTreeWithLeafZero(root3);
		System.out.println(root3);
	}
}