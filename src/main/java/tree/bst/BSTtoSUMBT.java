package main.java.tree.bst;

class Sum {
	int sum = 0;
}

public class BSTtoSUMBT {

	/**
	 * algo is reverse inorder traversal and keep track of sum till now
	 * 
	 * @param root
	 */
	public static void converetBSTtoSumTree(BSTNode root, Sum sum) {
		if (root == null)
			return;
		converetBSTtoSumTree(root.getRight(), sum);
		root.setKey(root.getKey() + sum.sum);
		sum.sum = root.getKey();
		converetBSTtoSumTree(root.getLeft(), sum);

	}

	public static void main(String[] args) {
		BSTNode root = new BSTNode(5);
		root.setLeft(new BSTNode(2));
		root.setRight(new BSTNode(13));
		Sum sum = new Sum();
		converetBSTtoSumTree(root,sum);
		System.out.println(root);
	}
}
