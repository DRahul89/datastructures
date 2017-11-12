package main.java.tree;

import java.util.Stack;

public class TreeTraversalWithoutRecursion {

	/**
	 * 1.algo is take a stack and take one pointer current=root; 2.now push to
	 * stack till current->left != null 3. Now when null comes pop the stack
	 * print the element make current = right of popped and go to step 2
	 * 
	 * @param root
	 */
	public static void inorderTraversal(TreeNode root) {
		TreeNode current = root;
		if (null == root)
			return;
		Stack<TreeNode> stack = new Stack<>();
		current = pushLeftMost(current, stack);
		while (stack.size() > 0) {
			TreeNode node = stack.pop();
			System.out.print(node.getData() + " ");
			if (node.getRight() != null) {
				current = node.getRight();
				pushLeftMost(current, stack);
			}
		}

	}

	private static TreeNode pushLeftMost(TreeNode current, Stack<TreeNode> stack) {
		while (current != null) {
			stack.push(current);
			current = current.getLeft();
		}
		return current;
	}

	/**
	 * algo take a stack push root then while stack not empty pop element push
	 * right then left
	 * 
	 * @param root
	 */
	public static void preOrderTraversal(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode<Integer> visitedelem = s.pop();
			System.out.print(visitedelem.getData());
			if (null != visitedelem.getRight()) {
				s.push(visitedelem.getRight());
			}
			if (null != visitedelem.getLeft()) {
				s.push(visitedelem.getLeft());
			}
		}
	}

	/**
	 * Algo is based on fact reverse of postorder traversal is preorder
	 * with(NRL) so take 2 stacks
	 * 
	 * @param root
	 */
	public static void postOrderTraversal(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> s1 = new Stack<>();
		Stack<TreeNode<Integer>> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode<Integer> visitedelem = s1.pop();
			s2.push(visitedelem);
			if (null != visitedelem.getLeft()) {
				s1.push(visitedelem.getLeft());
			}
			if (null != visitedelem.getRight()) {
				s1.push(visitedelem.getRight());
			}
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().getData());
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);
		System.out.println(tree);
		// inorderTraversal(tree.getRoot());
		//preOrderTraversal(root);
		postOrderTraversal(root);

	}
}
