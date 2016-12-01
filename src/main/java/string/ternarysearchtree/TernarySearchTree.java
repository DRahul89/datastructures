package main.java.string.ternarysearchtree;

/**
 * 
 * A Ternary search tree class
 *
 */
public class TernarySearchTree {
	/**
	 * This method insert a string to TST
	 * 
	 * @param root
	 * @param word
	 * @param position
	 * @return
	 */
	public static TSTNode insertInTST(TSTNode root, final String word,
			final int position) {
		if (null == root) {
			if (word.length() <= position)
				return root;
			root = new TSTNode();
			root.setData(word.charAt(position));
			if (word.length() - 1 == position) {
				root.setEnd(true);
				return root;
			}
			root.setEqualNode(insertInTST(root.getEqualNode(), word,
					position + 1));
		}
		if (word.charAt(position) < root.getData()) {
			root.setLeftNode(insertInTST(root.getLeftNode(), word, position));
		} else if (word.charAt(position) > root.getData()) {
			root.setRightNode(insertInTST(root.getRightNode(), word, position));
		} else {
			root.setEqualNode(insertInTST(root.getEqualNode(), word,
					position + 1));
		}
		return root;
	}

	/**
	 * This method search a string in TST
	 * 
	 * @param root
	 * @param word
	 * @param position
	 * @return
	 */
	public static boolean searchInTST(final TSTNode root, final String word,
			final int position) {
		if (null == root)
			return false;
		if (word.charAt(position) < root.getData()) {
			return searchInTST(root.getLeftNode(), word, position);
		} else if (word.charAt(position) > root.getData()) {
			return searchInTST(root.getRightNode(), word, position);
		} else {
			if (root.isEnd() && position == word.length() - 1) {
				return true;
			} else {
				return searchInTST(root.getEqualNode(), word, position + 1);
			}

		}
	}

	public void printTSTNodes(final TSTNode root) {

	}

	public static void main(String[] args) {
		TSTNode root = insertInTST(null, "boats", 0);
		root = insertInTST(root, "bats", 0);
		System.out.println(searchInTST(root, "boatss", 0));
	}

}
