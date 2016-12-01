package main.java.tree;

/**
 * Algo post order traverse find diff between subtrees and node if its positive
 * then add to node if its nehgative then increment the left subtree if not null
 * otherwise right sub tree
 * 
 * @author rdixi7
 *
 */
public class ChildrenSumProperty {

	public static void convertToChildrenSum(TreeNode<Integer> node) {
		if (node == null || (node.getLeft() == null && node.getRight() == null)) {
			return;
		} else {
			convertToChildrenSum(node.getLeft());
			convertToChildrenSum(node.getRight());
			int leftVal = node.getLeft() != null ? node.getLeft().getData() : 0;
			int rightVal = node.getRight() != null ? node.getRight().getData() : 0;
			int diff = (leftVal + rightVal) - node.getData();
			if (diff > 0) {
				node.setData(node.getData() + diff);
			} else {
				increment(node,-diff);
			}
		}
	}

	private static void increment(TreeNode<Integer> node, int diff) {
		if(node.getLeft() != null){
			node.getLeft().setData(node.getLeft().getData()+diff);
			increment(node.getLeft(),diff);
		}else if(node.getRight() != null){
			node.getRight().setData(node.getRight().getData()+diff);
			increment(node.getRight(),diff);
		}
		
	}

}