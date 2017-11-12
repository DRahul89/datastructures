package main.java.tree.bst;

class Count {
	public int count = 0;
}

public class BSTRangeTypeQuestions {

	/**
	 * count node in range
	 * 
	 * @param root
	 * @param low
	 * @param high
	 * @return
	 */
	public static int countNodeInRange(BSTNode root, int low, int high) {
		if (root == null)
			return 0;
		if (root.getKey() >= low && root.getKey() <= high) {
			return 1 + countNodeInRange(root.getLeft(), low, high) + countNodeInRange(root.getRight(), low, high);
		}
		if (root.getKey() <= low) {
			return countNodeInRange(root.getRight(), low, high);
		}
		if (root.getKey() > low) {
			return countNodeInRange(root.getLeft(), low, high);
		}

		return -1;
	}

	/**
	 * count subtrees in range
	 * 
	 * @param root
	 * @param low
	 * @param high
	 * @return
	 */
	public static boolean countSubTreesInRange(BSTNode root, int low, int high, Counter count) {
		if (root == null)
			return true;
		boolean isLeft = countSubTreesInRange(root.getLeft(), low, high, count);
		boolean isRight = countSubTreesInRange(root.getRight(), low, high, count);
		if (isLeft && isRight && root.getKey() >= low && root.getKey() <= high) {
			count.count = count.count + 1;
			return true;
		}
		return false;

	}
	
	public static void main(String[] args) {
		Counter count = new Counter();
		BSTNode root = new BSTNode(10);
		root.setLeft(new BSTNode(5));
		root.setRight(new BSTNode(50));
		root.getLeft().setLeft(new BSTNode(1));
		root.getLeft().setRight(new BSTNode(40));
		root.getRight().setRight(new BSTNode(100));
		countSubTreesInRange(root, 1, 45, count);
		System.out.println(count.count);
	}

}
