package main.java.tree;

/**
 * dynamic programming problem problem is you have to make a largest set of
 * independent nodes so that no two nodes would have any edge
 * 
 * sol optimal substructure for any node x would be Lixss[x]=max(1+largest set
 * of grand children,optimal subsctructure of children of x)
 * 
 * @author rdixi3
 *
 */
public class LargestIndependentSet {

	/**
	 * this solution has problem of overlapping subproblems
	 * 
	 * @param root
	 * @return
	 */
	public static int recursiveLargestIndependentSet(TreeNode<Integer> root) {
		if (root == null)
			return 0;

		int childSet = recursiveLargestIndependentSet(root.getLeft()) + recursiveLargestIndependentSet(root.getRight());
		int grandChildSet = 1;
		if (root.getLeft() != null)
			grandChildSet = grandChildSet + recursiveLargestIndependentSet(root.getLeft().getLeft())
					+ recursiveLargestIndependentSet(root.getLeft().getRight());
		if (root.getRight() != null)
			grandChildSet = grandChildSet + recursiveLargestIndependentSet(root.getRight().getLeft())
					+ recursiveLargestIndependentSet(root.getRight().getRight());

		return Math.max(childSet, grandChildSet);

	}

	/**
	 * so we maintain a liss in each node so that we could avoid the duplicate
	 * cycles
	 * 
	 * @param root
	 * @return
	 */
	public static int dpSolution(TreeNode<Integer> root) {
		if (root == null)
			return 0;
		if (root.getLiss() != 0)
			return root.getLiss();
		int childSet = dpSolution(root.getLeft()) + dpSolution(root.getRight());
		int grandChildSet = 1;
		if (root.getLeft() != null)
			grandChildSet = grandChildSet + dpSolution(root.getLeft().getLeft())
					+ dpSolution(root.getLeft().getRight());
		if (root.getRight() != null)
			grandChildSet = grandChildSet + dpSolution(root.getRight().getLeft())
					+ dpSolution(root.getRight().getRight());

		int liss = Math.max(childSet, grandChildSet);
		root.setLiss(liss);
		return liss;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(10);
		root.setLeft(new TreeNode<Integer>(20));
		root.setRight(new TreeNode<Integer>(30));
		root.getLeft().setLeft(new TreeNode<Integer>(40));
		root.getLeft().setRight(new TreeNode<Integer>(50));
		root.getRight().setRight(new TreeNode<Integer>(60));
		root.getLeft().getRight().setLeft(new TreeNode<Integer>(70));
		 root.getLeft().getRight().setRight(new TreeNode<Integer>(80));
		// System.out.println(recursiveLargestIndependentSet(root));
		System.out.println(dpSolution(root));
	}

}
