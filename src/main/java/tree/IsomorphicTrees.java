package main.java.tree;

/**
 * Two trees are known as isomorphic if after some flips of left vand right they
 * are equal
 * 
 * algo for two nodes n1 and n2 1.data must be equal n1.data=n2.data 2.at least
 * one of two case must true (i)left of n1 and left of n2 and right of n1 and
 * right of n2 must be isomorphic (ii)left of n1 and right of n2 and right of n1
 * and left of n2 must be isomorphic time compelxityO(m+n)
 *
 */
public class IsomorphicTrees {

	public static boolean isIsomorphic(final TreeNode<Integer> root1, final TreeNode<Integer> root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		return ((isIsomorphic(root1.getLeft(), root2.getLeft()) && isIsomorphic(root1.getRight(), root2.getRight()))
				|| (isIsomorphic(root1.getLeft(), root2.getRight())
						&& isIsomorphic(root1.getRight(), root2.getLeft())));
	}

}
