package main.java.heap;

import main.java.tree.TreeNode;

/**
 * Algo to check a binary tree is heap or not first check its complete or not
 * then check all root is either greater or less to its child node if oth
 * condition meets then binary tree is Heap
 * 
 *
 */
public class BinaryTreeHeap {

	public static int countNodes(final TreeNode<Integer> root) {
		if (root == null)
			return 0;

		return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
	}

	public static boolean isComplete(TreeNode<Integer> root, int index, int size) {
		if (root == null)
			return true;
		if (index >= size)
			return false;

		return isComplete(root.getLeft(), 2 * index + 1, size) && isComplete(root.getLeft(), 2 * index + 2, size);
	}

	public static boolean isBinaryHeapUtil(TreeNode<Integer> root) {
		if (root.getLeft() == null && root.getRight() == null)
			return true;

		if (root.getRight() == null) {
			return root.getData() >= root.getLeft().getData();
		} else if (root.getLeft() != null && root.getRight() != null) {
			if (root.getData() >= root.getLeft().getData() && root.getData() >= root.getLeft().getData()) {
				return (isBinaryHeap(root.getLeft()) && isBinaryHeap(root.getRight()));
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * Tree is heap or not
	 * 
	 * @param root
	 * @return
	 */
	public static Boolean isBinaryHeap(final TreeNode<Integer> root) {
		int nodes = countNodes(root);
		return isComplete(root, 0, nodes) && isBinaryHeapUtil(root);
	}

	/**
	 * array is heap or not
	 * 
	 * @param root
	 * @return
	 */
	public static Boolean isBinaryHeap(final int[] root, int index,int arrlength) {
		if(index > (arrlength-2)/2)
		return true;
		
		
		return (root[index] >= root[2 * index + 1] && root[index] >= root[2 * index + 1]
				&& isBinaryHeap(root, 2 * index + 1,arrlength) && isBinaryHeap(root, 2 * index + 2,arrlength));
	}
	
	public static void main(String[] args) {
		int arr[] = {90, 15, 10, 17, 12, 2, 7, 3};
		System.out.println(isBinaryHeap(arr, 0, arr.length));
	}

}
