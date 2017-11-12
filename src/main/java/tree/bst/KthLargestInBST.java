package main.java.tree.bst;
class Counter{
	int count=0;
}
/**
 * do reverse inorder traversal and maintain a count
 * 
 * @author rdixi3
 *
 */
public class KthLargestInBST {

	public static void kLargestElement(BSTNode node, Counter count, int k) {
		if (node == null || count.count > k)
			return;
		kLargestElement(node.getRight(), count, k);
		count.count++;
		if (count.count == k) {
			System.out.println(node.getKey());
			return;
		}

		
		kLargestElement(node.getLeft(), count, k);
	}

	public static void main(String[] args) {

		BSTNode root = new BSTNode(50);
		root.setLeft(new BSTNode(30));
		root.setRight(new BSTNode(70));
		root.getLeft().setLeft(new BSTNode(20));
		root.getLeft().setRight(new BSTNode(40));
		root.getRight().setLeft(new BSTNode(60));
		root.getRight().setRight(new BSTNode(80));
		for (int k = 1; k <= 7; k++) {
		Counter count = new Counter();
			kLargestElement(root, count, k);
		}
	}
}
