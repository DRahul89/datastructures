package main.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBinaryTreeCompleteOrNot {
	/**
	 * algo is o level order traversal if we found a non full node all following
	 * node must be leaf as a property to complete binary tree and also we have
	 * to check if right subtree of any node is not null then left should not be
	 * null
	 * 
	 * @param root
	 * @return
	 */
	public static boolean iteratiteCheckCompleteOrNot(TreeNode<Integer> root) {
		boolean isFullNode = true;
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> element = queue.poll();
			if (null != element.getLeft()) {
				// we have seen a non full node and we found a node which is not
				// leaf
				if (!isFullNode)
					return false;

				queue.offer(element.getLeft());
			} else {
				isFullNode = false;
			}
			if (null != element.getRight()) {
				// we have seen a non full node and we found a node which is not
				// leaf and also left child not present but right present
				if (!isFullNode)
					return false;
				queue.offer(element.getRight());
			} else {
				isFullNode = false;
			}

		}
		return true;
	}

	public static int getTotalNode(TreeNode<Integer> root) {
		if (null == root)
			return 0;
		return getTotalNode(root.getLeft()) + 1 + getTotalNode(root.getRight());
	}

	/**
	 * algo is we could give index to each node in complete binary tree if index
	 * >=total no of node any point then not complete tree
	 * 
	 * @param root
	 * @return
	 */
	public static boolean recursiveCheckCompleteTreeOrNot(TreeNode<Integer> root, int index, int totalNode) {
		if (root == null)
			return true;
		if (index >= totalNode)
			return false;

		return (recursiveCheckCompleteTreeOrNot(root.getLeft(), 2 * index + 1, totalNode)
				&& recursiveCheckCompleteTreeOrNot(root.getRight(), 2 * index + 2, totalNode));
	}

	/**
	 * This method will create a complete binary tree by linked list algo create
	 * a queue if empty put root there then take front node check if left empty
	 * insert if rigt ionsert if bothh full then deque that node insert the new
	 * node to queue
	 */
	public static void createLinkedCompleteBinaryTree(TreeNode<Integer> root, int data,
			Queue<TreeNode<Integer>> queue) {
		TreeNode<Integer> temp = new TreeNode<Integer>(data);
		if (root.getData() == null) {
			root.setData(temp.getData());
			queue.offer(root);
			return;
		}

		if (queue.peek().getLeft() == null) {
			queue.peek().setLeft(temp);
		} else if (queue.peek().getRight() == null) {
			queue.peek().setRight(temp);
		} else {
			queue.poll();
			createLinkedCompleteBinaryTree(root, data, queue);
			return;
		}

		queue.offer(temp);

	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		/*
		 * root.setLeft(new TreeNode<Integer>(2)); root.setRight(new
		 * TreeNode<Integer>(3)); root.getLeft().setLeft(new
		 * TreeNode<Integer>(4)); root.getLeft().setRight(new
		 * TreeNode<Integer>(5)); root.getRight().setRight(new
		 * TreeNode<Integer>(6)); BinaryTree<Integer> tree = new
		 * BinaryTree<Integer>(root);
		 * System.out.println(recursiveCheckCompleteTreeOrNot(tree.getRoot(), 0,
		 * getTotalNode(tree.getRoot())));
		 * System.out.println(iteratiteCheckCompleteOrNot(tree.getRoot()));
		 */
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		TreeNode<Integer> root12 = new TreeNode<Integer>(null);
		for (int i = 1; i <= 11; i++) {
			createLinkedCompleteBinaryTree(root12, i, queue);
			System.out.println(root12);
		}
		LevelOrderTraversal.levelOrderTraversal(root12);

	}
}
