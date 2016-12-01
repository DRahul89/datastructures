package main.java.tree;

import main.java.queue.LLQueue;
import main.java.stack.LLStack;

public class LevelOrderTraversal {

	public static void levelOrderTraversal(TreeNode root) {
		LLQueue<TreeNode<Integer>> queue = new LLQueue<>();
		queue.enQueue(root);
		queue.enQueue(null);
		while (!queue.isEmpty()) {
			TreeNode<Integer> temp = queue.deQueue();
			if (temp == null) {
				System.out.println();
				if (queue.peek() != null)
					queue.enQueue(null);
			} else {
				System.out.print(temp.getData() + " ");
				if (temp.getLeft() != null) {
					queue.enQueue(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.enQueue(temp.getRight());
				}
			}

		}
	}

	public static void spiralLevelOrderTraversal(TreeNode root) {
		LLStack<TreeNode<Integer>> s1 = new LLStack<>();
		LLStack<TreeNode<Integer>> s2 = new LLStack<>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				TreeNode<Integer> temp = s1.pop();
				System.out.print(temp.getData());
				if (temp.getRight() != null) {
					s2.push(temp.getRight());
				}
				if (temp.getLeft() != null) {
					s2.push(temp.getLeft());
				}
			}
			System.out.println();
			while (!s2.isEmpty()) {
				TreeNode<Integer> temp = s2.pop();
				System.out.print(temp.getData());
				if (temp.getLeft() != null) {
					s1.push(temp.getLeft());
				}
				if (temp.getRight() != null) {
					s1.push(temp.getRight());
				}
			}
			System.out.println();
		}

	}

	public static void levelOrderTraversalSec(TreeNode root) {
		int height = heightOfTree(root);
		System.out.println("height " + height);
		for (int i = 1; i <= height; i++) {
			printTreeLevel(root, i);
			System.out.println();
		}
	}

	public static int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		else
			return Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight())) + 1;
	}

	public static void printTreeLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.getData());
		else if (level > 1) {
			printTreeLevel(root.getLeft(), level - 1);
			printTreeLevel(root.getRight(), level - 1);
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
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);

		System.out.println(tree);

		System.out.println("level order traversal of binary tree is ");
		levelOrderTraversal(tree.getRoot());
		levelOrderTraversalSec(tree.getRoot());
		System.out.println();
		spiralLevelOrderTraversal(tree.getRoot());
	}

}
