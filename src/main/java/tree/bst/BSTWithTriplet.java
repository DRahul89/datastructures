package main.java.tree.bst;

public class BSTWithTriplet {
	private static int index = 0;
	private static BSTNode previous = null;

	public static void inorderArray(BSTNode bstNode, Integer[] arr) {
		if (bstNode == null)
			return;
		inorderArray(bstNode.getLeft(), arr);
		arr[index++] = bstNode.getKey();
		inorderArray(bstNode.getRight(), arr);
	}

	public static boolean isTripletExistWithZeroSum(Integer[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			int l = i + 1;
			int r = arr.length - 1;
			while (l < r) {
				if (arr[i] + arr[l] + arr[r] == 0)
					return true;
				else if (arr[i] + arr[l] + arr[r] < 0) {
					l++;
				} else if (arr[i] + arr[l] + arr[r] > 0) {
					r--;
				}
			}
		}
		return false;
	}

	public static BSTNode convertTreeToDoublyList(BSTNode root) {
		if (null == root)
			return null;
		fixLeftPointers(root);

		return fixRightPoinetrs(root);
	}

	private static BSTNode fixRightPoinetrs(BSTNode root) {
		BSTNode node = null;
		while (null != root && root.getRight() != null)
			root = root.getRight();
		while (root != null && root.getLeft() != null) {
			node = root;
			root = root.getLeft();
			root.setRight(node);
		}
		return root;
	}

	private static void fixLeftPointers(BSTNode root) {
		if (root == null)
			return;
		fixLeftPointers(root.getLeft());
		root.setLeft(previous);
		previous = root;
		fixLeftPointers(root.getRight());

	}

	public static BSTNode mergeTwoSortedDLL(BSTNode first, BSTNode second) {
		BSTNode root = null;
		if (first == null)
			return second;
		if (second == null)
			return first;
		if (first.getKey() < second.getKey()) {
			root = first;
			second.setLeft(first);
			root.setRight(mergeTwoSortedDLL(first.getRight(), second));
		} else {
			root = second;
			first.setLeft(second);
			root.setRight(mergeTwoSortedDLL(first, second.getRight()));
		}
		return root;
	}

	public static BSTNode getMiddleNodeofDLL(BSTNode root, int start, int end) {
		if (root == null)
			return null;
		while (root != null && start != end) {
			root = root.getRight();
			start++;
			end--;
		}
		return root;
	}

	public static BSTNode convertSortedDLLtoBST(BSTNode root, int start, int end) {
		if (root == null)
			return null;
		BSTNode node = getMiddleNodeofDLL(root, start, end);
		int mid = (start + end) / 2;
		node.setLeft(convertSortedDLLtoBST(root, start, mid - 1));
		node.setLeft(convertSortedDLLtoBST(root, mid + 1, end));
		return node;
	}

	public static boolean isTripletExistWithZeroSumDoublyList(BSTNode root) {
		if (root == null)
			return false;
		BSTNode tail = null;
		BSTNode head = root;
		while (root.getRight() != null) {
			tail = root;
			root = root.getRight();
		}
		while (head != tail.getLeft()) {
			BSTNode headNext = head.getRight();
			BSTNode tailPointer = tail;
			while (headNext != tailPointer) {
				if (head.getKey() + headNext.getKey() + tailPointer.getKey() == 0)
					return true;
				else if (head.getKey() + headNext.getKey() + tailPointer.getKey() < 0) {
					headNext = headNext.getRight();
				} else if (head.getKey() + headNext.getKey() + tailPointer.getKey() > 0) {
					tailPointer = tailPointer.getLeft();
				}
			}
			head = head.getRight();
		}
		return false;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[7];
		BinarySearchTree bst = new BinarySearchTree();

		bst.root = bst.insertRec(bst.root, 5);
		bst.root = bst.insertRec(bst.root, -11);
		bst.root = bst.insertRec(bst.root, 9);
		bst.root = bst.insertRec(bst.root, 6);
		bst.root = bst.insertRec(bst.root, 10);
		bst.root = bst.insertRec(bst.root, 12);
		bst.root = bst.insertRec(bst.root, 19);
		inorderArray(bst.root, arr);
		System.out.println(isTripletExistWithZeroSum(arr));

		System.out.println(isTripletExistWithZeroSumDoublyList(convertTreeToDoublyList(bst.root)));
	}
}
