package main.java.tree.inordersuccesor;

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
