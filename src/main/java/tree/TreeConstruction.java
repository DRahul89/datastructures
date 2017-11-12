package main.java.tree;

/**
 * 
 * contains algo to create a tree from (inorder or preorder ) and (inorder or
 * postorder)
 *
 */
public class TreeConstruction {

	private static int preIndex = 0;

	private static int postIndex = 5;

	public static int searchNode(char[] inorder, int start, int end, char nodeVal) {
		int index = -1;
		for (int count = start; count <= end; count++) {
			if (inorder[count] == nodeVal) {
				index = count;
				break;
			}
		}
		return index;
	}

	public static int searchNode(char[] inorder, char nodeVal) {
		int index = -1;
		for (int count = 0; count <= inorder.length; count++) {
			if (inorder[count] == nodeVal) {
				index = count;
				break;
			}
		}
		return index;
	}

	// note same if only inorder traversal given with special case like root is
	// always greater than left and right key in this case search will be
	// converted to max index return function everything else same
	public static TreeNode<Character> buildTreePreAndIn(char[] inArr, char[] preArr, int start, int end) {
		if (start > end)
			return null;
		TreeNode<Character> root = new TreeNode<Character>(preArr[preIndex++]);
		if (start == end)
			return root;
		int index = searchNode(inArr, start, end, root.getData());
		root.setLeft(buildTreePreAndIn(inArr, preArr, start, index - 1));
		root.setRight(buildTreePreAndIn(inArr, preArr, index + 1, end));
		return root;
	}

	/**
	 * algo read from geeks for geeks
	 * 
	 * logic is find start node of pre which will be root in inorder and find
	 * left sub tree and right tree suppose index found in preorder left tree
	 * would be start+1 till index-1 and right index+1 end
	 * 
	 * @param inArr
	 * @param inStart
	 * @param inEnd
	 * @param preArr
	 * @param preStart
	 * @param preEnd
	 */
	public static void printPostOrderTreePreAndInGiven(char[] inArr, int inStart, int inEnd, char[] preArr, int preStart,
			int preEnd) {
		if (inStart > inEnd || preStart > preEnd)
			return;
		int index = -1;
		for (int count = inStart; count <= inEnd; count++) {
			if (inArr[count] == preArr[preStart]) {
				index = count;
				break;
			}
		}
		if (index != inStart )
			printPostOrderTreePreAndInGiven(inArr, inStart, index -1, preArr, preStart + 1, preStart + (index-inStart));

		if (index != inEnd)
			printPostOrderTreePreAndInGiven(inArr, index + 1, inEnd, preArr, preStart + (index-inStart)+1 , preEnd);

		System.out.print(preArr[preStart]);
	}
	
	/**
	 * algo read from geeks for geeks
	 * 
	 * logic is find start node of pre which will be root in inorder and find
	 * left sub tree and right tree suppose index found in preorder left tree
	 * would be start+1 till index-1 and right index+1 end
	 * 
	 * @param inArr
	 * @param inStart
	 * @param inEnd
	 * @param preArr
	 * @param postStart
	 * @param postEnd
	 */
	public static void printPreOrderTreePostAndInGiven(char[] inArr, int inStart, int inEnd, char[] postArr, int postStart,
			int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return;
		int index = -1;
		for (int count = inStart; count <= inEnd; count++) {
			if (inArr[count] == postArr[postEnd]) {
				index = count;
				break;
			}
		}
		System.out.print(postArr[postEnd]);
	
		if (index != inStart)
			printPreOrderTreePostAndInGiven(inArr, inStart, index-1, postArr, postStart , postStart + (index-inStart)-1);

		if (index != inEnd)
			printPreOrderTreePostAndInGiven(inArr, index + 1, inEnd, postArr, postStart + (index-inStart), postEnd-1);
	}
		

	public static TreeNode<Character> buildTreePostAndIn(char[] inArr, char[] postArr, int start, int end) {
		if (start > end)
			return null;
		TreeNode<Character> root = new TreeNode<Character>(postArr[postIndex--]);
		if (start == end)
			return root;
		int index = searchNode(inArr, start, end, root.getData());
		root.setRight(buildTreePostAndIn(inArr, postArr, index + 1, end));
		root.setLeft(buildTreePostAndIn(inArr, postArr, start, index - 1));
		return root;
	}

	/**
	 * algo is build tree with special case where pre order traversal given and
	 * node array given
	 * 
	 * @param preArr
	 * @param preNd
	 * @param len
	 * @return
	 */
	public static TreeNode<Integer> buildTreePreSpecialCase(int[] preArr, char[] preNd, int len) {
		if (preIndex == len)
			return null;
		int index = preIndex;
		TreeNode<Integer> root = new TreeNode<Integer>(preArr[preIndex++]);

		if (preNd[index] == 'N') {
			root.setLeft(buildTreePreSpecialCase(preArr, preNd, len));
			root.setRight(buildTreePreSpecialCase(preArr, preNd, len));
		}
		return root;
	}

	/**
	 * very imp point in case of post and in right construction first why(bcz
	 * inorder LNR and pre NLR and post LRN)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		char post[] = new char[] { 'D', 'E', 'B', 'F', 'C', 'A' };
		int len = in.length;
		// TreeNode<Character> root = buildTreePreAndIn(in, pre, 0, len - 1);
		// System.out.println(root);
		// root = buildTreePostAndIn(in, post, 0, len - 1);
		// System.out.println(root);

		int pre2[] = new int[] { 10, 30, 20, 5, 15 };
		char preLN[] = new char[] { 'N', 'N', 'L', 'L', 'L' };
		int n = pre.length;
		// System.out.println(buildTreePreSpecialCase(pre2,preLN,n));
		printPostOrderTreePreAndInGiven(in, 0, len, pre, 0, len-1);
		System.out.println();
		printPreOrderTreePostAndInGiven(in, 0, len, post, 0, len-1);
	}

}
