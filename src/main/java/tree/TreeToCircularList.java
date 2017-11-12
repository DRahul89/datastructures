package main.java.tree;

public class TreeToCircularList {

	private static TreeNode<Integer> previous = null;

	private TreeNode<Integer> previousNS = null;

	private static TreeNode<Integer> head = null;

	/**
	 * left contain previous and right pointer contains next
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public static TreeNode<Integer> concatenateTwoCircularList(TreeNode<Integer> leftList,
			TreeNode<Integer> rightList) {
		if (null == leftList)
			return rightList;
		if (null == rightList)
			return leftList;
		// get the last node of left list since its a circular list
		TreeNode<Integer> leftLast = leftList.getLeft();
		// get the last node of right list since its a circular list
		TreeNode<Integer> rightLast = rightList.getLeft();

		leftLast.setRight(rightList);
		rightList.setLeft(leftLast);
		rightLast.setRight(leftList);
		leftList.setLeft(rightLast);
		return leftList;

	}

	/**
	 * algo 1.make a general concatenate function to concatenate two list in to
	 * one 2.convert left tree to list 3.convert right tree to list
	 * 4.concatenate left with root and then with right
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode<Integer> convertTreeToCircularList(TreeNode<Integer> root) {
		if (null == root)
			return null;
		TreeNode<Integer> left = convertTreeToCircularList(root.getLeft());
		TreeNode<Integer> right = convertTreeToCircularList(root.getRight());

		root.setLeft(root);
		root.setRight(root);

		return concatenateTwoCircularList(concatenateTwoCircularList(left, root), right);
	}

	public static void printCircular(TreeNode<Integer> root) {
		TreeNode<Integer> current = root.getRight();
		System.out.print(root.getData() + "-->");
		while (!root.getData().equals(current.getData())) {
			System.out.print(current.getData() + "-->");
			current = current.getRight();
		}
	}

	/**
	 * algo for doubly list is simple 1.fix left pointesr we traverse the
	 * inorder way and keep track the previously visited node then make all left
	 * to points it 2.now fix right pointers for that we take help of first step
	 * since all left nodes are fixed we traverse the whole list and fix the
	 * right pointers we start from right most node of the tree bcz this would
	 * be the last node of list
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode<Integer> convertTreeToDoublyList(TreeNode<Integer> root) {
		if (null == root)
			return null;
		fixLeftPointers(root);

		return fixRightPoinetrs(root);
	}

	private static TreeNode<Integer> fixRightPoinetrs(TreeNode<Integer> root) {
		TreeNode<Integer> node = null;
		while (null != root && root.getRight() != null)
			root = root.getRight();
		while (root != null && root.getLeft() != null) {
			node = root;
			root = root.getLeft();
			root.setRight(node);
		}
		return root;
	}

	private static void fixLeftPointers(TreeNode<Integer> root) {
		if (root == null)
			return;
		fixLeftPointers(root.getLeft());
		root.setLeft(previous);
		previous = root;
		fixLeftPointers(root.getRight());

	}

	private static void printDoubly(final TreeNode<Integer> root) {
		TreeNode<Integer> node = root;
		while (node != null) {
			System.out.print(node.getData() + "==>");
			node = node.getRight();
		}
	}

	public TreeNode<Integer> createDLLFromLeaf(TreeNode<Integer> root) {
		if (root == null)
			return null;
		if (root.getLeft() == null && root.getRight() == null) {
			if (head == null) {
				head = root;
			} else {
				root.setLeft(previousNS);
				previousNS.setRight(root);
			}
			previousNS = root;
			return null;
		}
		root.setLeft(createDLLFromLeaf(root.getLeft()));
		root.setRight(createDLLFromLeaf(root.getRight()));
		return root;
	}

	/**
	 * Simple of all just do inorder traversal and keep track of previous node
	 * 
	 * @param root
	 * @return
	 */
	public  void convertTreeToDoublyListByInorderTraversal(TreeNode<Integer> root) {
		if (null == root)
			return ;
		convertTreeToDoublyListByInorderTraversal(root.getLeft());
		if (previous == null) {
			head = root;
		} else {
			root.setLeft(previous);
			previous.setRight(root);
		}
		previous=root;
		convertTreeToDoublyListByInorderTraversal(root.getRight());

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
		// printCircular(convertTreeToCircularList(root));
		//printDoubly(convertTreeToDoublyList(root));
		new TreeToCircularList().convertTreeToDoublyListByInorderTraversal(root);
		printDoubly(head);
	}
}
