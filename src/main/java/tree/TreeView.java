package main.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TreeView {

	public class Level {
		int level = -1;
	}

	/**
	 * simple algo is to use Level oreder Traversal and print first oif all
	 * level this is recursiive algo algo is update max level if level is same
	 * as max level this level is already visited otherwise print
	 */
	public static void printLeftView(TreeNode<Integer> root, Level mxl, int level) {
		if (root == null)
			return;
		if (level > mxl.level) {
			System.out.print(root.getData());
			mxl.level = level;
		}

		printLeftView(root.getLeft(), mxl, level + 1);
		printLeftView(root.getRight(), mxl, level + 1);
	}

	public static void printLeftViewWrapper(TreeNode<Integer> root) {
		TreeView.Level l = new TreeView().new Level();
		printLeftView(root, l, 1);
	}

	/**
	 * simple algo is to use Level oreder Traversal and print first oif all
	 * level this is recursiive algo algo is update max level if level is same
	 * as max level this level is already visited otherwise print but we
	 * traverse RNL not LNR for right view
	 */
	public static void printRightView(TreeNode<Integer> root, Level mxl, int level) {
		if (root == null)
			return;
		if (level > mxl.level) {
			System.out.print(root.getData());
			mxl.level = level;
		}

		printRightView(root.getRight(), mxl, level + 1);
		printRightView(root.getLeft(), mxl, level + 1);
	}

	public static void printRightViewWrapper(TreeNode<Integer> root) {
		TreeView.Level l = new TreeView().new Level();
		printRightView(root, l, 1);
	}

	/**
	 * it should be a pre order traversal
	 * 
	 * @param root
	 * @param hd
	 *            -horizontol distance root is 0 left is -1 and right is +1
	 * @param level
	 * @param bottomView
	 */
	public static void printBottomView(TreeNode<Integer> root, int hd, TreeMap<Integer, Integer> bottomView) {
		if (root == null)
			return;
		bottomView.put(hd, root.getData());
		printBottomView(root.getLeft(), hd - 1, bottomView);
		printBottomView(root.getRight(), hd + 1, bottomView);

	}

	/**
	 * ASlso read queue based algo
	 * 
	 * @param root
	 */
	public static void printBottomViewWrapper(TreeNode<Integer> root) {
		TreeMap<Integer, Integer> bottomView = new TreeMap<>();
		printBottomView(root, 0, bottomView);
		for (Integer value : bottomView.values()) {
			System.out.print(value);
		}
	}

	/**
	 * it should be a post order traversal
	 * 
	 * @param root
	 * @param hd
	 *            -horizontol distance root is 0 left is -1 and right is +1
	 * @param level
	 * @param bottomView
	 */
	public static void printTopView(TreeNode<Integer> root, int hd, TreeMap<Integer, Integer> bottomView) {
		if (root == null)
			return;
		printTopView(root.getLeft(), hd - 1, bottomView);
		printTopView(root.getRight(), hd + 1, bottomView);
		bottomView.put(hd, root.getData());

	}

	/**
	 * ASlso read queue based algo
	 * 
	 * @param root
	 */
	public static void printTopViewWrapper(TreeNode<Integer> root) {
		TreeMap<Integer, Integer> bottomView = new TreeMap<>();
		printTopView(root, 0, bottomView);
		for (Integer value : bottomView.values()) {
			System.out.print(value);
		}
	}

	/**
	 * digonal distance for right subtree would be same but for left treee it
	 * would be one more
	 * 
	 * @param root
	 * @param hd
	 *            -horizontol distance root is 0 left is -1 and right is +1
	 * @param level
	 * @param digonalView
	 */
	public static void printDiagonalView(TreeNode<Integer> root, int hd, TreeMap<Integer, List<Integer>> digonalView) {
		if (root == null)
			return;
		if(null !=digonalView.get(hd)){
			digonalView.get(hd).add(root.getData());
		}else{
			List<Integer> val = new ArrayList<>();
			val.add(root.getData());
			digonalView.put(hd,val);
		}
		printDiagonalView(root.getLeft(), hd + 1, digonalView);
		printDiagonalView(root.getRight(), hd, digonalView);

	}

	/**
	 * ASlso read queue based algo
	 * 
	 * @param root
	 */
	public static void printDiagonalViewWrapper(TreeNode<Integer> root) {
		TreeMap<Integer, List<Integer>> diagonalView = new TreeMap<>();
		printDiagonalView(root, 0, diagonalView);
		for (Integer key : diagonalView.keySet()) {
			for (Integer value : diagonalView.get(key)) {
				System.out.print(value);
			}
			System.out.println("");
		}
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
		root.getRight().getRight().setLeft(new TreeNode<Integer>(9));
		root.getRight().getRight().getRight().setLeft(new TreeNode<Integer>(10));
		// printLeftViewWrapper(root);
		// printBottomViewWrapper(root);
		// printTopViewWrapper(root);
		// printRightViewWrapper(root);
		printDiagonalViewWrapper(root);
	}

}
