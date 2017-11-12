package main.java.tree.bst;

import java.util.Stack;

/**
 * 
 * if they are balanced BSTs then merge them by first convert both to dll then
 * merge two dlls then construct a balanced tree but here tree are not balanced
 *
 */
public class MergeTwoBSTs {

	public static void inorder(BSTNode bstNode) {
		if (bstNode == null)
			return;
		inorder(bstNode.getLeft());
		System.out.println(bstNode.getKey());
		inorder(bstNode.getRight());
	}

	/**
	 * algo is use iterative inorder traversal use two stack
	 * 
	 * @param first
	 * @param second
	 */
	public static void mergeTwoBSTs(final BSTNode first, final BSTNode second) {
		Stack<BSTNode> firstStack = new Stack<>();
		Stack<BSTNode> secondStack = new Stack<>();
		BSTNode current1 = first;
		BSTNode current2 = second;
		while (current1 != null || current2 != null || !firstStack.isEmpty() || !secondStack.isEmpty()) {
			if (current1 != null || current2 != null) {
				if (current1 != null) {
					firstStack.push(current1);
					current1 = current1.getLeft();
				}
				if (current2 != null) {
					secondStack.push(current2);
					current2 = current2.getLeft();
				}
			} else {
				// first tree exhausted print other tree
				if (firstStack.isEmpty()) {
					while (!secondStack.isEmpty()) {
						BSTNode temp = secondStack.pop();
						temp.setLeft(null);// bcz left node already printed
						inorder(temp);
					}
				}
				// second tree exhausted print other tree
				if (secondStack.isEmpty()) {
					while (!firstStack.isEmpty()) {
						BSTNode temp = firstStack.pop();
						temp.setLeft(null);// bcz left node already printed
						inorder(temp);
					}
				}

				current1 = firstStack.pop();
				current2 = secondStack.pop();
				if (current1.getKey() < current2.getKey()) {
					System.out.println(current1.getKey());
					secondStack.push(current2);
					current2 = null;
				} else {
					System.out.println(current2.getKey());
					firstStack.push(current1);
					current1 = null;
				}
			}
		}
	}
}
