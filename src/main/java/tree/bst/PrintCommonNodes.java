package main.java.tree.bst;

import java.util.Stack;

/**
 * common nodes in two BST one algo is inorer both tree store in array then
 * intersection of array order n time and o n space second algo use two stack
 * and iterative inorder traversal
 */
public class PrintCommonNodes {

	public static void printCommonNodes(BSTNode root1, BSTNode root2) {
		Stack<BSTNode> s1 = new Stack<>();
		Stack<BSTNode> s2 = new Stack<>();
		while (true) {
			if (root1 != null) {
				s1.push(root1);
				root1 = root1.getLeft();
			} else if (root2 != null) {
				s2.push(root2);
				root2 = root2.getLeft();
			} else if (!s1.isEmpty() && !s2.isEmpty()) {
				 root1=s1.peek();
				 root2=s2.peek();
				if (root1.getKey() == root2.getKey()) {
					System.out.println(root1.getKey());
					s1.pop();
					s2.pop();
					root1 = root1.getRight();
					root2 = root2.getRight();
				} else if (root1.getKey() < root2.getKey()) {
					s1.pop();
					root1 = root1.getRight();
					root2 = null;
				} else if (root1.getKey() > root2.getKey()) {
					s2.pop();
					root2 = root2.getRight();
					root1 = null;
				}
			} else {
				break;
			}
		}

	}
public static void main(String[] args) {
	BSTNode first = new BSTNode(5);
	first.setLeft(new BSTNode(1));
	first.setRight(new BSTNode(10));
	first.getLeft().setLeft(new BSTNode(0));
	first.getLeft().setRight(new BSTNode(4));
	first.getRight().setLeft(new BSTNode(7));
	first.getRight().getLeft().setRight(new BSTNode(9));
	
	
	BSTNode second = new BSTNode(10);
	second.setLeft(new BSTNode(7));
	second.setRight(new BSTNode(20));
	second.getLeft().setLeft(new BSTNode(4));
	second.getLeft().setRight(new BSTNode(9));
	
	printCommonNodes(first, second);
	
}
}
