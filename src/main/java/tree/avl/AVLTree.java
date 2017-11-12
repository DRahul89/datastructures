package main.java.tree.avl;

/**
 *  use where insertion and deletion not more for that use Red black tree bcz of rotation
 * deletion similar to insertion
 *
 */
public class AVLTree {
	/**
	 * A left rotate operation in avl tree for RR(insertion is in Right's right)
	 * case when your right subtree is heavy
	 * 
	 * @param avlNode
	 */
	public static AVLNode leftRotate(final AVLNode avlNode) {
		AVLNode rightLeftNode = avlNode.getRightNode().getLeftNode();
		avlNode.getRightNode().setLeftNode(avlNode);
		avlNode.setRightNode(rightLeftNode);
		avlNode.setHeight(Math.max(avlNode.getLeftNode().getHeight(), avlNode.getRightNode().getHeight()) + 1);
		avlNode.getRightNode().setHeight(Math.max(avlNode.getRightNode().getLeftNode().getHeight(),
				avlNode.getRightNode().getRightNode().getHeight()) + 1);
		return avlNode.getRightNode();
	}

	/**
	 * A right rotate operation in avl tree for LL(insertion is in left's left)
	 * case when your left subtree is heavy
	 * 
	 * @param avlNode
	 */
	public static AVLNode rightRotate(final AVLNode avlNode) {
		AVLNode leftRightNode = avlNode.getLeftNode().getRightNode();
		avlNode.getLeftNode().setRightNode(avlNode);
		avlNode.setLeftNode(leftRightNode);
		avlNode.setHeight(Math.max(avlNode.getLeftNode().getHeight(), avlNode.getRightNode().getHeight()) + 1);
		avlNode.getLeftNode().setHeight(Math.max(avlNode.getLeftNode().getLeftNode().getHeight(),
				avlNode.getLeftNode().getRightNode().getHeight()) + 1);
		return avlNode.getLeftNode();
	}

	/**
	 * Balance factor to decide tree is balance or not
	 * 
	 * @param avlNode
	 * @return
	 */
	public static int getBalanceFactor(final AVLNode avlNode) {
		if (avlNode == null)
			return 0;
		return avlNode.getLeftNode().getHeight() - avlNode.getRightNode().getHeight();
	}

	/**
	 * insert to AVL tree
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public static AVLNode insertToAVL(final AVLNode node, int key) {
		if (node == null)
			return new AVLNode(key);
		if (key < node.getData()) {
			node.setLeftNode(insertToAVL(node.getLeftNode(), key));
		} else if (key > node.getData()) {
			node.setRightNode(insertToAVL(node.getRightNode(), key));
		} else {
			return node;
		}

		node.setHeight(Math.max(node.getLeftNode().getHeight(), node.getRightNode().getHeight()) + 1);
		int balanceFactor = getBalanceFactor(node);
		// LL case
		if (balanceFactor > 1 && key < node.getLeftNode().getData()) {
			return rightRotate(node);
		}

		// LR case
		if (balanceFactor > 1 && key > node.getLeftNode().getData()) {
			node.setLeftNode(leftRotate(node.getLeftNode()));
			rightRotate(node);

		}
		// RR case
		if (balanceFactor < -1 && key > node.getRightNode().getData()) {
			return leftRotate(node);
		}

		// RL case
		if (balanceFactor < -1 && key < node.getRightNode().getData()) {
			node.setRightNode(rightRotate(node.getRightNode()));
			return leftRotate(node);
		}

		return node;

	}

}
