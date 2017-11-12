package main.java.tree.ternarysearchtree;

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
	public static TSTNode insertInTST(TSTNode root, final String word, final int position) {
		if (null == root) {
			if (word.length() <= position)
				return root;
			root = new TSTNode();
			root.setData(word.charAt(position));
		}
		if (word.charAt(position) < root.getData()) {
			root.setLeftNode(insertInTST(root.getLeftNode(), word, position));
		} else if (word.charAt(position) > root.getData()) {
			root.setRightNode(insertInTST(root.getRightNode(), word, position));
		} else {
			if (word.length() > position + 1) {
				root.setEqualNode(insertInTST(root.getEqualNode(), word, position + 1));
			} else {
				root.setEnd(true);
			}
		}
		return root;
	}

	/**
	 * This method delete a string from TST by just making is End false
	 * 
	 * @param root
	 * @param word
	 * @param position
	 * @return
	 */
	public static void deleteInTST(TSTNode root, final String word, final int position) {
		if (null == root) {
			return;
		}
		if (word.charAt(position) < root.getData()) {
			deleteInTST(root.getLeftNode(), word, position);
		} else if (word.charAt(position) > root.getData()) {
			deleteInTST(root.getRightNode(), word, position);
		} else {
			if (word.length() - 1 == position && root.isEnd()) {
				root.setEnd(false);
			}
			if (word.length() > position + 1) {
				deleteInTST(root.getEqualNode(), word, position + 1);
			}
		}
	}

	/**
	 * This method search a string in TST
	 * 
	 * @param root
	 * @param word
	 * @param position
	 * @return
	 */
	public static boolean searchInTST(final TSTNode root, final String word, final int position) {

		if (null == root)
			return false;
		if (word.charAt(position) < root.getData()) {
			return searchInTST(root.getLeftNode(), word, position);
		} else if (word.charAt(position) > root.getData()) {
			return searchInTST(root.getRightNode(), word, position);
		} else {
			if (root.isEnd() && position == word.length() - 1) {
				return true;
			}
			if (position == word.length() - 1) {
				return false;
			} else {
				return searchInTST(root.getEqualNode(), word, position + 1);
			}

		}
	}

	public static void traverseTST(final TSTNode root, char[] buffer, final int position) {
		if (root == null)
			return;
		
		traverseTST(root.getLeftNode(), buffer, position);
		buffer[position] = root.getData();
		if (root.isEnd()) {
			buffer[position + 1] = '\0';
			System.out.println(buffer);

		}
		traverseTST(root.getEqualNode(), buffer, position + 1);
		traverseTST(root.getRightNode(), buffer, position);

	}

	public void printTSTNodes(final TSTNode root) {

	}

	public static void main(String[] args) {
		TSTNode root = insertInTST(null, "boats", 0);
		root = insertInTST(root, "bats", 0);
		// System.out.println(searchInTST(root, "batss", 0));
		// deleteInTST(root, "bats", 0);
		char[] buffer = new char[1000];
		traverseTST(root, buffer, 0);
	}

}
