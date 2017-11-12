package main.java.tree.inordersuccesor;

/**
 * because in reverse inorder traversal you go RNL so you could make the last
 * visited as next inorder successor think
 * 
 * @author rdixi3
 *
 */
public class PopulateInorderSuccessor {

	private static TreeNodeWithNext<Integer> nextNode = null;

	public static void populateInorderSuccessor(TreeNodeWithNext<Integer> node) {
		if (node != null) {
			populateInorderSuccessor(node.getRight());
			node.setNext(nextNode);
			nextNode = node;
			populateInorderSuccessor(node.getLeft());
		}

	}

}
