package main.java.tree;

public class VerticalSum {

	public class HorzontalDistance {
		int minHD;
		int maxHD;
	}

	public static void minAndMaxHorizontolDistance(TreeNode<Integer> root, HorzontalDistance hd, int horDist) {
		if (root == null)
			return;
		if (horDist < hd.minHD) {
			hd.minHD = horDist;
		}
		if (horDist > hd.maxHD) {
			hd.maxHD = horDist;
		}
		minAndMaxHorizontolDistance(root.getLeft(), hd, horDist - 1);
		minAndMaxHorizontolDistance(root.getRight(), hd, horDist + 1);
	}

	public static void verticalOrderTraversal(TreeNode<Integer> root, int lineNo, int hd) {
		if (root == null)
			return;
		if (hd == lineNo)
			System.out.print(root.getData() + " ");

		verticalOrderTraversal(root.getLeft(), lineNo, hd - 1);
		verticalOrderTraversal(root.getRight(), lineNo, hd + 1);

	}

	public static void verticalOrderTraversalWrapper(TreeNode<Integer> root) {
		VerticalSum.HorzontalDistance hd = new VerticalSum().new HorzontalDistance();
		minAndMaxHorizontolDistance(root, hd, 0);
		for (int vertical = hd.minHD; vertical <= hd.maxHD; vertical++) {
			verticalOrderTraversal(root,vertical, 0);
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
		verticalOrderTraversalWrapper(root);
	}
}
