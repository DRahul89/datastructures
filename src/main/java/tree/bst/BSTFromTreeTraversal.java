package main.java.tree.bst;

class Index {
	int index = 0;
}

/**
 * algo is set range min amd max
 * 
 * @author rdixi3
 *
 */
public class BSTFromTreeTraversal {
	
	

	public static BSTNode constructBSTPre(int[] pre) {
		Index index = new Index();
		return constructBSTPreUtil(pre, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static BSTNode constructBSTPreUtil(int[] pre, Index index, int min, int max) {
		if (index.index >= pre.length)
			return null;
		int key = pre[index.index];
		BSTNode node = null;
		if (key > min && key < max) {
			index.index++;
			node = new BSTNode(key);
			node.setLeft(constructBSTPreUtil(pre, index, min, key));
			node.setRight(constructBSTPreUtil(pre, index, key, max));
		}
		return node;
	}
	
	public static BSTNode constructBSTPost(int[] post) {
		Index index = new Index();
		index.index=post.length-1;
		return constructBSTPostUtil(post, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static BSTNode constructBSTPostUtil(int[] post, Index index, int min, int max) {
		if (index.index < 0)
			return null;
		int key = post[index.index];
		BSTNode node = null;
		if (key > min && key < max) {
			index.index--;
			node = new BSTNode(key);
			node.setRight(constructBSTPostUtil(post, index, key, max));
			node.setLeft(constructBSTPostUtil(post, index, min, key));
		}
		return node;
	}

	public static void main(String[] args) {
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int post[] = new int[] { 1,7,5,50,40,10 };
		System.out.println(constructBSTPost(post));
	}

}
